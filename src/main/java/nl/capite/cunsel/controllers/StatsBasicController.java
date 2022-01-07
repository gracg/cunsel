package nl.capite.cunsel.controllers;

import nl.capite.cunsel.models.Logo;
import nl.capite.cunsel.models.StatsBasic;
import nl.capite.cunsel.repositories.StatsBasicRepository;
import nl.capite.cunsel.services.StatsBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatsBasicController {

    @Autowired
    StatsBasicService ser;

    @CrossOrigin
    @GetMapping("/api/x/stats-basic")
    public List<StatsBasic> getStatsBasic(){
        return ser.getStatsBasic();
    }

    @CrossOrigin
    @GetMapping("/api/x/stats-basic/{symbol}")
    StatsBasic getLogo(@PathVariable String symbol) {
        return ser.getStatsBasicForSymbol(symbol);
    }

}
