package nl.capite.cunsel.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;
import java.util.Objects;



public class BatchQuote {
    private String ticker;
    private Quote quote;

    public BatchQuote() {
    }

    public BatchQuote(String ticker, Quote quote) {
        this.ticker = ticker;
        this.quote = quote;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BatchQuote that = (BatchQuote) o;
        return Objects.equals(ticker, that.ticker) && Objects.equals(quote, that.quote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticker, quote);
    }
}
