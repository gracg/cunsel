package nl.capite.cunsel.controllers;

import nl.capite.cunsel.models.Logo;
import nl.capite.cunsel.models.Quote;
import nl.capite.cunsel.services.iexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class quoteController {

    @Autowired
    iexService ser;

    @GetMapping("/api/x/quote/{symbol}")
    Quote getLogo(@PathVariable String symbol) throws IOException {
        return ser.getQuote(symbol.toUpperCase());
    }
}
