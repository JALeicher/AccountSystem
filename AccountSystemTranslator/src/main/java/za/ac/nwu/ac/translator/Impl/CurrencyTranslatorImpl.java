package za.ac.nwu.ac.translator.Impl;

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
        }catch (Exception E){
            throw new RuntimeException("Couldn't add currency");
        }
    }

    @Override
    public CurrencyDto FetchCurrencyBySymbol(String symbol) {
        try {
            CurrencyDto currencyDto = new CurrencyDto(this.currencyRepo.fetchCurrencyBySymbol(symbol));
            return currencyDto;
        }catch (Exception E){
            throw new RuntimeException("Couldn't retrieve currency");
        }
    }
}
