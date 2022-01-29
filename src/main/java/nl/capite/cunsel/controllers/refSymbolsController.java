package nl.capite.cunsel.controllers;

import nl.capite.cunsel.models.refSymbol;
import nl.capite.cunsel.services.RefSymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class refSymbolsController {

    @Autowired
    RefSymbolService ser;

    @CrossOrigin
    @GetMapping("/api/x/symbols")
    public List<refSymbol> getRefSymbols() {
        return ser.getRefSymbols();
    }

    @CrossOrigin
    @GetMapping("/api/x/symbols/cs")
    public List<refSymbol> getCommonStock(){return ser.getRefSymbolsForCommonStock();}

    @CrossOrigin
    @GetMapping("/api/x/symbol/{symbol}")
    public refSymbol getRefSymbol(@PathVariable String symbol) {
        return  ser.getRefSymbol(symbol.toUpperCase());
    }
}
