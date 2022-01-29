package nl.capite.cunsel.models;

import java.util.Objects;

public class aCompany {
    private String symbol;
    private Company company;
    private Logo logo;
    private refSymbol refSymbol;
    private StatsBasic stats;

    public aCompany() {
    }

    public aCompany(String symbol, Company company, Logo logo, nl.capite.cunsel.models.refSymbol refSymbol, StatsBasic stats) {
        this.symbol = symbol;
        this.company = company;
        this.logo = logo;
        this.refSymbol = refSymbol;
        this.stats = stats;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }

    public nl.capite.cunsel.models.refSymbol getRefSymbol() {
        return refSymbol;
    }

    public void setRefSymbol(nl.capite.cunsel.models.refSymbol refSymbol) {
        this.refSymbol = refSymbol;
    }

    public StatsBasic getStats() {
        return stats;
    }

    public void setStats(StatsBasic stats) {
        this.stats = stats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        aCompany aCompany = (aCompany) o;
        return Objects.equals(symbol, aCompany.symbol) && Objects.equals(company, aCompany.company) && Objects.equals(logo, aCompany.logo) && Objects.equals(refSymbol, aCompany.refSymbol) && Objects.equals(stats, aCompany.stats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, company, logo, refSymbol, stats);
    }
}
