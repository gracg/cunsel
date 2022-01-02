package nl.capite.cunsel.services;

import nl.capite.cunsel.models.Logo;
import nl.capite.cunsel.repositories.LogoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LogoService {
    @Autowired
    LogoInterface repo;

    public List<Logo> getLogos() {
        return repo.getLogos();
    }

    public Logo getLogo(String symbol) {
        return repo.getLogo(symbol);
    }
}
