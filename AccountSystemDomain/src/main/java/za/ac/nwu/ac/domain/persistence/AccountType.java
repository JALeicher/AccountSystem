package za.ac.nwu.ac.domain.persistence;


import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="DemoType")
public class AccountType implements Serializable {
    @Id
    @SequenceGenerator(name="Generic_Sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Generic_Sequence")
    @Column(name = "accountType_Id")
    private Long accountTypeId;

    @Column(name = "mnemonic")
    private String mnemonic;

    @Column(name = "accountType_Name")
    private String accountTypeName;

    @Column(name = "Creation_Date")
    private LocalDate CreationDate;

    public AccountType() {
    }

    public AccountType(String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        CreationDate = creationDate;
    }
}
