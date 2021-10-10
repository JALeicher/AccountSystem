package za.ac.nwu.ac.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Reward;

public class RewardDto {
    private String rewardName;
    private  String rewardProvider;
    private String rewardDescription;
    private Float rewardValue;

    public RewardDto( String rewardName, String rewardProvider, String rewardDescription, Float rewardValue) {

        this.rewardName = rewardName;
        this.rewardProvider = rewardProvider;
        this.rewardDescription = rewardDescription;
        this.rewardValue = rewardValue;
    }

    public RewardDto(Reward reward) {
        this.setRewardName(reward.getRewardName());
        this.setRewardProvider(reward.getRewardProvider());
        this.setRewardDescription(reward.getRewardDescription());
        this.setRewardValue(reward.getRewardValue());
    }

    @ApiModelProperty(position = 1,
            value = "Reward_Name",
            name="Reward Name",
            notes = "",
            dataType = "java.lang.String",
            example = "PlayStation50",
            required = true)
    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    @ApiModelProperty(position = 2,
            value = "Reward_Provider",
            name="Reward Provider",
            notes = "",
            dataType = "java.lang.String",
            example = "Sony",
            required = true)
    public String getRewardProvider() {
        return rewardProvider;
    }

    public void setRewardProvider(String rewardProvider) {
        this.rewardProvider = rewardProvider;
    }

    @ApiModelProperty(position = 3,
            value = "Reward_Name",
            name="Reward Name",
            notes = "",
            dataType = "java.lang.String",
            example = "R50 to spend on spend on playstation bundles",
            required = true)
    public String getRewardDescription() {
        return rewardDescription;
    }

    public void setRewardDescription(String rewardDescription) {
        this.rewardDescription = rewardDescription;
    }

    @ApiModelProperty(position = 4,
            value = "Reward_Value",
            name="Reward Value",
            notes = "",
            dataType = "java.lang.Float",
            example = "500.00",
            required = true)
    public Float getRewardValue() {
        return rewardValue;
    }

    public void setRewardValue(Float rewardValue) {
        this.rewardValue = rewardValue;
    }

    @JsonIgnore
    public Reward getReward()
    {
        return new Reward(this.getRewardName(),this.getRewardProvider(),this.getRewardDescription(),this.getRewardValue());
    }
}
