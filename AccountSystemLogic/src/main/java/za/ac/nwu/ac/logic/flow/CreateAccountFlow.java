package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountDto;

public interface CreateAccountFlow {
    AccountDto CreateAccount(AccountDto accountDto);
}
