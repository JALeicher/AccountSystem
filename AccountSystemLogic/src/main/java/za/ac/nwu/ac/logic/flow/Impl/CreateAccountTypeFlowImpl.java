package za.ac.nwu.ac.logic.flow.Impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;

@Component
public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow {

    private  final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto CreateAccountType(AccountTypeDto accountType) {
        if (null == accountType.getCreationDate()) {
            accountType.setCreationDate(LocalDate.now());
        }
        return accountTypeTranslator.CreateAccountType(accountType);
    }
}
