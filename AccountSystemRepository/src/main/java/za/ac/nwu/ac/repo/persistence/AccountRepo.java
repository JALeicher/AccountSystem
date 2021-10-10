package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {
    @Query(value = "SELECT a FROM Accounts a WHERE a.accountId = ?1")
    Account fetchAccountById(Long id);
}
