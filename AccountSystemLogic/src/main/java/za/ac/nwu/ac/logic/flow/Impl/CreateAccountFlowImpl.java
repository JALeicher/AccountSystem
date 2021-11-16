package za.ac.nwu.ac.logic.flow.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.logic.flow.CreateAccountFlow;
import za.ac.nwu.ac.translator.AccountTranslator;

@Component
public class CreateAccountFlowImpl implements CreateAccountFlow {
    private final AccountTranslator accountTranslator;

    @Autowired
    public CreateAccountFlowImpl(AccountTranslator accountTranslator) {
        this.accountTranslator = accountTranslator;
    }

    @Override
    public AccountDto CreateAccount(AccountDto accountDto) {
        return accountTranslator.CreateAccount(accountDto);
    }
}
