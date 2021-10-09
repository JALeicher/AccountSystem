package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.CurrencyDto;

import java.util.List;

public interface CurrencyTranslator {
    List<CurrencyDto> GetAllCurrencies();
    CurrencyDto CreateCurrency(CurrencyDto currencyDto);
    CurrencyDto FetchCurrencyBySymbol(String symbol);
}
