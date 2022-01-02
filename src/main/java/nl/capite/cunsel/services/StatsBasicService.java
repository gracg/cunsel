package nl.capite.cunsel.services;

import nl.capite.cunsel.models.StatsBasic;
import nl.capite.cunsel.repositories.StatsBasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StatsBasicService {
    @Autowired
    StatsBasicRepository repo;

    public List<StatsBasic> getStatsBasic() {return repo.getStatsBasic();}
    public StatsBasic getStatsBasicForSymbol(String symbol){return repo.getStatsBasic(symbol);}
}
