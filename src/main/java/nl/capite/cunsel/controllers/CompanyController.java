package nl.capite.cunsel.controllers;

import nl.capite.cunsel.models.Company;
import nl.capite.cunsel.models.refSymbol;
import nl.capite.cunsel.services.CompanyService;
import nl.capite.cunsel.services.RefSymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyService ser;

    @CrossOrigin
    @GetMapping("/api/x/companies")
    public List<Company> getRefSymbols() {
        return ser.getCompanies();
    }

    @CrossOrigin
    @GetMapping("/api/x/company/{symbol}")
    public Company getCompany(@PathVariable String symbol) {
        return ser.getCompany(symbol.toUpperCase());
    }



}
