package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Goal;

import javax.persistence.Column;
import java.time.LocalDate;

public class GoalDto {

    private String goalName;
    private String goalDescription;
    private String goalMetric;
    private String goalStartDate;
    private Float goalValue;

    public GoalDto(String goalName, String goalDescription, String goalMetric, String goalStartDate, Float goalValue) {
        this.goalName = goalName;
        this.goalDescription = goalDescription;
        this.goalMetric = goalMetric;
        this.goalStartDate = goalStartDate;
        this.goalValue = goalValue;
    }

    public GoalDto(Goal goal) {
        this.setGoalName(goal.getGoalName());
        this.setGoalDescription(goal.getGoalDescription());
        this.setGoalMetric(goal.getGoalMetric());
        this.setGoalStartDate(goal.getGoalStartDate().toString());
        this.setGoalValue(goal.getGoalValue());
    }


    @ApiModelProperty(position = 1,
            value = "Goal_Name",
            name="Goal Name",
            notes = "",
            dataType = "java.lang.String",
            example = "StepGoal5000",
            required = true)
    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    @ApiModelProperty(position = 2,
            value = "Goal_Description",
            name="Goal Description",
            notes = "",
            dataType = "java.lang.String",
            example = "Reach 5000+ steps in a week",
            required = true)
    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    @ApiModelProperty(position = 3,
            value = "Goal_Metric",
            name="Goal Metric",
            notes = "",
            dataType = "java.lang.String",
            example = "Steps",
            required = true)
    public String getGoalMetric() {
        return goalMetric;
    }

    public void setGoalMetric(String goalMetric) {
        this.goalMetric = goalMetric;
    }

    @ApiModelProperty(position = 4,
            value = "Goal_Start_Date",
            name="Goal Start Date",
            notes = "",
            dataType = "java.lang.String",
            example = "2020-01-01",
            required = true)
    public String getGoalStartDate() {
        return goalStartDate;
    }

    public void setGoalStartDate(String goalStartDate) {
        this.goalStartDate = goalStartDate;
    }

    @ApiModelProperty(position = 5,
            value = "Goal_Value",
            name="Goal Value",
            notes = "",
            dataType = "java.lang.String",
            example = "5000",
            required = true)
    public Float getGoalValue() {
        return goalValue;
    }

    public void setGoalValue(Float goalValue) {
        this.goalValue = goalValue;
    }

    @JsonIgnore
    public Goal getGoal(){
        LocalDate startDate = LocalDate.parse(this.getGoalStartDate());
        return new Goal(this.getGoalName(),this.getGoalDescription(),this.getGoalMetric(),startDate,this.getGoalValue());
    }
}
