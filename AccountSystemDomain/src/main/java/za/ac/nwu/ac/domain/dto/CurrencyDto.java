package za.ac.nwu.ac.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Currency;

import java.io.Serializable;

@ApiModel(value = "Currency",
description = "Data Transfer Object for Currency entity")
public class CurrencyDto implements Serializable {

    private String currencyName;
    private String currencySymbol;
    private float exchangeRate;

    public CurrencyDto(String currencyName, String currencySymbol, float exchangeRate) {
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
        this.exchangeRate = exchangeRate;
    }

    public CurrencyDto(Currency currency) {
        this.setCurrencyName(currency.getCurrencyName());
        this.setCurrencySymbol(currency.getCurrencySymbol());
        this.setExchangeRate(currency.getExchangeRate());
    }

    @ApiModelProperty(position = 1,
            value = "Currency_Name",
            name="Currency Name",
            notes = "",
            dataType = "java.lang.String",
            example = "Rand",
            required = true)
    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @ApiModelProperty(position = 2,
            value = "Currency_Symbol",
            name="Currency Symbol",
            notes = "",
            dataType = "java.lang.String",
            example = "R",
            required = true)

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    @ApiModelProperty(position = 2,
            value = "Exchange_Rate",
            name="Exchange Rate",
            notes = "Rate at which it is exchanged for Discovery Miles",
            dataType = "java.lang.String",
            example = "1.00",
            required = true)

    public float getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(float exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @JsonIgnore
    public Currency getCurrency(){
        return new Currency(this.getCurrencyName(),this.getCurrencySymbol(),this.getExchangeRate());
    }

    @Override
    public String toString() {
        return "CurrencyDto{" +
                "currencyName='" + currencyName + '\'' +
                ", currencySymbol='" + currencySymbol + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}
