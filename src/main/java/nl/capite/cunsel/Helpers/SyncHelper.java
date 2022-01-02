package nl.capite.cunsel.Helpers;

import nl.capite.cunsel.exceptions.UncompatibleClasses;
import nl.capite.cunsel.interfaces.GenericIdInterface;
import nl.capite.cunsel.models.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class SyncHelper implements  Runnable {
    private final Properties prop;
    private final DbHelper dbh;
    private final iexHelper iex;
    private boolean runThread=false;

    public SyncHelper(Properties prop) throws SQLException {
        this.prop=prop;
        this.dbh= new DbHelper(
                prop.getProperty("spring.datasource.url"),
                prop.getProperty("spring.datasource.username"),
                prop.getProperty("spring.datasource.password")
        );
        this.iex = new iexHelper(prop.getProperty("iex.apikey"));
    }

    public void sync() {

    }

    public <T extends GenericIdInterface> syncGenericResult GenericObjectSync(HashMap<String, T> oldObjects, List<T> newObjects) throws UncompatibleClasses {
        String className = newObjects.get(0).getClass().getName();
        for(GenericIdInterface x:oldObjects.values()) {
            if(!x.getClass().getName().equals(className)) {
                throw  new UncompatibleClasses(className,x.getClass().getName());
            }
        }
        for(GenericIdInterface x:newObjects) {
            if(!x.getClass().getName().equals(className)) {
                throw  new UncompatibleClasses(className,x.getClass().getName());
            }
        }

        List<T> insertables = new ArrayList<T>();
        List<T> updateables = new ArrayList<T>();
        List<T> deleteables = new ArrayList<T>();

        oldObjects.values().forEach(deleteables::add);

        for (T o:newObjects) {
            deleteables.remove(o);
            if(!oldObjects.containsKey(o.getGenericId())) {
                insertables.add(o);
            } else if(oldObjects.containsKey(o.getGenericId())) {
                var OldObj = oldObjects.get(o.getGenericId());
                if(!OldObj.equals(o)) {
                    updateables.add(o);
                }
            }
        }

        return new syncGenericResult(
                insertables,
                updateables,
                deleteables.stream().map(n -> n.getGenericId()).collect(Collectors.toList())
        );
    }

    public void  syncCompanies() throws SQLException, IOException, UncompatibleClasses {
        List<String> tickers = dbh.getTickers();

        ArrayList<Company> comps = (ArrayList<Company>) iex.getCompanies(tickers);
        HashMap<String, Company> hm = dbh.getCompaniesMap();

        syncGenericResult sgr = GenericObjectSync(hm,comps);

        dbh.insertCompanies((List<Company>) sgr.getInsertables());
        dbh.updateCompanies((List<Company>) sgr.getUpdateables());
        dbh.deleteCompanies(sgr.getDeleteables());
    }

    public void syncLogos() throws SQLException, IOException, UncompatibleClasses {
        List<String> tickers = dbh.getTickers();

        ArrayList<Logo> logos = (ArrayList<Logo>) iex.getLogos(tickers);
        HashMap<String, Logo> hm = dbh.getLogosMap();

        syncGenericResult sgr = GenericObjectSync(hm,logos);

        dbh.insertLogos((List<Logo>) sgr.getInsertables());
        dbh.updateLogos((List<Logo>) sgr.getUpdateables());
        dbh.deleteLogos(sgr.getDeleteables());
    }

    public void syncStatsBasic() throws SQLException, IOException, UncompatibleClasses {
        List<String> tickers = dbh.getTickers();

        ArrayList<StatsBasic> stats = (ArrayList<StatsBasic>) iex.getStatsBasic(tickers);
        HashMap<String, StatsBasic> hm = dbh.getStatsBasicMap();

        syncGenericResult sgr = GenericObjectSync(hm,stats);

        dbh.insertStasBasic((List<StatsBasic>) sgr.getInsertables());
        dbh.updateStatsBasic((List<StatsBasic>) sgr.getUpdateables());
        dbh.deleteStatsBasic(sgr.getDeleteables());
    }

    public void SyncRefSymbols() throws SQLException, IOException, UncompatibleClasses {
        List<refSymbol> symbols = iex.getSymbols();
        nqHelper nq = new nqHelper();
        List<String> ls = nq.GetNQ100();
        symbols = symbols.stream().filter(n->ls.contains(n.getSymbol())).collect(Collectors.toList());

        HashMap<String, refSymbol> hm = dbh.getRefSymbolsMap();

        syncGenericResult sgr = GenericObjectSync(hm,symbols);

        dbh.insertRefSymbols((List<refSymbol>) sgr.getInsertables());
        dbh.updateRefSymbols((List<refSymbol>) sgr.getUpdateables());
        dbh.deleteRefSymbols(sgr.getDeleteables());
    }

    public boolean getRunThread() {
        return this.runThread;
    }

    public void setRunThread(boolean bool) {
        this.runThread=bool;
    }



    @Override
    public void run() {
        this.runThread=true;
        while (this.runThread==true) {
            Thread t1 = new Thread(() -> {
                try {
                    this.SyncRefSymbols();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (UncompatibleClasses uncompatibleClasses) {
                    uncompatibleClasses.printStackTrace();
                }
            });
            Thread t2 = new Thread(() -> {
                try {
                    this.syncCompanies();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (UncompatibleClasses uncompatibleClasses) {
                    uncompatibleClasses.printStackTrace();
                }
            });
            Thread t3 = new Thread(() -> {
                try {
                    this.syncLogos();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (IOException | UncompatibleClasses e) {
                    e.printStackTrace();
                }
            });
            Thread t4 = new Thread(() -> {
               try {
                   this.syncStatsBasic();
               }catch (SQLException e) {
                   e.printStackTrace();
               } catch (IOException | UncompatibleClasses e) {
                   e.printStackTrace();
               }
            });

            t1.start();
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t2.start();
            t3.start();
            t4.start();

            try {
                t2.join();
                t3.join();
                t4.join();
                this.runThread=false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
