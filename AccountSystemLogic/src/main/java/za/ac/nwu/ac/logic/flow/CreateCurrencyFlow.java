package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.CurrencyDto;

public interface CreateCurrencyFlow {
    CurrencyDto CreateCurrency(CurrencyDto currencyDto);
}
