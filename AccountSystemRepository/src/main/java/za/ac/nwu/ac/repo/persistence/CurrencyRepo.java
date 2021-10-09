package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.Currency;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency,Long> {
    @Query(value = "SELECT c FROM Currencies c WHERE c.currencySymbol = ?1")
    Currency fetchCurrencyBySymbol(String symbol);

}
