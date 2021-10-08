package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.util.List;

@Repository
public interface AccountTypeRepo extends CrudRepository<AccountTypeDto,Long> {
}