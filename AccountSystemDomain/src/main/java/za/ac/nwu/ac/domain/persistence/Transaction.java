package za.ac.nwu.ac.domain.persistence;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity(name = "Transactions")
@Table(name = "Transactions")
public class Transaction implements Serializable{

    @Id
    @SequenceGenerator(name="Generic_Sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Generic_Sequence")
    @Column(name = "Transaction_Id")
    private Long transactionId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Transaction_Account",nullable = false)
    private Account account;

    @Column(name="Transaction_Type")
    private String transType;

    @Column(name = "Transaction_Date", nullable = true)
    private LocalDate transDate;

    @Column(name="Transaction_Amount")
    private Integer transAmount;

    public Transaction() {
    }

    public Transaction(Account account, String transType, LocalDate transDate, Integer transAmount) {
        this.account = account;
        this.transType = transType;
        this.transDate = transDate;
        this.transAmount = transAmount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", account=" + account +
                ", transType='" + transType + '\'' +
                ", transDate='" + transDate + '\'' +
                ", transAmount=" + transAmount +
                '}';
    }
}
