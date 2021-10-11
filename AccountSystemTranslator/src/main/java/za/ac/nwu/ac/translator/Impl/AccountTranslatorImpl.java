package za.ac.nwu.ac.translator.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.domain.persistence.Account;
import za.ac.nwu.ac.domain.persistence.Currency;
import za.ac.nwu.ac.domain.persistence.Transaction;
import za.ac.nwu.ac.repo.persistence.AccountRepo;
import za.ac.nwu.ac.repo.persistence.CurrencyRepo;
import za.ac.nwu.ac.repo.persistence.TransactionRepo;
import za.ac.nwu.ac.translator.AccountTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTranslatorImpl implements AccountTranslator {

    private final AccountRepo accountRepo;
    private final CurrencyRepo currencyRepo;
    private final TransactionRepo transactionRepo;

    @Autowired
    public AccountTranslatorImpl(AccountRepo accountRepo, CurrencyRepo currencyRepo, TransactionRepo transactionRepo) {
        this.accountRepo = accountRepo;
        this.currencyRepo = currencyRepo;
        this.transactionRepo = transactionRepo;
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

    @Override
    public AccountDto FetchById(Long id) {
        Account account = this.accountRepo.fetchAccountById(id);
        return new AccountDto(account);
    }

    @Override
    public AccountDto FetchByEMail(String mail){
        Account account = this.accountRepo.fetchAccountByEmail(mail);
        return new AccountDto(account);
    }

    @Override
    public AccountDto AddMiles(Long id,Integer amount) {
        this.accountRepo.addMilesToAccount(id,amount);
        Account account = accountRepo.fetchAccountById(id);
        String type ="ADD";
        Transaction transaction = transactionRepo.save(new Transaction(account,type,LocalDate.now(),amount));
        return new AccountDto(account);
    }

    @Override
    public AccountDto SubMiles(Long id, Integer amount) {
        this.accountRepo.subMilesFromAccount(id,amount);
        Account account = accountRepo.fetchAccountById(id);
        String type ="SUB";
        Transaction transaction = transactionRepo.save(new Transaction(account,type,LocalDate.now(),amount));
        return new AccountDto(account);
    }
}
