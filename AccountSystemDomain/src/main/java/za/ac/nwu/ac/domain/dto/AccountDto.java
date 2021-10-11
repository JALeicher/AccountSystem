package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Account;
import za.ac.nwu.ac.domain.persistence.Currency;

@ApiModel(value = "Account",
description = "Data Transfer Object for account entity")
public class AccountDto {

    private String accountFName;
    private String accountLName;
    private String accountEMail;
    private String accountCurrency;
    private Integer milesBalance;

    public AccountDto(String accountFName, String accountLName, String accountEMail, String accountCurrency, Integer milesBalance) {
        this.accountFName = accountFName;
        this.accountLName = accountLName;
        this.accountEMail = accountEMail;
        this.accountCurrency = accountCurrency;
        this.milesBalance = milesBalance;
    }

    public AccountDto(Account account) {
        this.setAccountFName(account.getAccountFName());
        this.setAccountLName(account.getAccountLName());
        this.setAccountEMail(account.getAccountEMail());
        this.setAccountCurrency(account.getAccountCurrency().getCurrencySymbol());
        this.setMilesBalance(account.getMilesBalance());
    }


    @ApiModelProperty(position = 1,
            value = "Account_First_Name",
            name="First Name",
            notes = "",
            dataType = "java.lang.String",
            example = "John",
            required = true)
    public String getAccountFName() {
        return accountFName;
    }

    public void setAccountFName(String accountFName) {
        this.accountFName = accountFName;
    }

    @ApiModelProperty(position = 2,
            value = "Account_Last_Name",
            name="Last Name",
            notes = "",
            dataType = "java.lang.String",
            example = "Doe",
            required = true)
    public String getAccountLName() {
        return accountLName;
    }

    public void setAccountLName(String accountLName) {
        this.accountLName = accountLName;
    }

    @ApiModelProperty(position = 3,
            value = "Account_EMail",
            name="E_Mail",
            notes = "",
            dataType = "java.lang.String",
            example = "john.doe@gmaill.com",
            required = true)
    public String getAccountEMail() {
        return accountEMail;
    }

    public void setAccountEMail(String accountEMail) {
        this.accountEMail = accountEMail;
    }

    @ApiModelProperty(position = 4,
            value = "Account_Currency",
            name="Currency",
            notes = "",
            dataType = "java.lang.String",
            example = "R",
            required = true)
    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    @JsonIgnore
    public Account BuildAccount(Currency currency){
        return new Account(this.getAccountFName(),this.getAccountLName(),this.getAccountEMail(), currency, this.getMilesBalance());
    }

    @ApiModelProperty(position = 5,
            value = "Miles_Balance",
            name="Balance",
            notes = "",
            dataType = "java.lang.Float",
            example = "550.00",
            required = true,
            allowEmptyValue = true)
    public Integer getMilesBalance() {
        return milesBalance;
    }

    public void setMilesBalance(Integer milesBalance) {
        this.milesBalance = milesBalance;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "accountFName='" + accountFName + '\'' +
                ", accountLName='" + accountLName + '\'' +
                ", accountEMail='" + accountEMail + '\'' +
                ", accountCurrency='" + accountCurrency + '\'' +
                ", milesBalance=" + milesBalance +
                '}';
    }
}
