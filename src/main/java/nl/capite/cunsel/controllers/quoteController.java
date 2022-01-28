package nl.capite.cunsel.controllers;

import nl.capite.cunsel.models.BatchQuote;
import nl.capite.cunsel.models.Logo;
import nl.capite.cunsel.models.Quote;
import nl.capite.cunsel.services.LogoService;
import nl.capite.cunsel.services.iexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class quoteController {

    @Autowired
    iexService ser;
    @Autowired
    LogoService logos;

    @CrossOrigin
    @GetMapping("/api/x/quote/{symbol}")
    Quote getQuote(@PathVariable String symbol) throws IOException {
        return ser.getQuote(symbol.toUpperCase());
    }

    @CrossOrigin
    @GetMapping("/api/x/quotes")
    List<BatchQuote> getQuotes() throws IOException {
        List<String> tickers = logos.getLogos().stream().map(n -> n.getTicker().toUpperCase()).collect(Collectors.toList());
        return ser.getQuotes(tickers);
    }
}
