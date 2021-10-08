package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountType;
import javax.persistence.*;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.time.LocalDate;

@ApiModel(value = "AccountType",
    description = "Data Transfer Object for AccountType Entity"
)
public class AccountTypeDto implements Serializable {

    private String accountTypeName;
    private String mnemonic;
    private LocalDate creationDate;

    public AccountTypeDto() {
    }

    public AccountTypeDto(AccountType accountType) {
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setCreationDate(accountType.getCreationDate());
        this.setMnemonic(accountType.getMnemonic());

    }

    @ApiModelProperty(position = 1,
            value = "Account Mnemonic",
            name="Mnemonic",
            notes = "",
            dataType = "java.lang.Static",
            example = "KM",
            allowEmptyValue = false,
            required = true)
    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @ApiModelProperty(position = 2,
            value = "AccountType Name",
            name="Name",
            notes = "",
            dataType = "java.lang.String",
            example = "kilometers",
            allowEmptyValue = false,
            required = true)
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @ApiModelProperty(position = 3,
            value = "AccountTye CreationDate",
            name="CreationDate",
            notes = "",
            dataType = "java.lang.String",
            example = "2020-01-01",
            allowEmptyValue = true,
            required = false)

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @JsonIgnore
    public AccountType getAccountType(){
        return new AccountType(getMnemonic(),getAccountTypeName(),getCreationDate());
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
