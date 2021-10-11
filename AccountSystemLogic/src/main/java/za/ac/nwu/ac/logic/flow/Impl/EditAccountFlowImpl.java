package za.ac.nwu.ac.logic.flow.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.logic.flow.EditAccountFlow;
import za.ac.nwu.ac.translator.AccountTranslator;

@Component
public class EditAccountFlowImpl implements EditAccountFlow {
    private AccountTranslator accountTranslator;

    @Autowired
    public EditAccountFlowImpl(AccountTranslator accountTranslator) {
        this.accountTranslator = accountTranslator;
    }

    @Override
    public AccountDto AddMiles(Long id, Integer amount) {
        return accountTranslator.AddMiles(id,amount);
    }

    @Override
    public AccountDto SubMiles(Long id, Integer amount) {
        return accountTranslator.SubMiles(id,amount);
    }
}
