package nl.capite.cunsel.services;

import nl.capite.cunsel.Helpers.iexHelper;
import nl.capite.cunsel.models.BatchQuote;
import nl.capite.cunsel.models.Quote;
import nl.capite.cunsel.util;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class iexService {
    private iexHelper iex;

    iexService() throws IOException {
        var prop = util.getProperties();
        this.iex= new iexHelper(prop.getProperty("iex.apikey"));
    }

    public Quote getQuote(String ticker) throws IOException {
        return this.iex.getQuote(ticker);
    }

    public List<BatchQuote> getQuotes(List<String> tickers) throws IOException {
        return this.iex.getBatchQuotes(tickers);
    }
}
