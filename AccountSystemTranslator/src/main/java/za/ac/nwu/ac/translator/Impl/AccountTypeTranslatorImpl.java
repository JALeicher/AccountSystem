package za.ac.nwu.ac.translator.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

public class AccountTypeTranslatorImpl implements AccountTypeTranslator {

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }
}
