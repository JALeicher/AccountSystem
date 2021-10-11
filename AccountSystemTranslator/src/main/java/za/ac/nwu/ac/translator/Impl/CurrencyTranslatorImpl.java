package za.ac.nwu.ac.translator.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.CurrencyDto;
import za.ac.nwu.ac.domain.persistence.Currency;
import za.ac.nwu.ac.repo.persistence.CurrencyRepo;
import za.ac.nwu.ac.translator.CurrencyTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class CurrencyTranslatorImpl implements CurrencyTranslator {

    Logger logger = LoggerFactory.getLogger(CurrencyTranslator.class);

    private CurrencyRepo currencyRepo;

    @Autowired
    public CurrencyTranslatorImpl(CurrencyRepo currencyRepo) {
        this.currencyRepo = currencyRepo;
    }

    @Override
    public List<CurrencyDto> GetAllCurrencies() {
        List<CurrencyDto> currencyDtoList = new ArrayList<>();
        for (Currency i: this.currencyRepo.findAll()) {
            currencyDtoList.add(new CurrencyDto(i));
        }
        return currencyDtoList;
    }

    @Override
    public CurrencyDto CreateCurrency(CurrencyDto currencyDto) {
        try {
            Currency currency = currencyRepo.save(currencyDto.getCurrency());
            return new CurrencyDto(currency);
        }catch (Exception e){
            logger.error("Failed to create new currency");
            throw new RuntimeException(e);
        }
    }

    @Override
    public CurrencyDto FetchCurrencyBySymbol(String symbol) {
        try {
            CurrencyDto currencyDto = new CurrencyDto(this.currencyRepo.fetchCurrencyBySymbol(symbol));
            return currencyDto;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
