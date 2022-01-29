package nl.capite.cunsel.repositories;

import nl.capite.cunsel.models.Company;
import nl.capite.cunsel.models.refSymbol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, String> {

    @Query(value = "SELECT " +
            "symbol," +
            "companyName as company_name," +
            "exchange," +
            "industry," +
            "website," +
            "description,"+
            "ceo as ceo," +
            "securityName as security_name," +
            "issueType as issue_type," +
            "sector," +
            "primarySicCode as primary_sic_code," +
            "employees," +
            "tags as tags," +
            "address," +
            "address2," +
            "state," +
            "city," +
            "zip," +
            "country," +
            "phone " +
            "FROM COMPANIES",nativeQuery = true)
    public List<Company> getCompanies();

    @Query(value = "SELECT " +
            "symbol," +
            "companyName as company_name," +
            "exchange," +
            "industry," +
            "website," +
            "description,"+
            "ceo as ceo," +
            "securityName as security_name," +
            "issueType as issue_type," +
            "sector," +
            "primarySicCode as primary_sic_code," +
            "employees," +
            "tags as tags," +
            "address," +
            "address2," +
            "state," +
            "city," +
            "zip," +
            "country," +
            "phone " +
            "FROM COMPANIES " +
            "WHERE symbol=?1",nativeQuery = true)
    public Company getCompany(String symbol);
}
