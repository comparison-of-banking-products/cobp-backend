package ru.cobp.backend.dto.credit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.bank.BankMapper;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.currency.Currency;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreditMapper {

    public static CreditShortResponseDto toDto(Credit o) {
        CreditShortResponseDto dto = new CreditShortResponseDto();

        dto.setBank(BankMapper.toDto(o.getBank()));
        dto.setCreditName(o.getName());
        dto.setCreditUrl(o.getProductUrl());
        dto.setTerm(o.getTerm());
        dto.setRate(o.getRate());

        return dto;
    }

    public static CreditDto toCreditDto(Credit credit) {
        return CreditDto.builder()
                .id(credit.getId())
                .banksBic(credit.getBank().getBic())
                .name(credit.getName())
                .isActive(credit.getIsActive())
                .currenciesNum(credit.getCurrency().getNum())
                .productUrl(credit.getProductUrl())
                .minAmount(credit.getAmountMin())
                .maxAmount(credit.getAmountMax())
                .rate(credit.getRate())
                .term(credit.getTerm())
                .build();
    }

    public static List<CreditDto> toCreditDtoList(List<Credit> credits) {
        List<CreditDto> creditDtoList = new ArrayList<>();
        if (!credits.isEmpty()) {
            for (Credit credit : credits) {
                creditDtoList.add(toCreditDto(credit));
            }
        }
        return creditDtoList;
    }

    public static Credit toCredit(NewCreditDto newCreditDto, Bank bank, Currency currency) {
        return Credit.builder()
                .bank(bank)
                .name(newCreditDto.getName())
                .productUrl(newCreditDto.getProductUrl())
                .isActive(newCreditDto.getIsActive())
                .currency(currency)
                .amountMin(newCreditDto.getMinAmount())
                .amountMax(newCreditDto.getMaxAmount())
                .term(newCreditDto.getTerm())
                .rate(newCreditDto.getRate())
                .build();
    }
}
