package nl.capite.cunsel.controllers;

import nl.capite.cunsel.models.refSymbol;
import nl.capite.cunsel.services.RefSymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class refSymbolsController {

    @Autowired
    RefSymbolService ser;

    @GetMapping("/api/symbols")
    public List<refSymbol> getRefSymbols() {
        return ser.getRefSymbols();
    }

    @GetMapping("/api/symbols/cs")
    public List<refSymbol> getCommonStock(){return ser.getRefSymbolsForCommonStock();}
}
