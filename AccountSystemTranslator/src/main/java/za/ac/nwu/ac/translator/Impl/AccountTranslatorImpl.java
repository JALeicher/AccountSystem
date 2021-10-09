package za.ac.nwu.ac.translator.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.domain.persistence.Account;
import za.ac.nwu.ac.domain.persistence.Currency;
import za.ac.nwu.ac.repo.persistence.AccountRepo;
import za.ac.nwu.ac.repo.persistence.CurrencyRepo;
import za.ac.nwu.ac.translator.AccountTranslator;
import za.ac.nwu.ac.translator.CurrencyTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTranslatorImpl implements AccountTranslator {

    private final AccountRepo accountRepo;
    private final CurrencyRepo currencyRepo;

    @Autowired
    public AccountTranslatorImpl(AccountRepo accountRepo, CurrencyTranslator currencyTranslator, CurrencyRepo currencyRepo) {
        this.accountRepo = accountRepo;
        this.currencyRepo = currencyRepo;
    }

    @Override
    public AccountDto CreateAccount(AccountDto accountDto) {
        Currency currency = currencyRepo.fetchCurrencyBySymbol(accountDto.getAccountCurrency());
        Account account = this.accountRepo.save(accountDto.BuildAccount(currency));
        return new AccountDto(account);
    }

    @Override
    public List<AccountDto> GetAllAccounts() {
        List<AccountDto> accountDtoList = new ArrayList<>();
        for (Account x: this.accountRepo.findAll()) {
            accountDtoList.add(new AccountDto(x));
        }
        return accountDtoList;
    }
}
