package za.ac.nwu.ac.domain.dto;

import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;


public class AccountTypeDto implements Serializable {

    private String accountTypeName;
    private String mnemonic;
    private LocalDate creationDate;

    public AccountTypeDto() {
    }

    public AccountTypeDto(AccountType accountType) {
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setMnemonic(accountType.getMnemonic());
        this.setCreationDate(accountType.getCreationDate());
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "accountTypeName='" + accountTypeName + '\'' +
                ", mnemonic='" + mnemonic + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
