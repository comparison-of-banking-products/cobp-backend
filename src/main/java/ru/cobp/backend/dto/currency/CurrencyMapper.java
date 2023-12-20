package ru.cobp.backend.dto.currency;

import ru.cobp.backend.model.currency.Currency;

public class CurrencyMapper {

    public static CurrencyDto toCurrencyDto(Currency currency) {
        return new CurrencyDto(currency.getNum(), currency.getCode(), currency.getCurrency());
    }

}
