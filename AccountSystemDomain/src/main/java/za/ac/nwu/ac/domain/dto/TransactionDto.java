package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Account;
import za.ac.nwu.ac.domain.persistence.Transaction;

import javax.persistence.Column;
import java.time.LocalDate;

public class TransactionDto {

    private Long account;
    private String transType;
    private String transDate;
    private Float transAmount;

    public TransactionDto() {
    }

    public TransactionDto(Long account, String transType, String transDate,Float transAmount) {
        this.account = account;
        this.transType = transType;
        this.transDate = transDate;
        this.transAmount = transAmount;
    }

    @ApiModelProperty(position = 1,
            value = "Account_Id",
            name="Account Id",
            notes = "",
            dataType = "java.lang.Long",
            example = "1",
            required = true)
    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    @ApiModelProperty(position = 2,
            value = "Transaction_Type",
            name="Transaction Type",
            notes = "",
            dataType = "java.lang.String",
            example = "ADD",
            required = true)
    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    @ApiModelProperty(position = 3,
            value = "Transaction_Date",
            name="Transaction Date",
            notes = "",
            dataType = "java.lang.String",
            example = "2020-01-01",
            required = true)
    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    @ApiModelProperty(position = 4,
            value = "Transaction_Amount",
            name="Transaction Amount",
            notes = "",
            dataType = "java.lang.Float",
            example = "500.00",
            required = true)
    public Float getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(Float transAmount) {
        this.transAmount = transAmount;
    }

    @JsonIgnore
    public Transaction BuildTransaction(Account account){
        return new Transaction(account,this.getTransType(),LocalDate.parse(this.getTransDate()),this.getTransAmount());
    }
}
