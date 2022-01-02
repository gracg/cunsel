package nl.capite.cunsel.services;

import nl.capite.cunsel.models.Company;
import nl.capite.cunsel.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyService {

    @Autowired
    CompanyRepository repo;

    public List<Company> getCompanies(){return repo.getCompanies();}
}
