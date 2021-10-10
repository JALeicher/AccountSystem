package za.ac.nwu.ac.domain.persistence;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Setter
@Getter
@Entity(name = "Goals")
@Table(name = "Goals")
public class Goal implements Serializable{

    @Id
    @SequenceGenerator(name="Generic_Sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Generic_Sequence")
    @Column(name = "Goal_Id")
    private Long goalId;

    @Column(name = "Goal_Name")
    private String goalName;

    @Column(name = "Goal_Description")
    private String goalDescription;

    @Column(name = "Goal_Metric")
    private String goalMetric;

    @Column(name = "Goal_Start_Date")
    private LocalDate goalStartDate;

    @Column(name = "Goal_Value")
    private Float goalValue;

    public Goal() {
    }

    public Goal(String goalName, String goalDescription, String goalMetric, LocalDate goalStartDate, Float goalValue) {
        this.goalName = goalName;
        this.goalDescription = goalDescription;
        this.goalMetric = goalMetric;
        this.goalStartDate = goalStartDate;
        this.goalValue = goalValue;
    }
}
