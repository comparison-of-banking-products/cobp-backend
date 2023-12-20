package ru.cobp.backend.dto.credit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.bank.BankMapper;
import ru.cobp.backend.exception.IncorrectPaymentTypeException;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.credit.PaymentTypeConverter;
import ru.cobp.backend.model.currency.Currency;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreditMapper {

    public static final PaymentTypeConverter paymentTypeConverter = new PaymentTypeConverter();

    public static CreditShortResponseDto toDto(Credit o) {
        CreditShortResponseDto dto = new CreditShortResponseDto();

        dto.setBank(BankMapper.toBankShortResponseDto(o.getBank()));
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
                .currencyNum(credit.getCurrency().getNum())
                .productUrl(credit.getProductUrl())
                .minAmount(credit.getAmountMin())
                .maxAmount(credit.getAmountMax())
                .rate(credit.getRate())
                .term(credit.getTerm())
                .paymentType(credit.getPaymentType().getPaymentType())
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
        try {
            return new Credit(bank, newCreditDto.getName(), newCreditDto.getProductUrl(), newCreditDto.getIsActive(),
                    currency, newCreditDto.getMinAmount(), newCreditDto.getMaxAmount(), newCreditDto.getTerm(),
                    newCreditDto.getRate(), paymentTypeConverter.convertToEntityAttribute(newCreditDto.getPaymentType()));
        } catch (IllegalArgumentException e) {
            throw new IncorrectPaymentTypeException("Incorrect payment type: " + newCreditDto.getPaymentType());
        }
    }
}
