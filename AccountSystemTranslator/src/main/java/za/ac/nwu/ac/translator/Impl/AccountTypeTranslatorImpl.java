package za.ac.nwu.ac.translator.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepo;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator{

    private final AccountTypeRepo accountTypeRepo;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepo accountTypeRepo) {
        this.accountTypeRepo = accountTypeRepo;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {

        List<AccountTypeDto> accountTypeDtoList = new ArrayList<AccountTypeDto>();
        try {
            for (AccountType x :accountTypeRepo.findAll())accountTypeDtoList.add(new AccountTypeDto(x));
        }
        catch(Exception error){
            throw new RuntimeException("THIS IS FUCKED");
        }
        return accountTypeDtoList;
    }

    @Override
    public AccountTypeDto CreateAccountType(AccountTypeDto accountTypeDto) {
        try {
                AccountType accountType = accountTypeRepo.save(accountTypeDto.getAccountType());
                return new AccountTypeDto(accountType);
        }
        catch (Exception e){
            throw new RuntimeException("Cannot save to DB");
        }
    }

    @Override
    public List<AccountTypeDto> FetchAccountsByDate(String date) {
        Collection<AccountType> accountTypeList;
        List<AccountTypeDto> accountTypeDtoList = new ArrayList<>();
        try {
            accountTypeList = accountTypeRepo.FetchAccountsByDate(LocalDate.parse(date));
            for (AccountType i: accountTypeList) {
                accountTypeDtoList.add(new AccountTypeDto(i));
            }

        }
        catch (Exception e){
            throw new RuntimeException("Cannot execute query");
        }
        return accountTypeDtoList;
    }
}
