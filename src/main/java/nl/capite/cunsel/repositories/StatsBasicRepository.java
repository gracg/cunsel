package nl.capite.cunsel.repositories;

import nl.capite.cunsel.models.StatsBasic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatsBasicRepository extends CrudRepository<StatsBasic,String> {

    @Query(value = "SELECT " +
            "ticker," +
            "companyName as company_name," +
            "marketcap," +
            "week52high," +
            "week52low," +
            "week52highSplitAdjustOnly as week52high_split_adjust_only," +
            "week52lowSplitAdjustOnly as week52low_split_adjust_only," +
            "week52change," +
            "sharesOutstanding as shares_outstanding," +
            "floatNum as float_num," +
            "avg10Volume," +
            "avg30Volume," +
            "day200MovingAvg as day200moving_avg," +
            "day50MovingAvg as day50moving_avg," +
            "employees," +
            "ttmEPS," +
            "ttmDividendRate as ttm_dividend_rate," +
            "dividendYield as dividend_yield," +
            "nextDividendDate as next_dividend_date," +
            "exDividendDate as ex_dividend_date," +
            "nextEarningsDate as next_earnings_date," +
            "peRatio as pe_ratio," +
            "beta," +
            "maxChangePercent as max_change_percent," +
            "year5ChangePercent as year5change_percent," +
            "year2ChangePercent as year2change_percent," +
            "year1ChangePercent as year1change_percent," +
            "ytdChangePercent as ytd_change_percent," +
            "month6ChangePercent as month6change_percent," +
            "month3ChangePercent as month3change_percent," +
            "month1ChangePercent as month1change_percent," +
            "day30ChangePercent as day30change_percent," +
            "day5ChangePercent  as day5change_percent " +
            "FROM stats_basic ORDER BY TICKER ASC"
            ,nativeQuery = true)
    public List<StatsBasic> getStatsBasic();

    @Query(value = "SELECT " +
            "ticker," +
            "companyName as company_name," +
            "marketcap," +
            "week52high," +
            "week52low," +
            "week52highSplitAdjustOnly as week52high_split_adjust_only," +
            "week52lowSplitAdjustOnly as week52low_split_adjust_only," +
            "week52change," +
            "sharesOutstanding as shares_outstanding," +
            "floatNum as float_num," +
            "avg10Volume," +
            "avg30Volume," +
            "day200MovingAvg as day200moving_avg," +
            "day50MovingAvg as day50moving_avg," +
            "employees," +
            "ttmEPS," +
            "ttmDividendRate as ttm_dividend_rate," +
            "dividendYield as dividend_yield," +
            "nextDividendDate as next_dividend_date," +
            "exDividendDate as ex_dividend_date," +
            "nextEarningsDate as next_earnings_date," +
            "peRatio as pe_ratio," +
            "beta," +
            "maxChangePercent as max_change_percent," +
            "year5ChangePercent as year5change_percent," +
            "year2ChangePercent as year2change_percent," +
            "year1ChangePercent as year1change_percent," +
            "ytdChangePercent as ytd_change_percent," +
            "month6ChangePercent as month6change_percent," +
            "month3ChangePercent as month3change_percent," +
            "month1ChangePercent as month1change_percent," +
            "day30ChangePercent as day30change_percent," +
            "day5ChangePercent  as day5change_percent " +
            "FROM stats_basic WHERE TICKER=?1"
            ,nativeQuery = true)
    public StatsBasic getStatsBasic(String symbol);
}
