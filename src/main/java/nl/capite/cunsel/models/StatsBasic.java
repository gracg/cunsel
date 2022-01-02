package nl.capite.cunsel.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.capite.cunsel.interfaces.GenericIdInterface;

import javax.persistence.Id;
import java.util.Objects;

public class StatsBasic implements GenericIdInterface {
    @Id
    private String companyName;
    private long marketcap;
    private double week52high;
    private double week52low;
    private double week52highSplitAdjustOnly;
    private double week52lowSplitAdjustOnly;
    private double week52change;
    private long sharesOutstanding;
    @JsonProperty("float")
    private long floatNum;
    private long avg10Volume;
    private long avg30Volume;
    private double day200MovingAvg;
    private double day50MovingAvg;
    private long employees;
    private double ttmEPS;
    private double ttmDividendRate;
    private double dividendYield;
    private String nextDividendDate;
    private String exDividendDate;
    private String nextEarningsDate;
    private double peRatio;
    private double beta;
    private double maxChangePercent;
    private double year5ChangePercent;
    private double year2ChangePercent;
    private double year1ChangePercent;
    private double ytdChangePercent;
    private double month6ChangePercent;
    private double month3ChangePercent;
    private double month1ChangePercent;
    private double day30ChangePercent;
    private double day5ChangePercent;

    public StatsBasic() {
    }

