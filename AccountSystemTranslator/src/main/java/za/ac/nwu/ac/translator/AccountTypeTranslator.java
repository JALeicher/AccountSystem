package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.util.List;

public interface AccountTypeTranslator {

    List<AccountTypeDto>getAllAccountTypes();

    AccountTypeDto CreateAccountType(AccountTypeDto accountTypeDto);

    List<AccountTypeDto> FetchAccountsByDate(String date);
}
