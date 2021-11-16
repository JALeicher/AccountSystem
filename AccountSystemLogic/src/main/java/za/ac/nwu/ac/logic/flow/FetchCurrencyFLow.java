package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.CurrencyDto;

import java.util.Currency;
import java.util.List;

public interface FetchCurrencyFLow {
    List<CurrencyDto> GetAllCurrencies();
    CurrencyDto FetchCurrencyBySymbol(String symbol);
}
