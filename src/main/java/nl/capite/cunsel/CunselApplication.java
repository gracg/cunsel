package nl.capite.cunsel;

import nl.capite.cunsel.Helpers.DbHelper;
import nl.capite.cunsel.Helpers.SyncHelper;
import nl.capite.cunsel.Helpers.iexHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.convert.Property;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.stream.Collectors;


@SpringBootApplication
@Command
public class CunselApplication implements Runnable {

    @Option(names = {"--web","-w"},description = "Start Spring Boot")
    boolean webFlag = false;
    @Option(names = {"--sync","-s"},description = "Sync IEX to local Database")
    boolean syncFlag = false;
    @Option(names = {"--createdb","-cdb"},description = "Creates database, Drops Database if exists")
    boolean dbFlag = false;

    private String[] arg;

    public CunselApplication(String[] args) {
        this.arg=args;
    }

    public static void main(String[] args) {
        new CommandLine(new CunselApplication(args)).execute(args);
    }

    @Override
    public void run() {
        Properties prop=null;
        try {
            prop = util.getProperties();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        if(dbFlag) {
            try {
                var db = new DbHelper(
                        prop.getProperty("spring.datasource.url"),
                        prop.getProperty("spring.datasource.username"),
                        prop.getProperty("spring.datasource.password")
                );
                db.dropTables();
                db.CreateTables();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(webFlag) {
            SpringApplication.run(CunselApplication.class, arg);
        }

        if(syncFlag) {
            try {
                SyncHelper s = new SyncHelper(prop);
                //s.SyncRefSymbols();

                //var iex = new iexHelper(prop.getProperty("iex.apikey"));
                //var z = iex.getCompany("aapl");
                //System.out.println(z.getDescription());

                //s.SyncRefSymbols();
                //s.syncCompanies();
                //s.syncLogos();

                Thread th1 = new Thread(s);
                th1.start();
                th1.join();

                System.exit(0);

            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}