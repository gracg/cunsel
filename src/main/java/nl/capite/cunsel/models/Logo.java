package nl.capite.cunsel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.capite.cunsel.interfaces.GenericIdInterface;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Logo implements GenericIdInterface {
    @Id
    @Column(name = "symbol")
    private String ticker;
    private String url;

    public Logo() {
    }

    public Logo(String ticker, String url) {
        this.ticker = ticker;
        this.url = url;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Logo)) return false;
        Logo logo = (Logo) o;
        return getTicker().equals(logo.getTicker()) && getUrl().equals(logo.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTicker(), getUrl());
    }

    @JsonIgnore
    @Override
    public String getGenericId() {
        return ticker;
    }
}
