package za.ac.nwu.ac.translator;


import za.ac.nwu.ac.domain.dto.AccountDto;


import java.util.List;

public interface AccountTranslator {
     AccountDto CreateAccount(AccountDto accountDto);
     List<AccountDto> GetAllAccounts();
     AccountDto FetchById(Long id);
     AccountDto AddMiles(Long id,Integer amount);
     AccountDto SubMiles(Long id, Integer amount);
     AccountDto FetchByEMail(String mail);
}
