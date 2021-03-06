package nl.capite.cunsel.Helpers;

import nl.capite.cunsel.interfaces.GenericIdInterface;
import nl.capite.cunsel.models.Company;
import nl.capite.cunsel.models.Logo;
import nl.capite.cunsel.models.StatsBasic;
import nl.capite.cunsel.models.refSymbol;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DbHelper {
    private final String urlSource;
    private final String user;
    private final String password;

    private Connection con;


    public DbHelper(String urlSource, String user, String password) throws SQLException {
        this.urlSource=urlSource;
        this.user=user;
        this.password=password;

        this.con = DriverManager.getConnection(this.urlSource,this.user,this.password);
    }

    public void closeConnection() throws SQLException {
        this.con.close();
    }

    public void dropTables() throws SQLException {
        ArrayList<String> tables = new ArrayList<String>();
        tables.add("symbols");
        tables.add("companies");
        tables.add("logos");
        tables.add("stats_basic");
        tables.add("nq100");

        Statement stmt;
        for(String x:tables) {
            stmt = this.con.createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS " + x);
            stmt.close();
        }
    }

    public void CreateTables() throws SQLException {
        var sb = new StringBuilder();
        sb.append("CREATE TABLE symbols(");
        sb.append("symbol VARCHAR(100) PRIMARY KEY,");
        sb.append("exchange VARCHAR(100),");
        sb.append("exchangeSuffix VARCHAR(100),");
        sb.append("exchangeName VARCHAR(100),");
        sb.append("exchangeSegment VARCHAR(100),");
        sb.append("exchangeSegmentName VARCHAR(100),");
        sb.append("name VARCHAR(500),");
        sb.append("type VARCHAR(100),");
        sb.append("iexId VARCHAR(100),");
        sb.append("region VARCHAR(100),");
        sb.append("currency VARCHAR(100),");
        sb.append("isEnabled BOOLEAN,");
        sb.append("figi VARCHAR(100),");
        sb.append("cik VARCHAR(100),");
        sb.append("lei VARCHAR(100))");


        var stmt = con.createStatement();
        stmt.executeUpdate(sb.toString());
        stmt.close();
        sb.delete(0, sb.length());
        ///////////////////////////
        sb.append("CREATE TABLE companies(");
        sb.append("symbol VARCHAR(100) PRIMARY KEY,");
        sb.append("companyName VARCHAR(500),");
        sb.append("exchange VARCHAR(500),");
        sb.append("industry TEXT,");
        sb.append("website TEXT,");
        sb.append("description TEXT,");
        sb.append("ceo TEXT,");
        sb.append("securityName VARCHAR(500),");
        sb.append("issueType VARCHAR(500),");
        sb.append("sector VARCHAR(500),");
        sb.append("primarySicCode INTEGER,");
        sb.append("employees INTEGER,");
        sb.append("tags TEXT[],");
        sb.append("address VARCHAR(500),");
        sb.append("address2 VARCHAR(500),");
        sb.append("state VARCHAR(500),");
        sb.append("city VARCHAR(500),");
        sb.append("zip VARCHAR(500),");
        sb.append("country VARCHAR(500),");
        sb.append("phone VARCHAR(500))");
        stmt = con.createStatement();
        stmt.executeUpdate(sb.toString());
        stmt.close();
        sb.delete(0, sb.length());
        ////////////////////////////////
        sb.append("CREATE TABLE logos(");
        sb.append("symbol VARCHAR(100) PRIMARY KEY,");
        sb.append("url TEXT)");
        stmt = con.createStatement();
        stmt.executeUpdate(sb.toString());
        stmt.close();
        sb.delete(0, sb.length());
        ////////////////////////////////
        sb.append("CREATE TABLE nq100(");
        sb.append("symbol VARCHAR(100) PRIMARY KEY)");
        stmt = con.createStatement();
        stmt.executeUpdate(sb.toString());
        stmt.close();
        sb.delete(0, sb.length());
        ////////////////////////////////
        sb.append("CREATE TABLE stats_basic(");
        sb.append("ticker VARCHAR(100) PRIMARY KEY,");
        sb.append("companyName VARCHAR(200),");
        sb.append("marketcap BIGINT,");
        sb.append("week52high DOUBLE PRECISION,");
        sb.append("week52low DOUBLE PRECISION,");
        sb.append("week52highSplitAdjustOnly DOUBLE PRECISION,");
        sb.append("week52lowSplitAdjustOnly DOUBLE PRECISION,");
        sb.append("week52change DOUBLE PRECISION,");
        sb.append("sharesOutstanding BIGINT,");
        sb.append("floatNum BIGINT,");
        sb.append("avg10Volume BIGINT,");
        sb.append("avg30Volume BIGINT,");
        sb.append("day200MovingAvg DOUBLE PRECISION,");
        sb.append("day50MovingAvg DOUBLE PRECISION,");
        sb.append("employees BIGINT,");
        sb.append("ttmEPS DOUBLE PRECISION,");
        sb.append("ttmDividendRate DOUBLE PRECISION,");
        sb.append("dividendYield DOUBLE PRECISION,");
        sb.append("nextDividendDate VARCHAR(100),");
        sb.append("exDividendDate VARCHAR(100),");
        sb.append("nextEarningsDate VARCHAR(100),");
        sb.append("peRatio DOUBLE PRECISION,");
        sb.append("beta DOUBLE PRECISION,");
        sb.append("maxChangePercent DOUBLE PRECISION,");
        sb.append("year5ChangePercent DOUBLE PRECISION,");
        sb.append("year2ChangePercent DOUBLE PRECISION,");
        sb.append("year1ChangePercent DOUBLE PRECISION,");
        sb.append("ytdChangePercent DOUBLE PRECISION,");
        sb.append("month6ChangePercent DOUBLE PRECISION,");
        sb.append("month3ChangePercent DOUBLE PRECISION,");
        sb.append("month1ChangePercent DOUBLE PRECISION,");
        sb.append("day30ChangePercent DOUBLE PRECISION,");
        sb.append("day5ChangePercent DOUBLE PRECISION)");
        stmt = con.createStatement();
        stmt.executeUpdate(sb.toString());
        stmt.close();
        sb.delete(0, sb.length());


    }

    public List<String> getTickers() throws SQLException {
        var s = "SELECT symbol FROM SYMBOLS";
        List<String> ls = new ArrayList<String>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(s);
        while (rs.next()) {
            ls.add(rs.getString(1));
        }
        return ls;
    }

    public List<refSymbol> getRefSymbols() throws SQLException {
        var s = "SELECT symbol," +
                "exchange," +
                "exchangeSuffix," +
                "exchangeName," +
                "exchangeSegment," +
                "exchangeSegmentName," +
                "name," +
                "type," +
                "iexId," +
                "region," +
                "currency," +
                "isEnabled," +
                "figi," +
                "cik," +
                "lei " +
                "FROM SYMBOLS";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(s);
        List<refSymbol> ls = new ArrayList<refSymbol>();
        while (rs.next()) {
            var temp = new refSymbol(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getBoolean(12),
                    rs.getString(13),
                    rs.getString(14),
                    rs.getString(15)
            );
            ls.add(temp);
        }
        return ls;
    }

    public HashMap<String,refSymbol> getRefSymbolsMap() throws SQLException {
        var s = "SELECT symbol," +
                "exchange," +
                "exchangeSuffix," +
                "exchangeName," +
                "exchangeSegment," +
                "exchangeSegmentName," +
                "name," +
                "type," +
                "iexId," +
                "region," +
                "currency," +
                "isEnabled," +
                "figi," +
                "cik," +
                "lei " +
                "FROM SYMBOLS";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(s);
        HashMap<String,refSymbol> mp = new HashMap<String,refSymbol>();
        while (rs.next()) {
            var temp = new refSymbol(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getBoolean(12),
                    rs.getString(13),
                    rs.getString(14),
                    rs.getString(15)
            );
            mp.put(temp.getSymbol(),temp);
        }
        return mp;
    }

    public void insertRefSymbols(List<refSymbol> ls) throws SQLException {
        var s = "INSERT INTO SYMBOLS(" +
                "symbol," +
                "exchange," +
                "exchangeSuffix," +
                "exchangeName," +
                "exchangeSegment," +
                "exchangeSegmentName," +
                "name," +
                "type," +
                "iexId," +
                "region," +
                "currency," +
                "isEnabled," +
                "figi," +
                "cik," +
                "lei) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = con.prepareStatement(s);
        int c =0;
        for(refSymbol x: ls) {
            if(c>=100){
                pstmt.executeBatch();
                c=0;
            }

            pstmt.setString(1,x.getSymbol());
            pstmt.setString(2,x.getExchange());
            pstmt.setString(3,x.getExchangeSuffix());
            pstmt.setString(4,x.getExchangeName());
            pstmt.setString(5,x.getExchangeSegment());
            pstmt.setString(6,x.getExchangeSegmentName());
            pstmt.setString(7,x.getName());
            pstmt.setString(8,x.getType());
            pstmt.setString(9,x.getIexId());
            pstmt.setString(10,x.getRegion());
            pstmt.setString(11,x.getCurrency());
            pstmt.setBoolean(12,x.isEnabled());
            pstmt.setString(13,x.getFigi());
            pstmt.setString(14,x.getCik());
            pstmt.setString(15,x.getLei());
            pstmt.addBatch();
            c++;
        }
        pstmt.executeBatch();
    }

    public void updateRefSymbols(List<refSymbol> ls) throws SQLException {
        var s = "UPDATE SYMBOLS SET " +
                "exchange=?," +
                "exchangeSuffix=?," +
                "exchangeName=?," +
                "exchangeSegment=?," +
                "exchangeSegmentName=?," +
                "name=?," +
                "type=?," +
                "iexId=?," +
                "region=?," +
                "currency=?," +
                "isEnabled=?," +
                "figi=?," +
                "cik=?," +
                "lei=? " +
                "WHERE symbol=?";

        PreparedStatement pstmt = con.prepareStatement(s);
        int c =0;
        for(refSymbol x: ls) {
            if(c>=100){
                pstmt.executeBatch();
                c=0;
            }

            pstmt.setString(1,x.getExchange());
            pstmt.setString(2,x.getExchangeSuffix());
            pstmt.setString(3,x.getExchangeName());
            pstmt.setString(4,x.getExchangeSegment());
            pstmt.setString(5,x.getExchangeSegmentName());
            pstmt.setString(6,x.getName());
            pstmt.setString(7,x.getType());
            pstmt.setString(8,x.getIexId());
            pstmt.setString(9,x.getRegion());
            pstmt.setString(10,x.getCurrency());
            pstmt.setBoolean(11,x.isEnabled());
            pstmt.setString(12,x.getFigi());
            pstmt.setString(13,x.getCik());
            pstmt.setString(14,x.getLei());
            pstmt.setString(15,x.getSymbol());
            pstmt.addBatch();
            c++;
        }
        pstmt.executeBatch();

    }

    /*
        String is symbol
        symbol from refSymbol
     */
    public void deleteRefSymbols(List<String> ls) throws SQLException {
        var s = "DELETE FROM SYMBOLS WHERE symbol=?";

        PreparedStatement pstmt = con.prepareStatement(s);
        int c =0;
        for (String x:ls) {
            if (c>=100){
                pstmt.executeBatch();
                c=0;
            }
            pstmt.setString(1,x);
            c++;
        }
        pstmt.executeBatch();
    }

    public List<Company> getCompanies() throws SQLException {
        var s = "SELECT " +
                "symbol," +
                "companyName," +
                "exchange," +
                "industry," +
                "website," +
                "description," +
                "ceo,"+
                "securityName," +
                "issueType," +
                "sector," +
                "primarySicCode," +
                "employees," +
                "tags," +
                "address," +
                "address2," +
                "state," +
                "city," +
                "zip," +
                "country," +
                "phone " +
                "FROM companies";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(s);

        List<Company> ls = new ArrayList<Company>();
        while (rs.next()) {
            var arr =rs.getArray(13);
            String[] arr2 =(String[]) arr.getArray();
            var temp = new Company(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getInt(11),
                    rs.getInt(12),
                    Arrays.stream(arr2).toList(),
                    rs.getString(14),
                    rs.getString(15),
                    rs.getString(16),
                    rs.getString(17),
                    rs.getString(18),
                    rs.getString(19),
                    rs.getString(20)
            );
            ls.add(temp);
        }
        return ls;
    }

    public HashMap<String, Company> getCompaniesMap() throws SQLException {
        var s = "SELECT " +
                "symbol," +
                "companyName," +
                "exchange," +
                "industry," +
                "website," +
                "description," +
                "ceo,"+
                "securityName," +
                "issueType," +
                "sector," +
                "primarySicCode," +
                "employees," +
                "tags," +
                "address," +
                "address2," +
                "state," +
                "city," +
                "zip," +
                "country," +
                "phone " +
                "FROM companies";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(s);

        HashMap<String, Company> mp = new HashMap<>();
        while (rs.next()) {
            var arr =rs.getArray(13);
            String[] arr2 =(String[]) arr.getArray();
            var temp = new Company(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getInt(11),
                    rs.getInt(12),
                    Arrays.stream(arr2).toList(),
                    rs.getString(14),
                    rs.getString(15),
                    rs.getString(16),
                    rs.getString(17),
                    rs.getString(18),
                    rs.getString(19),
                    rs.getString(20)
            );
            mp.put(temp.getSymbol(),temp);
        }
        return mp;
    }

    public void insertCompanies(List<Company> ls) throws SQLException {
        var s = "INSERT INTO COMPANIES( " +
                "symbol," +
                "companyName," +
                "exchange," +
                "industry," +
                "website," +
                "description," +
                "ceo,"+
                "securityName," +
                "issueType," +
                "sector," +
                "primarySicCode," +
                "employees," +
                "tags," +
                "address," +
                "address2," +
                "state," +
                "city," +
                "zip," +
                "country," +
                "phone) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = con.prepareStatement(s);

        int c=0;
        for (Company x:ls) {
            if(c>=100) {
                pstmt.executeBatch();
                c=0;
            }


            pstmt.setString(1,x.getSymbol());
            pstmt.setString(2,x.getCompanyName());
            pstmt.setString(3,x.getExchange());
            pstmt.setString(4,x.getIndustry());
            pstmt.setString(5,x.getWebsite());
            pstmt.setString(6,x.getDescription());
            pstmt.setString(7,x.getCeo());
            pstmt.setString(8,x.getSecurityName());
            pstmt.setString(9,x.getIssueType());
            pstmt.setString(10,x.getSector());
            if(x.getPrimarySicCode()!=null){pstmt.setInt(11,x.getPrimarySicCode());}
            //pstmt.setInt(11,x.getPrimarySicCode()==null?-1:x.getPrimarySicCode());
            if(x.getEmployees()!=null){pstmt.setInt(12,x.getEmployees());}
            //pstmt.setInt(12,x.getEmployees()==null?-1:x.getEmployees());
            Array arr = con.createArrayOf("TEXT",x.getTags().toArray());
            pstmt.setArray(13,arr);
            pstmt.setString(14,x.getAddress());
            pstmt.setString(15,x.getAddress2());
            pstmt.setString(16,x.getState());
            pstmt.setString(17,x.getCity());
            pstmt.setString(18,x.getZip());
            pstmt.setString(19,x.getCountry());
            pstmt.setString(20,x.getPhone());
            pstmt.addBatch();
            c++;
        }
        pstmt.executeBatch();
    }

    public void updateCompanies(List<Company> ls) throws SQLException {
        var s = "UPDATE COMPANIES SET " +
                "companyName=?," +
                "exchange=?," +
                "industry=?," +
                "website=?," +
                "description=?," +
                "ceo=?," +
                "securityName=?," +
                "issueType=?," +
                "sector=?," +
                "primarySicCode=?," +
                "employees=?," +
                "tags=?," +
                "address=?," +
                "address2=?," +
                "state=?," +
                "city=?," +
                "zip=?," +
                "country=?," +
                "phone=? " +
                "WHERE symbol=?";

        PreparedStatement pstmt = con.prepareStatement(s);

        int c=0;
        for (Company x:ls) {
            if(c>=100) {
                pstmt.executeBatch();
                c=0;
            }


            pstmt.setString(1,x.getCompanyName());
            pstmt.setString(2,x.getExchange());
            pstmt.setString(3,x.getIndustry());
            pstmt.setString(4,x.getWebsite());
            pstmt.setString(5,x.getDescription());
            pstmt.setString(6,x.getCeo());
            pstmt.setString(7,x.getSecurityName());
            pstmt.setString(8,x.getIssueType());
            pstmt.setString(9,x.getSector());
            if(x.getPrimarySicCode()!=null){pstmt.setInt(10,x.getPrimarySicCode());}
            //pstmt.setInt(10,x.getPrimarySicCode()==null?-1:x.getPrimarySicCode());
            if(x.getEmployees()!=null){pstmt.setInt(11,x.getEmployees());}
            //pstmt.setInt(11,x.getEmployees()==null?-1:x.getEmployees());
            if(x.getTags()!=null) {
                Array arr = con.createArrayOf("TEXT", x.getTags().toArray());
                pstmt.setArray(12, arr);
            }
            pstmt.setString(13,x.getAddress());
            pstmt.setString(14,x.getAddress2());
            pstmt.setString(15,x.getState());
            pstmt.setString(16,x.getCity());
            pstmt.setString(17,x.getZip());
            pstmt.setString(18,x.getCountry());
            pstmt.setString(19,x.getPhone());
            pstmt.setString(20,x.getSymbol());

            pstmt.addBatch();
            c++;
        }
        pstmt.executeBatch();
    }

    // List consists of tickers
    public void deleteCompanies(List<String> ls) throws SQLException {
        var s = "DELETE FROM COMPANIES WHERE symbol=?";

        PreparedStatement pstmt = con.prepareStatement(s);
        int c =0;
        for (String x:ls) {
            if (c>=100){
                pstmt.executeBatch();
                c=0;
            }
            pstmt.setString(1,x);
            c++;
        }
        pstmt.executeBatch();
    }

    public List<Logo> getLogos() throws SQLException {
        var s = "SELECT symbol,url FROM LOGOS";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(s);
        ArrayList<Logo> ls = new ArrayList<>();
        while (rs.next()) {
            ls.add(
                    new Logo(
                            rs.getString(1),
                            rs.getString(2)
                    )
            );
        }
        return ls;
    }

    public HashMap<String,Logo> getLogosMap() throws SQLException {
        var s = "SELECT symbol,url FROM LOGOS";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(s);
        HashMap<String,Logo> mp = new HashMap<>();
        while (rs.next()) {
            var temp = new Logo(rs.getString(1),rs.getString(2));
            mp.put(temp.getTicker(),temp);
        }
        return mp;
    }

    public void insertLogos(List<Logo> ls) throws SQLException {
        var s = "INSERT INTO LOGOS(symbol,url) VALUES(?,?)";
        PreparedStatement pstmt = con.prepareStatement(s);
        int c=0;
        for(Logo x:ls) {
            if(c>=100){
                pstmt.executeBatch();
                c=0;
            }
            pstmt.setString(1,x.getTicker());
            pstmt.setString(2,x.getUrl());
            pstmt.addBatch();
            c++;
        }
        pstmt.executeBatch();
    }

    public void updateLogos(List<Logo> ls) throws SQLException {
        var s = "UPDATE LOGOS SET url=? WHERE symbol=?";
        PreparedStatement pstmt = con.prepareStatement(s);
        int c =0;
        for(Logo x:ls) {
            if(c>=100){
                pstmt.executeBatch();
                c=0;
            }
            pstmt.setString(1,x.getUrl());
            pstmt.setString(2,x.getTicker());
            pstmt.addBatch();
            c++;
        }
        pstmt.executeBatch();
    }

    public void deleteLogos(List<String> ls) throws SQLException {
        var s = "DELETE FROM LOGOS WHERE symbol=?";
        PreparedStatement pstmt = con.prepareStatement(s);
        int c =0;
        for(String x:ls) {
            if(c>=100){
                pstmt.executeBatch();
                c=0;
            }
            pstmt.setString(1,x);
            pstmt.addBatch();
            c++;
        }
        pstmt.executeBatch();

    }

    public List<StatsBasic> getStatsBasic() throws SQLException {
        var s = "SELECT " +
                "ticker," +
                "companyName," +
                "marketcap," +
                "week52high," +
                "week52low," +
                "week52highSplitAdjustOnly," +
                "week52lowSplitAdjustOnly," +
                "week52change," +
                "sharesOutstanding," +
                "floatNum," +
                "avg10Volume," +
                "avg30Volume," +
                "day200MovingAvg," +
                "day50MovingAvg," +
                "employees," +
                "ttmEPS," +
                "ttmDividendRate," +
                "dividendYield," +
                "nextDividendDate," +
                "exDividendDate," +
                "nextEarningsDate," +
                "peRatio," +
                "beta," +
                "maxChangePercent," +
                "year5ChangePercent," +
                "year2ChangePercent," +
                "year1ChangePercent," +
                "ytdChangePercent," +
                "month6ChangePercent," +
                "month3ChangePercent," +
                "month1ChangePercent," +
                "day30ChangePercent," +
                "day5ChangePercent " +
                "FROM stats_basic";

        Statement stmt = this.con.createStatement();
        ResultSet rs = stmt.executeQuery(s);
        List<StatsBasic> ls = new ArrayList<>();
        while (rs.next()) {
            ls.add(
                    new StatsBasic(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getLong(3),
                            rs.getDouble(4),
                            rs.getDouble(5),
                            rs.getDouble(6),
                            rs.getDouble(7),
                            rs.getDouble(8),
                            rs.getLong(9),
                            rs.getLong(10),
                            rs.getLong(11),
                            rs.getLong(12),
                            rs.getDouble(13),
                            rs.getDouble(14),
                            rs.getLong(15),
                            rs.getDouble(16),
                            rs.getDouble(17),
                            rs.getDouble(18),
                            rs.getString(19),
                            rs.getString(20),
                            rs.getString(21),
                            rs.getDouble(22),
                            rs.getDouble(23),
                            rs.getDouble(24),
                            rs.getDouble(25),
                            rs.getDouble(26),
                            rs.getDouble(27),
                            rs.getDouble(28),
                            rs.getDouble(29),
                            rs.getDouble(30),
                            rs.getDouble(31),
                            rs.getDouble(32),
                            rs.getDouble(33)
                    )
            );
        }
        return ls;
    }

    public HashMap<String,StatsBasic> getStatsBasicMap() throws SQLException {
        var s = "SELECT " +
                "ticker," +
                "companyName," +
                "marketcap," +
                "week52high," +
                "week52low," +
                "week52highSplitAdjustOnly," +
                "week52lowSplitAdjustOnly," +
                "week52change," +
                "sharesOutstanding," +
                "floatNum," +
                "avg10Volume," +
                "avg30Volume," +
                "day200MovingAvg," +
                "day50MovingAvg," +
                "employees," +
                "ttmEPS," +
                "ttmDividendRate," +
                "dividendYield," +
                "nextDividendDate," +
                "exDividendDate," +
                "nextEarningsDate," +
                "peRatio," +
                "beta," +
                "maxChangePercent," +
                "year5ChangePercent," +
                "year2ChangePercent," +
                "year1ChangePercent," +
                "ytdChangePercent," +
                "month6ChangePercent," +
                "month3ChangePercent," +
                "month1ChangePercent," +
                "day30ChangePercent," +
                "day5ChangePercent " +
                "FROM stats_basic";

        Statement stmt = this.con.createStatement();
        ResultSet rs = stmt.executeQuery(s);
        HashMap<String,StatsBasic> mp = new HashMap<>();
        while (rs.next()) {
            var t = new StatsBasic(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getLong(3),
                    rs.getDouble(4),
                    rs.getDouble(5),
                    rs.getDouble(6),
                    rs.getDouble(7),
                    rs.getDouble(8),
                    rs.getLong(9),
                    rs.getLong(10),
                    rs.getLong(11),
                    rs.getLong(12),
                    rs.getDouble(13),
                    rs.getDouble(14),
                    rs.getLong(15),
                    rs.getDouble(16),
                    rs.getDouble(17),
                    rs.getDouble(18),
                    rs.getString(19),
                    rs.getString(20),
                    rs.getString(21),
                    rs.getDouble(22),
                    rs.getDouble(23),
                    rs.getDouble(24),
                    rs.getDouble(25),
                    rs.getDouble(26),
                    rs.getDouble(27),
                    rs.getDouble(28),
                    rs.getDouble(29),
                    rs.getDouble(30),
                    rs.getDouble(31),
                    rs.getDouble(32),
                    rs.getDouble(33)
            );
            mp.put(t.getGenericId(),t);
        }
        return mp;
    }

    public void insertStasBasic(List<StatsBasic> ls) throws SQLException {
        var s = "INSERT INTO STATS_BASIC(" +
                "ticker," +
                "companyName," +
                "marketcap," +
                "week52high," +
                "week52low," +
                "week52highSplitAdjustOnly," +
                "week52lowSplitAdjustOnly," +
                "week52change," +
                "sharesOutstanding," +
                "floatNum," +
                "avg10Volume," +
                "avg30Volume," +
                "day200MovingAvg," +
                "day50MovingAvg," +
                "employees," +
                "ttmEPS," +
                "ttmDividendRate," +
                "dividendYield," +
                "nextDividendDate," +
                "exDividendDate," +
                "nextEarningsDate," +
                "peRatio," +
                "beta," +
                "maxChangePercent," +
                "year5ChangePercent," +
                "year2ChangePercent," +
                "year1ChangePercent," +
                "ytdChangePercent," +
                "month6ChangePercent," +
                "month3ChangePercent," +
                "month1ChangePercent," +
                "day30ChangePercent," +
                "day5ChangePercent) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = this.con.prepareStatement(s);
        int c=0;
        for(StatsBasic x:ls) {
            if(c>=100) {
                pstmt.executeBatch();
                c = 0;
            }
            pstmt.setString(1,x.getTicker());
            pstmt.setString(2,x.getCompanyName());
            pstmt.setLong(3,x.getMarketcap());
            pstmt.setDouble(4,x.getWeek52high());
            pstmt.setDouble(5,x.getWeek52low());
            pstmt.setDouble(6,x.getWeek52highSplitAdjustOnly());
            pstmt.setDouble(7,x.getWeek52lowSplitAdjustOnly());
            pstmt.setDouble(8,x.getWeek52change());
            pstmt.setLong(9,x.getSharesOutstanding());
            pstmt.setLong(10,x.getFloatNum());
            pstmt.setLong(11,x.getAvg10Volume());
            pstmt.setLong(12,x.getAvg30Volume());
            pstmt.setDouble(13,x.getDay200MovingAvg());
            pstmt.setDouble(14,x.getDay50MovingAvg());
            pstmt.setLong(15,x.getEmployees());
            pstmt.setDouble(16,x.getTtmEPS());
            pstmt.setDouble(17,x.getTtmDividendRate());
            pstmt.setDouble(18,x.getDividendYield());
            pstmt.setString(19,x.getNextDividendDate());
            pstmt.setString(20,x.getExDividendDate());
            pstmt.setString(21,x.getNextEarningsDate());
            pstmt.setDouble(22,x.getPeRatio());
            pstmt.setDouble(23,x.getBeta());
            pstmt.setDouble(24,x.getMaxChangePercent());
            pstmt.setDouble(25,x.getYear5ChangePercent());
            pstmt.setDouble(26,x.getYear2ChangePercent());
            pstmt.setDouble(27,x.getYear1ChangePercent());
            pstmt.setDouble(28,x.getYtdChangePercent());
            pstmt.setDouble(29,x.getMonth6ChangePercent());
            pstmt.setDouble(30,x.getMonth3ChangePercent());
            pstmt.setDouble(31,x.getMonth1ChangePercent());
            pstmt.setDouble(32,x.getDay30ChangePercent());
            pstmt.setDouble(33,x.getDay5ChangePercent());
            pstmt.addBatch();
            c++;
        }
        pstmt.executeBatch();
    }

    public void updateStatsBasic(List<StatsBasic> ls) throws SQLException {
        var s = "UPDATE STATS_BASIC SET " +
                "companyName=?," +
                "marketcap=?," +
                "week52high=?," +
                "week52low=?," +
                "week52highSplitAdjustOnly=?," +
                "week52lowSplitAdjustOnly=?," +
                "week52change=?," +
                "sharesOutstanding=?," +
                "floatNum=?," +
                "avg10Volume=?," +
                "avg30Volume=?," +
                "day200MovingAvg=?," +
                "day50MovingAvg=?," +
                "employees=?," +
                "ttmEPS=?," +
                "ttmDividendRate=?," +
                "dividendYield=?," +
                "nextDividendDate=?," +
                "exDividendDate=?," +
                "nextEarningsDate=?," +
                "peRatio=?," +
                "beta=?," +
                "maxChangePercent=?," +
                "year5ChangePercent=?," +
                "year2ChangePercent=?," +
                "year1ChangePercent=?," +
                "ytdChangePercent=?," +
                "month6ChangePercent=?," +
                "month3ChangePercent=?," +
                "month1ChangePercent=?," +
                "day30ChangePercent=?," +
                "day5ChangePercent=? " +
                "WHERE ticker=?";

        PreparedStatement pstmt = this.con.prepareStatement(s);
        int c=0;
        for(StatsBasic x:ls) {
            if(c>=100) {
                pstmt.executeBatch();
                c = 0;
            }
            pstmt.setString(1,x.getCompanyName());
            pstmt.setLong(2,x.getMarketcap());
            pstmt.setDouble(3,x.getWeek52high());
            pstmt.setDouble(4,x.getWeek52low());
            pstmt.setDouble(5,x.getWeek52highSplitAdjustOnly());
            pstmt.setDouble(6,x.getWeek52lowSplitAdjustOnly());
            pstmt.setDouble(7,x.getWeek52change());
            pstmt.setLong(8,x.getSharesOutstanding());
            pstmt.setLong(9,x.getFloatNum());
            pstmt.setLong(10,x.getAvg10Volume());
            pstmt.setLong(11,x.getAvg30Volume());
            pstmt.setDouble(12,x.getDay200MovingAvg());
            pstmt.setDouble(13,x.getDay50MovingAvg());
            pstmt.setLong(14,x.getEmployees());
            pstmt.setDouble(15,x.getTtmEPS());
            pstmt.setDouble(16,x.getTtmDividendRate());
            pstmt.setDouble(17,x.getDividendYield());
            pstmt.setString(18,x.getNextDividendDate());
            pstmt.setString(19,x.getExDividendDate());
            pstmt.setString(20,x.getNextEarningsDate());
            pstmt.setDouble(21,x.getPeRatio());
            pstmt.setDouble(22,x.getBeta());
            pstmt.setDouble(23,x.getMaxChangePercent());
            pstmt.setDouble(24,x.getYear5ChangePercent());
            pstmt.setDouble(25,x.getYear2ChangePercent());
            pstmt.setDouble(26,x.getYear1ChangePercent());
            pstmt.setDouble(27,x.getYtdChangePercent());
            pstmt.setDouble(28,x.getMonth6ChangePercent());
            pstmt.setDouble(29,x.getMonth3ChangePercent());
            pstmt.setDouble(30,x.getMonth1ChangePercent());
            pstmt.setDouble(31,x.getDay30ChangePercent());
            pstmt.setDouble(32,x.getDay5ChangePercent());
            pstmt.setString(33,x.getTicker());
            pstmt.addBatch();
            c++;
        }
        pstmt.executeBatch();
    }

    public void deleteStatsBasic(List<String> ls) throws SQLException {
        var s = "DELETE FROM STATS_BASIC WHERE ticker=?";

        PreparedStatement pstmt = con.prepareStatement(s);
        int c =0;
        for (String x:ls) {
            if (c>=100){
                pstmt.executeBatch();
                c=0;
            }
            pstmt.setString(1,x);
            c++;
        }
        pstmt.executeBatch();
    }

}
