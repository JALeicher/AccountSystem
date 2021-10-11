package za.ac.nwu.ac.domain.persistence;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity(name = "Accounts")
@Table(name = "Accounts")
public class Account implements Serializable{

    @Id
    @SequenceGenerator(name="Generic_Sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Generic_Sequence")
    @Column(name = "account_Id")
    private Long accountId;

    @Column(name = "Account_First_Name")
    private String accountFName;

    @Column(name = "Account_Last_Name")
    private String accountLName;

    @Column(name = "Account_Email")
    private String accountEMail;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Account_currency",nullable = false)
    private Currency accountCurrency;

    @Column(name="Miles_Balance")
    private Integer milesBalance;

    public Account() {
    }

    public Account(String accountFName, String accountLName, String accountEMail, Currency accountCurrency, Integer milesBalance) {
        this.accountFName = accountFName;
        this.accountLName = accountLName;
        this.accountEMail = accountEMail;
        this.accountCurrency = accountCurrency;
        this.milesBalance = milesBalance;
    }
}
