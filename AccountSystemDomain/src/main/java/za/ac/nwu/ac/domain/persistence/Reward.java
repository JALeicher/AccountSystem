package za.ac.nwu.ac.domain.persistence;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity(name = "Rewards")
@Table(name = "Rewards")
public class Reward implements Serializable{

    @Id
    @SequenceGenerator(name="Generic_Sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Generic_Sequence")
    @Column(name = "Reward_Id")
    private Long rewardId;

    @Column(name = "Reward_Name")
    private String rewardName;

    @Column(name = "Reward_Provider")
    private  String rewardProvider;

    @Column(name = "Reward_Description")
    private String rewardDescription;

    @Column(name = "Reward_Cost")
    private Float rewardValue;

    public Reward() {
    }

    public Reward(String rewardName, String rewardProvider, String rewardDescription, Float rewardValue) {
        this.rewardName = rewardName;
        this.rewardProvider = rewardProvider;
        this.rewardDescription = rewardDescription;
        this.rewardValue = rewardValue;
    }
}
