package nl.capite.cunsel.repositories;

import nl.capite.cunsel.models.Logo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogoInterface extends CrudRepository<Logo,String> {

    @Query(value = "SELECT * FROM LOGOS ORDER BY symbol ASC",nativeQuery = true)
    List<Logo> getLogos();

    @Query(value = "SELECT * FROM LOGOS where symbol=?1",nativeQuery = true)
    Logo getLogo(String symbol);
}
