package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Account;
import za.ac.nwu.ac.domain.persistence.Transaction;

import java.time.LocalDate;


@ApiModel(value = "Transaction",
        description = "Data Transfer Object for Currency entity")
public class TransactionDto {

    private String account;
    private String transType;
    private String transDate;
    private Integer transAmount;

    public TransactionDto(Transaction transaction) {
        this.setAccount(transaction.getAccount().getAccountEMail());
        this.setTransType(transaction.getTransType());
        this.setTransDate(transaction.getTransDate().toString());
        this.setTransAmount(transaction.getTransAmount());
    }

    public TransactionDto(String account, String transType, String transDate,Integer transAmount) {
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
            example = "john.doe@gmaill.com",
            required = true)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
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
    public Integer getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(Integer transAmount) {
        this.transAmount = transAmount;
    }

    @JsonIgnore
    public Transaction BuildTransaction(Account account){
        try {
            Transaction trans = new Transaction(account,this.getTransType(),LocalDate.parse(this.getTransDate()),this.getTransAmount());
            System.out.println("Built TransAction: "+trans.toString());
            return trans ;
        }
        catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "account=" + account +
                ", transType='" + transType + '\'' +
                ", transDate='" + transDate + '\'' +
                ", transAmount=" + transAmount +
                '}';
    }
}
