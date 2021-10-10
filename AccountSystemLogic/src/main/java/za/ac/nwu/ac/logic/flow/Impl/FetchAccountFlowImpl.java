package za.ac.nwu.ac.logic.flow.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.logic.flow.FetchAccountFlow;
import za.ac.nwu.ac.translator.AccountTranslator;

import java.util.List;

@Component
public class FetchAccountFlowImpl implements FetchAccountFlow {
    private AccountTranslator accountTranslator;

    @Autowired
    public FetchAccountFlowImpl(AccountTranslator accountTranslator) {
        this.accountTranslator = accountTranslator;
    }

    @Override
    public List<AccountDto> GetAllAccounts() {
        return this.accountTranslator.GetAllAccounts();
    }

    @Override
    public AccountDto FetchById(Long id) {
        return this.accountTranslator.FetchById(id);
    }


}
