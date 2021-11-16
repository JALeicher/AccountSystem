package za.ac.nwu.ac.logic.flow.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.CurrencyDto;
import za.ac.nwu.ac.logic.flow.CreateCurrencyFlow;
import za.ac.nwu.ac.translator.CurrencyTranslator;

@Component
public class CreateCurrencyFlowImpl implements CreateCurrencyFlow{

    private final CurrencyTranslator currencyTranslator;

    @Autowired
    public CreateCurrencyFlowImpl(CurrencyTranslator currencyTranslator) {
        this.currencyTranslator = currencyTranslator;
    }

    @Override
    public CurrencyDto CreateCurrency(CurrencyDto currencyDto) {
        return this.currencyTranslator.CreateCurrency(currencyDto);
    }
}