    public StatsBasic(String companyName, long marketcap, double week52high, double week52low, double week52highSplitAdjustOnly, double week52lowSplitAdjustOnly, double week52change, long sharesOutstanding, long floatNum, long avg10Volume, long avg30Volume, double day200MovingAvg, double day50MovingAvg, long employees, double ttmEPS, double ttmDividendRate, double dividendYield, String nextDividendDate, String exDividendDate, String nextEarningsDate, double peRatio, double beta, double maxChangePercent, double year5ChangePercent, double year2ChangePercent, double year1ChangePercent, double ytdChangePercent, double month6ChangePercent, double month3ChangePercent, double month1ChangePercent, double day30ChangePercent, double day5ChangePercent) {
        this.companyName = companyName;
        this.marketcap = marketcap;
        this.week52high = week52high;
        this.week52low = week52low;
        this.week52highSplitAdjustOnly = week52highSplitAdjustOnly;
        this.week52lowSplitAdjustOnly = week52lowSplitAdjustOnly;
        this.week52change = week52change;
        this.sharesOutstanding = sharesOutstanding;
        this.floatNum = floatNum;
        this.avg10Volume = avg10Volume;
        this.avg30Volume = avg30Volume;
        this.day200MovingAvg = day200MovingAvg;
        this.day50MovingAvg = day50MovingAvg;
        this.employees = employees;
        this.ttmEPS = ttmEPS;
        this.ttmDividendRate = ttmDividendRate;
        this.dividendYield = dividendYield;
        this.nextDividendDate = nextDividendDate;
        this.exDividendDate = exDividendDate;
        this.nextEarningsDate = nextEarningsDate;
        this.peRatio = peRatio;
        this.beta = beta;
        this.maxChangePercent = maxChangePercent;
        this.year5ChangePercent = year5ChangePercent;
        this.year2ChangePercent = year2ChangePercent;
        this.year1ChangePercent = year1ChangePercent;
        this.ytdChangePercent = ytdChangePercent;
        this.month6ChangePercent = month6ChangePercent;
        this.month3ChangePercent = month3ChangePercent;
        this.month1ChangePercent = month1ChangePercent;
        this.day30ChangePercent = day30ChangePercent;
        this.day5ChangePercent = day5ChangePercent;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getMarketcap() {
        return marketcap;
    }

    public void setMarketcap(long marketcap) {
        this.marketcap = marketcap;
    }

    public double getWeek52high() {
        return week52high;
    }

    public void setWeek52high(double week52high) {
        this.week52high = week52high;
    }

    public double getWeek52low() {
        return week52low;
    }

    public void setWeek52low(double week52low) {
        this.week52low = week52low;
    }

    public double getWeek52highSplitAdjustOnly() {
        return week52highSplitAdjustOnly;
    }

    public void setWeek52highSplitAdjustOnly(double week52highSplitAdjustOnly) {
        this.week52highSplitAdjustOnly = week52highSplitAdjustOnly;
    }

    public double getWeek52lowSplitAdjustOnly() {
        return week52lowSplitAdjustOnly;
    }

    public void setWeek52lowSplitAdjustOnly(double week52lowSplitAdjustOnly) {
        this.week52lowSplitAdjustOnly = week52lowSplitAdjustOnly;
    }

    public double getWeek52change() {
        return week52change;
    }

    public void setWeek52change(double week52change) {
        this.week52change = week52change;
    }

    public long getSharesOutstanding() {
        return sharesOutstanding;
    }

    public void setSharesOutstanding(long sharesOutstanding) {
        this.sharesOutstanding = sharesOutstanding;
    }

    public long getFloatNum() {
        return floatNum;
    }

    public void setFloatNum(long floatNum) {
        this.floatNum = floatNum;
    }

    public long getAvg10Volume() {
        return avg10Volume;
    }

    public void setAvg10Volume(long avg10Volume) {
        this.avg10Volume = avg10Volume;
    }

    public long getAvg30Volume() {
        return avg30Volume;
    }

    public void setAvg30Volume(long avg30Volume) {
        this.avg30Volume = avg30Volume;
    }

    public double getDay200MovingAvg() {
        return day200MovingAvg;
    }

    public void setDay200MovingAvg(double day200MovingAvg) {
        this.day200MovingAvg = day200MovingAvg;
    }

    public double getDay50MovingAvg() {
        return day50MovingAvg;
    }

    public void setDay50MovingAvg(double day50MovingAvg) {
        this.day50MovingAvg = day50MovingAvg;
    }

    public long getEmployees() {
        return employees;
    }

    public void setEmployees(long employees) {
        this.employees = employees;
    }

    public double getTtmEPS() {
        return ttmEPS;
    }

    public void setTtmEPS(double ttmEPS) {
        this.ttmEPS = ttmEPS;
    }

    public double getTtmDividendRate() {
        return ttmDividendRate;
    }

    public void setTtmDividendRate(double ttmDividendRate) {
        this.ttmDividendRate = ttmDividendRate;
    }

    public double getDividendYield() {
        return dividendYield;
    }

    public void setDividendYield(double dividendYield) {
        this.dividendYield = dividendYield;
    }

    public String getNextDividendDate() {
        return nextDividendDate;
    }

    public void setNextDividendDate(String nextDividendDate) {
        this.nextDividendDate = nextDividendDate;
    }

    public String getExDividendDate() {
        return exDividendDate;
    }

    public void setExDividendDate(String exDividendDate) {
        this.exDividendDate = exDividendDate;
    }

    public String getNextEarningsDate() {
        return nextEarningsDate;
    }

    public void setNextEarningsDate(String nextEarningsDate) {
        this.nextEarningsDate = nextEarningsDate;
    }

    public double getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(double peRatio) {
        this.peRatio = peRatio;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public double getMaxChangePercent() {
        return maxChangePercent;
    }

    public void setMaxChangePercent(double maxChangePercent) {
        this.maxChangePercent = maxChangePercent;
    }

    public double getYear5ChangePercent() {
        return year5ChangePercent;
    }

    public void setYear5ChangePercent(double year5ChangePercent) {
        this.year5ChangePercent = year5ChangePercent;
    }

    public double getYear2ChangePercent() {
        return year2ChangePercent;
    }

    public void setYear2ChangePercent(double year2ChangePercent) {
        this.year2ChangePercent = year2ChangePercent;
    }

    public double getYear1ChangePercent() {
        return year1ChangePercent;
    }

    public void setYear1ChangePercent(double year1ChangePercent) {
        this.year1ChangePercent = year1ChangePercent;
    }

    public double getYtdChangePercent() {
        return ytdChangePercent;
    }

    public void setYtdChangePercent(double ytdChangePercent) {
        this.ytdChangePercent = ytdChangePercent;
    }

    public double getMonth6ChangePercent() {
        return month6ChangePercent;
    }

    public void setMonth6ChangePercent(double month6ChangePercent) {
        this.month6ChangePercent = month6ChangePercent;
    }

    public double getMonth3ChangePercent() {
        return month3ChangePercent;
    }

    public void setMonth3ChangePercent(double month3ChangePercent) {
        this.month3ChangePercent = month3ChangePercent;
    }

    public double getMonth1ChangePercent() {
        return month1ChangePercent;
    }

    public void setMonth1ChangePercent(double month1ChangePercent) {
        this.month1ChangePercent = month1ChangePercent;
    }

    public double getDay30ChangePercent() {
        return day30ChangePercent;
    }

    public void setDay30ChangePercent(double day30ChangePercent) {
        this.day30ChangePercent = day30ChangePercent;
    }

    public double getDay5ChangePercent() {
        return day5ChangePercent;
    }

    public void setDay5ChangePercent(double day5ChangePercent) {
        this.day5ChangePercent = day5ChangePercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatsBasic that = (StatsBasic) o;
        return marketcap == that.marketcap && Double.compare(that.week52high, week52high) == 0 && Double.compare(that.week52low, week52low) == 0 && Double.compare(that.week52highSplitAdjustOnly, week52highSplitAdjustOnly) == 0 && Double.compare(that.week52lowSplitAdjustOnly, week52lowSplitAdjustOnly) == 0 && Double.compare(that.week52change, week52change) == 0 && sharesOutstanding == that.sharesOutstanding && floatNum == that.floatNum && avg10Volume == that.avg10Volume && avg30Volume == that.avg30Volume && Double.compare(that.day200MovingAvg, day200MovingAvg) == 0 && Double.compare(that.day50MovingAvg, day50MovingAvg) == 0 && employees == that.employees && Double.compare(that.ttmEPS, ttmEPS) == 0 && Double.compare(that.ttmDividendRate, ttmDividendRate) == 0 && Double.compare(that.dividendYield, dividendYield) == 0 && Double.compare(that.peRatio, peRatio) == 0 && Double.compare(that.beta, beta) == 0 && Double.compare(that.maxChangePercent, maxChangePercent) == 0 && Double.compare(that.year5ChangePercent, year5ChangePercent) == 0 && Double.compare(that.year2ChangePercent, year2ChangePercent) == 0 && Double.compare(that.year1ChangePercent, year1ChangePercent) == 0 && Double.compare(that.ytdChangePercent, ytdChangePercent) == 0 && Double.compare(that.month6ChangePercent, month6ChangePercent) == 0 && Double.compare(that.month3ChangePercent, month3ChangePercent) == 0 && Double.compare(that.month1ChangePercent, month1ChangePercent) == 0 && Double.compare(that.day30ChangePercent, day30ChangePercent) == 0 && Double.compare(that.day5ChangePercent, day5ChangePercent) == 0 && Objects.equals(companyName, that.companyName) && Objects.equals(nextDividendDate, that.nextDividendDate) && Objects.equals(exDividendDate, that.exDividendDate) && Objects.equals(nextEarningsDate, that.nextEarningsDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, marketcap, week52high, week52low, week52highSplitAdjustOnly, week52lowSplitAdjustOnly, week52change, sharesOutstanding, floatNum, avg10Volume, avg30Volume, day200MovingAvg, day50MovingAvg, employees, ttmEPS, ttmDividendRate, dividendYield, nextDividendDate, exDividendDate, nextEarningsDate, peRatio, beta, maxChangePercent, year5ChangePercent, year2ChangePercent, year1ChangePercent, ytdChangePercent, month6ChangePercent, month3ChangePercent, month1ChangePercent, day30ChangePercent, day5ChangePercent);
    }

    @Override
    public String getGenericId() {
        return this.companyName;
    }
}
