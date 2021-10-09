package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface AccountTypeRepo extends JpaRepository<AccountType,Long> {

   @Query(value = "SELECT at"+
            " FROM"+
            " AccountType at"+
            " WHERE "+
            " at.CreationDate"+
            " = ?1 ")
   Collection<AccountType> FetchAccountsByDate(LocalDate date);
}