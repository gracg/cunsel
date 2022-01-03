package nl.capite.cunsel.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Quote {
    private Long avgTotalVolume;
    private String calculationPrice;
    private Double change;
    private Double changePercent;
    private Double close;
    private String closeSource;
    private Long closeTime;
    private String companyName;
    private String currency;
    private Double delayedPrice;
    private Long delayedPriceTime;
    private Double extendedChange;
    private Double extendedChangePercent;
    private Double extendedPrice;
    private Long extendedPriceTime;
    private Double high;
    private String highSource;
    private Long highTime;
    private Double iexAskPrice;
    private Integer iexAskSize;
    private Double iexBidPrice;
    private Integer iexBidSize;
    private Double iexClose;
    private Long iexCloseTime;
    private Long iexLastUpdated;
    private Double iexMarketPercent;
    private Double iexOpen;
    private Long iexOpenTime;
    private Double iexRealtimePrice;
    private Long iexRealtimeSize;
    private Long iexVolume;
    private Long lastTradeTime;
    private Double latestPrice;
    private String latestSource;
    private String latestTime;
    private Long latestUpdate;
    private Long latestVolume;
    private Double low;
    private String lowSource;
    private Long lowTime;
    private Long marketCap;
    private Double oddLotDelayedPrice;
    private Long oddLotDelayedPriceTime;
    private Double open;
    private Long openTime;
    private String openSource;
    private Double peRatio;
    private Double previousClose;
    private Long previousVolume;
    private String primaryExchange;
    @Id
    private String symbol;
    private Long volume;
    private Double week52High;
    private Double week52Low;
    private Double ytdChange;
    private Boolean isUSMarketOpen;

    public Quote() {
    }

    public Quote(Long avgTotalVolume, String calculationPrice, Double change, Double changePercent, Double close, String closeSource, Long closeTime, String companyName, String currency, Double delayedPrice, Long delayedPriceTime, Double extendedChange, Double extendedChangePercent, Double extendedPrice, Long extendedPriceTime, Double high, String highSource, Long highTime, Double iexAskPrice, Integer iexAskSize, Double iexBidPrice, Integer iexBidSize, Double iexClose, Long iexCloseTime, Long iexLastUpdated, Double iexMarketPercent, Double iexOpen, Long iexOpenTime, Double iexRealtimePrice, Long iexRealtimeSize, Long iexVolume, Long lastTradeTime, Double latestPrice, String latestSource, String latestTime, Long latestUpdate, Long latestVolume, Double low, String lowSource, Long lowTime, Long marketCap, Double oddLotDelayedPrice, Long oddLotDelayedPriceTime, Double open, Long openTime, String openSource, Double peRatio, Double previousClose, Long previousVolume, String primaryExchange, String symbol, Long volume, Double week52High, Double week52Low, Double ytdChange, Boolean isUSMarketOpen) {
        this.avgTotalVolume = avgTotalVolume;
        this.calculationPrice = calculationPrice;
        this.change = change;
        this.changePercent = changePercent;
        this.close = close;
        this.closeSource = closeSource;
        this.closeTime = closeTime;
        this.companyName = companyName;
        this.currency = currency;
        this.delayedPrice = delayedPrice;
        this.delayedPriceTime = delayedPriceTime;
        this.extendedChange = extendedChange;
        this.extendedChangePercent = extendedChangePercent;
        this.extendedPrice = extendedPrice;
        this.extendedPriceTime = extendedPriceTime;
        this.high = high;
        this.highSource = highSource;
        this.highTime = highTime;
        this.iexAskPrice = iexAskPrice;
        this.iexAskSize = iexAskSize;
        this.iexBidPrice = iexBidPrice;
        this.iexBidSize = iexBidSize;
        this.iexClose = iexClose;
        this.iexCloseTime = iexCloseTime;
        this.iexLastUpdated = iexLastUpdated;
        this.iexMarketPercent = iexMarketPercent;
        this.iexOpen = iexOpen;
        this.iexOpenTime = iexOpenTime;
        this.iexRealtimePrice = iexRealtimePrice;
        this.iexRealtimeSize = iexRealtimeSize;
        this.iexVolume = iexVolume;
        this.lastTradeTime = lastTradeTime;
        this.latestPrice = latestPrice;
        this.latestSource = latestSource;
        this.latestTime = latestTime;
        this.latestUpdate = latestUpdate;
        this.latestVolume = latestVolume;
        this.low = low;
        this.lowSource = lowSource;
        this.lowTime = lowTime;
        this.marketCap = marketCap;
        this.oddLotDelayedPrice = oddLotDelayedPrice;
        this.oddLotDelayedPriceTime = oddLotDelayedPriceTime;
        this.open = open;
        this.openTime = openTime;
        this.openSource = openSource;
        this.peRatio = peRatio;
        this.previousClose = previousClose;
        this.previousVolume = previousVolume;
        this.primaryExchange = primaryExchange;
        this.symbol = symbol;
        this.volume = volume;
        this.week52High = week52High;
        this.week52Low = week52Low;
        this.ytdChange = ytdChange;
        this.isUSMarketOpen = isUSMarketOpen;
    }

    public Long getAvgTotalVolume() {
        return avgTotalVolume;
    }

    public void setAvgTotalVolume(Long avgTotalVolume) {
        this.avgTotalVolume = avgTotalVolume;
    }

    public String getCalculationPrice() {
        return calculationPrice;
    }

    public void setCalculationPrice(String calculationPrice) {
        this.calculationPrice = calculationPrice;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Double getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(Double changePercent) {
        this.changePercent = changePercent;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public String getCloseSource() {
        return closeSource;
    }

    public void setCloseSource(String closeSource) {
        this.closeSource = closeSource;
    }

    public Long getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Long closeTime) {
        this.closeTime = closeTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getDelayedPrice() {
        return delayedPrice;
    }

    public void setDelayedPrice(Double delayedPrice) {
        this.delayedPrice = delayedPrice;
    }

    public Long getDelayedPriceTime() {
        return delayedPriceTime;
    }

    public void setDelayedPriceTime(Long delayedPriceTime) {
        this.delayedPriceTime = delayedPriceTime;
    }

    public Double getExtendedChange() {
        return extendedChange;
    }

    public void setExtendedChange(Double extendedChange) {
        this.extendedChange = extendedChange;
    }

    public Double getExtendedChangePercent() {
        return extendedChangePercent;
    }

    public void setExtendedChangePercent(Double extendedChangePercent) {
        this.extendedChangePercent = extendedChangePercent;
    }

    public Double getExtendedPrice() {
        return extendedPrice;
    }

    public void setExtendedPrice(Double extendedPrice) {
        this.extendedPrice = extendedPrice;
    }

    public Long getExtendedPriceTime() {
        return extendedPriceTime;
    }

    public void setExtendedPriceTime(Long extendedPriceTime) {
        this.extendedPriceTime = extendedPriceTime;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public String getHighSource() {
        return highSource;
    }

    public void setHighSource(String highSource) {
        this.highSource = highSource;
    }

    public Long getHighTime() {
        return highTime;
    }

    public void setHighTime(Long highTime) {
        this.highTime = highTime;
    }

    public Double getIexAskPrice() {
        return iexAskPrice;
    }

    public void setIexAskPrice(Double iexAskPrice) {
        this.iexAskPrice = iexAskPrice;
    }

    public Integer getIexAskSize() {
        return iexAskSize;
    }

    public void setIexAskSize(Integer iexAskSize) {
        this.iexAskSize = iexAskSize;
    }

    public Double getIexBidPrice() {
        return iexBidPrice;
    }

    public void setIexBidPrice(Double iexBidPrice) {
        this.iexBidPrice = iexBidPrice;
    }

    public Integer getIexBidSize() {
        return iexBidSize;
    }

    public void setIexBidSize(Integer iexBidSize) {
        this.iexBidSize = iexBidSize;
    }

    public Double getIexClose() {
        return iexClose;
    }

    public void setIexClose(Double iexClose) {
        this.iexClose = iexClose;
    }

    public Long getIexCloseTime() {
        return iexCloseTime;
    }

    public void setIexCloseTime(Long iexCloseTime) {
        this.iexCloseTime = iexCloseTime;
    }

    public Long getIexLastUpdated() {
        return iexLastUpdated;
    }

    public void setIexLastUpdated(Long iexLastUpdated) {
        this.iexLastUpdated = iexLastUpdated;
    }

    public Double getIexMarketPercent() {
        return iexMarketPercent;
    }

    public void setIexMarketPercent(Double iexMarketPercent) {
        this.iexMarketPercent = iexMarketPercent;
    }

    public Double getIexOpen() {
        return iexOpen;
    }

    public void setIexOpen(Double iexOpen) {
        this.iexOpen = iexOpen;
    }

    public Long getIexOpenTime() {
        return iexOpenTime;
    }

    public void setIexOpenTime(Long iexOpenTime) {
        this.iexOpenTime = iexOpenTime;
    }

    public Double getIexRealtimePrice() {
        return iexRealtimePrice;
    }

    public void setIexRealtimePrice(Double iexRealtimePrice) {
        this.iexRealtimePrice = iexRealtimePrice;
    }

    public Long getIexRealtimeSize() {
        return iexRealtimeSize;
    }

    public void setIexRealtimeSize(Long iexRealtimeSize) {
        this.iexRealtimeSize = iexRealtimeSize;
    }

    public Long getIexVolume() {
        return iexVolume;
    }

    public void setIexVolume(Long iexVolume) {
        this.iexVolume = iexVolume;
    }

    public Long getLastTradeTime() {
        return lastTradeTime;
    }

    public void setLastTradeTime(Long lastTradeTime) {
        this.lastTradeTime = lastTradeTime;
    }

    public Double getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(Double latestPrice) {
        this.latestPrice = latestPrice;
    }

    public String getLatestSource() {
        return latestSource;
    }

    public void setLatestSource(String latestSource) {
        this.latestSource = latestSource;
    }

    public String getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }

    public Long getLatestUpdate() {
        return latestUpdate;
    }

    public void setLatestUpdate(Long latestUpdate) {
        this.latestUpdate = latestUpdate;
    }

    public Long getLatestVolume() {
        return latestVolume;
    }

    public void setLatestVolume(Long latestVolume) {
        this.latestVolume = latestVolume;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public String getLowSource() {
        return lowSource;
    }

    public void setLowSource(String lowSource) {
        this.lowSource = lowSource;
    }

    public Long getLowTime() {
        return lowTime;
    }

    public void setLowTime(Long lowTime) {
        this.lowTime = lowTime;
    }

    public Long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }

    public Double getOddLotDelayedPrice() {
        return oddLotDelayedPrice;
    }

    public void setOddLotDelayedPrice(Double oddLotDelayedPrice) {
        this.oddLotDelayedPrice = oddLotDelayedPrice;
    }

    public Long getOddLotDelayedPriceTime() {
        return oddLotDelayedPriceTime;
    }

    public void setOddLotDelayedPriceTime(Long oddLotDelayedPriceTime) {
        this.oddLotDelayedPriceTime = oddLotDelayedPriceTime;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Long getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Long openTime) {
        this.openTime = openTime;
    }

    public String getOpenSource() {
        return openSource;
    }

    public void setOpenSource(String openSource) {
        this.openSource = openSource;
    }

    public Double getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(Double peRatio) {
        this.peRatio = peRatio;
    }

    public Double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(Double previousClose) {
        this.previousClose = previousClose;
    }

    public Long getPreviousVolume() {
        return previousVolume;
    }

    public void setPreviousVolume(Long previousVolume) {
        this.previousVolume = previousVolume;
    }

    public String getPrimaryExchange() {
        return primaryExchange;
    }

    public void setPrimaryExchange(String primaryExchange) {
        this.primaryExchange = primaryExchange;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Double getWeek52High() {
        return week52High;
    }

    public void setWeek52High(Double week52High) {
        this.week52High = week52High;
    }

    public Double getWeek52Low() {
        return week52Low;
    }

    public void setWeek52Low(Double week52Low) {
        this.week52Low = week52Low;
    }

    public Double getYtdChange() {
        return ytdChange;
    }

    public void setYtdChange(Double ytdChange) {
        this.ytdChange = ytdChange;
    }

    public Boolean getUSMarketOpen() {
        return isUSMarketOpen;
    }

    public void setUSMarketOpen(Boolean USMarketOpen) {
        isUSMarketOpen = USMarketOpen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return Objects.equals(avgTotalVolume, quote.avgTotalVolume) && Objects.equals(calculationPrice, quote.calculationPrice) && Objects.equals(change, quote.change) && Objects.equals(changePercent, quote.changePercent) && Objects.equals(close, quote.close) && Objects.equals(closeSource, quote.closeSource) && Objects.equals(closeTime, quote.closeTime) && Objects.equals(companyName, quote.companyName) && Objects.equals(currency, quote.currency) && Objects.equals(delayedPrice, quote.delayedPrice) && Objects.equals(delayedPriceTime, quote.delayedPriceTime) && Objects.equals(extendedChange, quote.extendedChange) && Objects.equals(extendedChangePercent, quote.extendedChangePercent) && Objects.equals(extendedPrice, quote.extendedPrice) && Objects.equals(extendedPriceTime, quote.extendedPriceTime) && Objects.equals(high, quote.high) && Objects.equals(highSource, quote.highSource) && Objects.equals(highTime, quote.highTime) && Objects.equals(iexAskPrice, quote.iexAskPrice) && Objects.equals(iexAskSize, quote.iexAskSize) && Objects.equals(iexBidPrice, quote.iexBidPrice) && Objects.equals(iexBidSize, quote.iexBidSize) && Objects.equals(iexClose, quote.iexClose) && Objects.equals(iexCloseTime, quote.iexCloseTime) && Objects.equals(iexLastUpdated, quote.iexLastUpdated) && Objects.equals(iexMarketPercent, quote.iexMarketPercent) && Objects.equals(iexOpen, quote.iexOpen) && Objects.equals(iexOpenTime, quote.iexOpenTime) && Objects.equals(iexRealtimePrice, quote.iexRealtimePrice) && Objects.equals(iexRealtimeSize, quote.iexRealtimeSize) && Objects.equals(iexVolume, quote.iexVolume) && Objects.equals(lastTradeTime, quote.lastTradeTime) && Objects.equals(latestPrice, quote.latestPrice) && Objects.equals(latestSource, quote.latestSource) && Objects.equals(latestTime, quote.latestTime) && Objects.equals(latestUpdate, quote.latestUpdate) && Objects.equals(latestVolume, quote.latestVolume) && Objects.equals(low, quote.low) && Objects.equals(lowSource, quote.lowSource) && Objects.equals(lowTime, quote.lowTime) && Objects.equals(marketCap, quote.marketCap) && Objects.equals(oddLotDelayedPrice, quote.oddLotDelayedPrice) && Objects.equals(oddLotDelayedPriceTime, quote.oddLotDelayedPriceTime) && Objects.equals(open, quote.open) && Objects.equals(openTime, quote.openTime) && Objects.equals(openSource, quote.openSource) && Objects.equals(peRatio, quote.peRatio) && Objects.equals(previousClose, quote.previousClose) && Objects.equals(previousVolume, quote.previousVolume) && Objects.equals(primaryExchange, quote.primaryExchange) && Objects.equals(symbol, quote.symbol) && Objects.equals(volume, quote.volume) && Objects.equals(week52High, quote.week52High) && Objects.equals(week52Low, quote.week52Low) && Objects.equals(ytdChange, quote.ytdChange) && Objects.equals(isUSMarketOpen, quote.isUSMarketOpen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(avgTotalVolume, calculationPrice, change, changePercent, close, closeSource, closeTime, companyName, currency, delayedPrice, delayedPriceTime, extendedChange, extendedChangePercent, extendedPrice, extendedPriceTime, high, highSource, highTime, iexAskPrice, iexAskSize, iexBidPrice, iexBidSize, iexClose, iexCloseTime, iexLastUpdated, iexMarketPercent, iexOpen, iexOpenTime, iexRealtimePrice, iexRealtimeSize, iexVolume, lastTradeTime, latestPrice, latestSource, latestTime, latestUpdate, latestVolume, low, lowSource, lowTime, marketCap, oddLotDelayedPrice, oddLotDelayedPriceTime, open, openTime, openSource, peRatio, previousClose, previousVolume, primaryExchange, symbol, volume, week52High, week52Low, ytdChange, isUSMarketOpen);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "avgTotalVolume=" + avgTotalVolume +
                ", calculationPrice='" + calculationPrice + '\'' +
                ", change=" + change +
                ", changePercent=" + changePercent +
                ", close=" + close +
                ", closeSource='" + closeSource + '\'' +
                ", closeTime=" + closeTime +
                ", companyName='" + companyName + '\'' +
                ", currency='" + currency + '\'' +
                ", delayedPrice=" + delayedPrice +
                ", delayedPriceTime=" + delayedPriceTime +
                ", extendedChange=" + extendedChange +
                ", extendedChangePercent=" + extendedChangePercent +
                ", extendedPrice=" + extendedPrice +
                ", extendedPriceTime=" + extendedPriceTime +
                ", high=" + high +
                ", highSource='" + highSource + '\'' +
                ", highTime=" + highTime +
                ", iexAskPrice=" + iexAskPrice +
                ", iexAskSize=" + iexAskSize +
                ", iexBidPrice=" + iexBidPrice +
                ", iexBidSize=" + iexBidSize +
                ", iexClose=" + iexClose +
                ", iexCloseTime=" + iexCloseTime +
                ", iexLastUpdated=" + iexLastUpdated +
                ", iexMarketPercent=" + iexMarketPercent +
                ", iexOpen=" + iexOpen +
                ", iexOpenTime=" + iexOpenTime +
                ", iexRealtimePrice=" + iexRealtimePrice +
                ", iexRealtimeSize=" + iexRealtimeSize +
                ", iexVolume=" + iexVolume +
                ", lastTradeTime=" + lastTradeTime +
                ", latestPrice=" + latestPrice +
                ", latestSource='" + latestSource + '\'' +
                ", latestTime='" + latestTime + '\'' +
                ", latestUpdate=" + latestUpdate +
                ", latestVolume=" + latestVolume +
                ", low=" + low +
                ", lowSource='" + lowSource + '\'' +
                ", lowTime=" + lowTime +
                ", marketCap=" + marketCap +
                ", oddLotDelayedPrice=" + oddLotDelayedPrice +
                ", oddLotDelayedPriceTime=" + oddLotDelayedPriceTime +
                ", open=" + open +
                ", openTime=" + openTime +
                ", openSource='" + openSource + '\'' +
                ", peRatio=" + peRatio +
                ", previousClose=" + previousClose +
                ", previousVolume=" + previousVolume +
                ", primaryExchange='" + primaryExchange + '\'' +
                ", symbol='" + symbol + '\'' +
                ", volume=" + volume +
                ", week52High=" + week52High +
                ", week52Low=" + week52Low +
                ", ytdChange=" + ytdChange +
                ", isUSMarketOpen=" + isUSMarketOpen +
                '}';
    }
}
