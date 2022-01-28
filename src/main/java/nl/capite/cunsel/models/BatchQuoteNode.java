package nl.capite.cunsel.models;

import java.util.Objects;

public class BatchQuoteNode {
    private Quote quote;

    public BatchQuoteNode() {
    }

    public BatchQuoteNode(Quote quote) {
        this.quote = quote;
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
        BatchQuoteNode that = (BatchQuoteNode) o;
        return Objects.equals(quote, that.quote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quote);
    }

    @Override
    public String toString() {
        return quote.toString();
    }
}