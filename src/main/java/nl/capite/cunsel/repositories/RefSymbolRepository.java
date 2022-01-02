package nl.capite.cunsel.repositories;

import nl.capite.cunsel.models.refSymbol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefSymbolRepository extends CrudRepository<refSymbol, String> {
    @Query(value = "SELECT " +
            "symbol," +
            "exchange," +
            "exchangeSuffix as exchange_suffix," +
            "exchangeName as exchange_name," +
            "exchangeSegment as exchange_segment," +
            "exchangeSegmentName as exchange_segment_name," +
            "name," +
            "type," +
            "iexId as iex_id," +
            "region," +
            "currency," +
            "isEnabled as is_enabled," +
            "figi," +
            "cik," +
            "lei " +
            "FROM SYMBOLS ORDER BY symbol ASC"
            ,nativeQuery = true)
    public List<refSymbol> getRefSymbols();

    @Query(value = "SELECT " +
            "symbol," +
            "exchange," +
            "exchangeSuffix as exchange_suffix," +
            "exchangeName as exchange_name," +
            "exchangeSegment as exchange_segment," +
            "exchangeSegmentName as exchange_segment_name," +
            "name," +
            "type," +
            "iexId as iex_id," +
            "region," +
            "currency," +
            "isEnabled as is_enabled," +
            "figi," +
            "cik," +
            "lei " +
            "FROM SYMBOLS WHERE type='cs' ORDER BY symbol ASC;",nativeQuery = true)
    public List<refSymbol> getRefSymbolsForCommonStock();

}
