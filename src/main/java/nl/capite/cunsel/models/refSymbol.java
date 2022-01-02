package nl.capite.cunsel.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import nl.capite.cunsel.interfaces.GenericIdInterface;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 References https://iexcloud.io/docs/api/#symbols
 date field is ignored and not included

 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="symbols")
public class refSymbol implements GenericIdInterface {
    @Id
    private String symbol;
    private String exchange;
    @Column(name = "exchangeSuffix")
    private String exchangeSuffix;
    @Column(name = "exchangeName")
    private String exchangeName;
    @Column(name = "exchangeSegment")
    private String exchangeSegment;
    @Column(name = "exchangeSegmentName")
    private String exchangeSegmentName;
    private String name;
    private String type;
    @Column(name = "iexId")
    private String iexId;
    private String region;
    private String currency;
    @Column(name = "isEnabled")
    private boolean isEnabled;
    private String figi;
    private String cik;
    private String lei;

    public refSymbol() {
    }

    public refSymbol(String symbol, String exchange, String exchangeSuffix, String exchangeName, String exchangeSegment, String exchangeSegmentName, String name, String type, String iexId, String region, String currency, boolean isEnabled, String figi, String cik, String lei) {
        this.symbol = symbol;
        this.exchange = exchange;
        this.exchangeSuffix = exchangeSuffix;
        this.exchangeName = exchangeName;
        this.exchangeSegment = exchangeSegment;
        this.exchangeSegmentName = exchangeSegmentName;
        this.name = name;
        this.type = type;
        this.iexId = iexId;
        this.region = region;
        this.currency = currency;
        this.isEnabled = isEnabled;
        this.figi = figi;
        this.cik = cik;
        this.lei = lei;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getExchangeSuffix() {
        return exchangeSuffix;
    }

    public void setExchangeSuffix(String exchangeSuffix) {
        this.exchangeSuffix = exchangeSuffix;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getExchangeSegment() {
        return exchangeSegment;
    }

    public void setExchangeSegment(String exchangeSegment) {
        this.exchangeSegment = exchangeSegment;
    }

    public String getExchangeSegmentName() {
        return exchangeSegmentName;
    }

    public void setExchangeSegmentName(String exchangeSegmentName) {
        this.exchangeSegmentName = exchangeSegmentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIexId() {
        return iexId;
    }

    public void setIexId(String iexId) {
        this.iexId = iexId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public String getCik() {
        return cik;
    }

    public void setCik(String cik) {
        this.cik = cik;
    }

    public String getLei() {
        return lei;
    }

    public void setLei(String lei) {
        this.lei = lei;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof refSymbol)) return false;
        refSymbol refSymbol = (refSymbol) o;
        return isEnabled() == refSymbol.isEnabled() && Objects.equals(getSymbol(), refSymbol.getSymbol()) && Objects.equals(getExchange(), refSymbol.getExchange()) && Objects.equals(getExchangeSuffix(), refSymbol.getExchangeSuffix()) && Objects.equals(getExchangeName(), refSymbol.getExchangeName()) && Objects.equals(getExchangeSegment(), refSymbol.getExchangeSegment()) && Objects.equals(getExchangeSegmentName(), refSymbol.getExchangeSegmentName()) && Objects.equals(getName(), refSymbol.getName()) && Objects.equals(getType(), refSymbol.getType()) && Objects.equals(getIexId(), refSymbol.getIexId()) && Objects.equals(getRegion(), refSymbol.getRegion()) && Objects.equals(getCurrency(), refSymbol.getCurrency()) && Objects.equals(getFigi(), refSymbol.getFigi()) && Objects.equals(getCik(), refSymbol.getCik()) && Objects.equals(getLei(), refSymbol.getLei());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSymbol(), getExchange(), getExchangeSuffix(), getExchangeName(), getExchangeSegment(), getExchangeSegmentName(), getName(), getType(), getIexId(), getRegion(), getCurrency(), isEnabled(), getFigi(), getCik(), getLei());
    }

    @Override
    public String getGenericId() {
        return symbol;
    }
}
