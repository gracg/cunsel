package nl.capite.cunsel.services;

import nl.capite.cunsel.models.refSymbol;
import nl.capite.cunsel.repositories.RefSymbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RefSymbolService {
    @Autowired
    RefSymbolRepository repo;

    public List<refSymbol> getRefSymbols() {
        return repo.getRefSymbols();
    }

    public List<refSymbol> getRefSymbolsForCommonStock(){return repo.getRefSymbolsForCommonStock();}
}
