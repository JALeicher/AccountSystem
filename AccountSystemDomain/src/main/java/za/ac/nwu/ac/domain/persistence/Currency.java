package za.ac.nwu.ac.domain.persistence;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "Currencies")
@Table(name = "Currencies")
public class Currency implements Serializable{

    @Id
    @SequenceGenerator(name="Generic_Sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Generic_Sequence")
    @Column(name = "Currency_Id")
    private Long currencyId;

    @Column(name = "Currency_Name")
    private String currencyName;

    @Column(name = "Currency_Symbol")
    private String currencySymbol;

    @Column(name = "Exchange_Rate")
    private float exchangeRate;

    public Currency() {
    }

    public Currency(String currencyName, String currencySymbol, float exchangeRate) {
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
        this.exchangeRate = exchangeRate;
    }
}
