package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountDto;

public interface EditAccountFlow {
    AccountDto AddMiles(Long id, Integer amount);
    AccountDto SubMiles(Long id, Integer amount);
}
