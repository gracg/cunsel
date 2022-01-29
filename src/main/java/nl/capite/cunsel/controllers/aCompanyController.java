package nl.capite.cunsel.controllers;

import nl.capite.cunsel.models.*;
import nl.capite.cunsel.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class aCompanyController {

    @Autowired
    CompanyService company;

    @Autowired
    LogoService logo;

    @Autowired
    RefSymbolService ref;

    @Autowired
    StatsBasicService stats;

    @Autowired
    nl.capite.cunsel.services.iexService iexService;

    @CrossOrigin
    @GetMapping("/api/companies")
    public List<aCompany> getCompanies() {
        List<aCompany> aCompaniesList = new ArrayList<>();

        List<Logo> logosList = logo.getLogos();
        List<String> tickers = logosList.stream().map(n -> n.getTicker().toUpperCase()).collect(Collectors.toList());
        List<Company> companiesList = company.getCompanies();
        List<refSymbol> refsList = ref.getRefSymbols();
        List<StatsBasic> statsList = stats.getStatsBasic();

        tickers.forEach(t -> {
            aCompany aComp = new aCompany();
            aComp.setSymbol(t);
            logosList.stream().filter(n -> n.getTicker().toUpperCase().equals(t)).forEach(aComp::setLogo);
            companiesList.stream().filter(n -> n.getSymbol().toUpperCase().equals(t)).forEach(aComp::setCompany);
            refsList.stream().filter(n -> n.getSymbol().toUpperCase().equals(t)).forEach(aComp::setRefSymbol);
            statsList.stream().filter(n -> n.getTicker().toUpperCase().equals(t)).forEach(aComp::setStats);
            aCompaniesList.add(aComp);
        });
        return aCompaniesList;
    }

    @CrossOrigin
    @GetMapping("/api/company/{symbol}")
    public aCompany getCompany(@PathVariable String symbol) {
        symbol = symbol.toUpperCase();

        aCompany aComp = new aCompany();
        aComp.setSymbol(symbol);
        aComp.setLogo(logo.getLogo(symbol));
        aComp.setCompany(company.getCompany(symbol));
        aComp.setRefSymbol(ref.getRefSymbol(symbol));
        aComp.setStats(stats.getStatsBasicForSymbol(symbol));
        return aComp;
    }
}
