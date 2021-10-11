package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.ac.domain.persistence.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {

    @Query(value = "SELECT a FROM Accounts a WHERE a.accountId = ?1")
    Account fetchAccountById(Long id);

    @Query(value = "SELECT a FROM Accounts a WHERE a.accountEMail = ?1")
    Account fetchAccountByEmail(String mail);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Accounts a SET a.milesBalance = (a.milesBalance+ :amount) WHERE a.accountId = :id")
    void addMilesToAccount(Long id, Integer amount);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Accounts a SET a.milesBalance = (a.milesBalance- :amount) WHERE a.accountId = :id")
    void subMilesFromAccount(Long id, Integer amount);
}
