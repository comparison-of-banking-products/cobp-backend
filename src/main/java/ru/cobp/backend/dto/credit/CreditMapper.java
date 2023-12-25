package ru.cobp.backend.dto.credit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.bank.BankMapper;
import ru.cobp.backend.exception.UnsupportedPaymentTypeException;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.credit.PaymentType;
import ru.cobp.backend.model.currency.Currency;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreditMapper {

    public static CreditShortResponseDto toDto(Credit o) {
        CreditShortResponseDto dto = new CreditShortResponseDto();

        dto.setBank(BankMapper.toShortDto(o.getBank()));
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
                .paymentType((credit.getPaymentType().getTitle()))
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
        return new Credit(null, bank, newCreditDto.getName(), newCreditDto.getProductUrl(),
                newCreditDto.getIsActive(), currency, newCreditDto.getMinAmount(), newCreditDto.getMaxAmount(),
                newCreditDto.getTerm(), newCreditDto.getRate(), toPaymentType(newCreditDto.getPaymentType()));
    }

    public static PaymentType toPaymentType(String paymentType) {
        switch (paymentType) {
            case "Аннуитетный":
                return PaymentType.ANNUITY;
            case "Дифференцированный":
                return PaymentType.DIFFERENTIAL;
            default:
                throw new UnsupportedPaymentTypeException("Incorrect payment type");
        }
    }

    public static void updateCredit(Credit credit, CreditDto creditDto) {
        if (creditDto.getIsActive() != null) {
            credit.setIsActive(creditDto.getIsActive());
        }
        if (creditDto.getName() != null) {
            credit.setName(creditDto.getName());
        }
        if (creditDto.getProductUrl() != null) {
            credit.setProductUrl(creditDto.getProductUrl());
        }
        if (creditDto.getRate() != null) {
            credit.setRate(creditDto.getRate());
        }
        if (creditDto.getMinAmount() != null) {
            credit.setAmountMin(creditDto.getMinAmount());
        }
        if (creditDto.getMaxAmount() != null) {
            credit.setAmountMax(credit.getAmountMax());
        }
        if (creditDto.getTerm() != null) {
            credit.setTerm(creditDto.getTerm());
        }
    }

}
