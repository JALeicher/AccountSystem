package za.ac.nwu.ac.logic.flow.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.CurrencyDto;
import za.ac.nwu.ac.logic.flow.FetchCurrencyFLow;
import za.ac.nwu.ac.translator.CurrencyTranslator;

import java.util.List;

@Component
public class FetchCurrencyFlowImpl implements FetchCurrencyFLow {
    private final CurrencyTranslator currencyTranslator;

    @Autowired
    public FetchCurrencyFlowImpl(CurrencyTranslator currencyTranslator) {
        this.currencyTranslator = currencyTranslator;
    }

    @Override
    public List<CurrencyDto> GetAllCurrencies() {
        return this.currencyTranslator.GetAllCurrencies();
    }

    @Override
    public CurrencyDto FetchCurrencyBySymbol(String symbol) {
        return this.currencyTranslator.FetchCurrencyBySymbol(symbol);
    }
}
