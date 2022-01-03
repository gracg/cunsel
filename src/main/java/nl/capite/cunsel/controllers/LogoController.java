package nl.capite.cunsel.controllers;

import nl.capite.cunsel.models.Logo;
import nl.capite.cunsel.services.LogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogoController {

    @Autowired
    LogoService ser;

    @CrossOrigin
    @GetMapping("/api/logos")
    List<Logo> getLogos(){
        return ser.getLogos();
    }

    @CrossOrigin
    @GetMapping("/api/logos/{symbol}")
    Logo getLogo(@PathVariable String symbol) {
        return ser.getLogo(symbol);
    }

}
