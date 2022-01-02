package nl.capite.cunsel.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import nl.capite.cunsel.interfaces.GenericIdInterface;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
/*
 https://iexcloud.io/docs/api/#company
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="companies")
public class Company  implements GenericIdInterface {
    @Id
    private  String symbol;
    @Column(name = "companyName")
    private  String companyName;
    private  String exchange;
    private  String industry;
    private  String website;
    private  String description;
    @JsonProperty("CEO")
    private  String ceo;
    @Column(name = "securityName")
    private  String securityName;
    @Column(name = "issueType")
    private  String issueType;
    private  String sector;
    @Column(name = "primarySicCode")
    private  Integer primarySicCode;
    private  Integer employees;
    @ElementCollection()
    @Column(name = "tags")
    @JsonIgnore
    private  List<String> tags = new ArrayList<>();
    private  String address;
    private  String address2;
    private  String state;
    private  String city;
    private  String zip;
    private  String country;
    private  String phone;

    public Company() {
    }

    public Company(String symbol, String companyName, String exchange, String industry, String website, String description, String ceo, String securityName, String issueType, String sector, Integer primarySicCode, Integer employees, List<String> tags, String address, String address2, String state, String city, String zip, String country, String phone) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.exchange = exchange;
        this.industry = industry;
        this.website = website;
        this.description = description;
        this.ceo = ceo;
        this.securityName = securityName;
        this.issueType = issueType;
        this.sector = sector;
        this.primarySicCode = primarySicCode;
        this.employees = employees;
        this.tags = tags;
        this.address = address;
        this.address2 = address2;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.phone = phone;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Integer getPrimarySicCode() {
        return primarySicCode;
    }

    public void setPrimarySicCode(Integer primarySicCode) {
        this.primarySicCode = primarySicCode;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    public List<String> getTags() {
        return tags;
    }

    @JsonIgnore
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(symbol, company.symbol) && Objects.equals(companyName, company.companyName) && Objects.equals(exchange, company.exchange) && Objects.equals(industry, company.industry) && Objects.equals(website, company.website) && Objects.equals(description, company.description) && Objects.equals(ceo, company.ceo) && Objects.equals(securityName, company.securityName) && Objects.equals(issueType, company.issueType) && Objects.equals(sector, company.sector) && Objects.equals(primarySicCode, company.primarySicCode) && Objects.equals(employees, company.employees) && Objects.equals(tags, company.tags) && Objects.equals(address, company.address) && Objects.equals(address2, company.address2) && Objects.equals(state, company.state) && Objects.equals(city, company.city) && Objects.equals(zip, company.zip) && Objects.equals(country, company.country) && Objects.equals(phone, company.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, companyName, exchange, industry, website, description, ceo, securityName, issueType, sector, primarySicCode, employees, tags, address, address2, state, city, zip, country, phone);
    }

    @JsonIgnore
    @Override
    public String getGenericId() {
        return getSymbol();
    }
}
