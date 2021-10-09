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
    @Column(name = "accountType_Id")
    private Long accountId;

    @Column(name = "Account_First_Name")
    private String accountFName;

    @Column(name = "Account_Last_Name")
    private String accountLName;

    @Column(name = "Account_Email")
    private String accountEMail;

    @ManyToOne
    @JoinColumn(name = "Account_currency")
    private Currency accountCurrency;

    public Account(String accountFName, String accountLName, String accountEMail, Currency accountCurrency) {
        this.accountFName = accountFName;
        this.accountLName = accountLName;
        this.accountEMail = accountEMail;
        this.accountCurrency = accountCurrency;
    }
}
