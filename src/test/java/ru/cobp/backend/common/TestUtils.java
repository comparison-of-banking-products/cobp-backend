package ru.cobp.backend.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.bank.BankResponseDto;
import ru.cobp.backend.dto.bank.BankShortResponseDto;
import ru.cobp.backend.dto.calculator.CalculatedCreditResponseDto;
import ru.cobp.backend.dto.calculator.CalculatedDepositResponseDto;
import ru.cobp.backend.dto.credit.CreditDto;
import ru.cobp.backend.dto.credit.CreditResponseDto;
import ru.cobp.backend.dto.credit.CreditShortResponseDto;
import ru.cobp.backend.dto.credit.NewCreditDto;
import ru.cobp.backend.dto.currency.CurrencyResponseDto;
import ru.cobp.backend.dto.deposit.DepositShortResponseDto;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.calculator.CalculatedCredit;
import ru.cobp.backend.model.calculator.CalculatedDeposit;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.credit.PaymentType;
import ru.cobp.backend.model.currency.Currency;
import ru.cobp.backend.model.currency.CurrencyRate;
import ru.cobp.backend.model.deposit.Deposit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtils {

    public static Deposit buildGazprombankDeposit() {
        return new Deposit(
                1L,
                buildGazprombank(),
                "Газпромбанк Вклад \"Копить\", для всех",
                "https://www.gazprombank.ru/personal/increase/deposits/detail/2491/",
                true,
                buildRubCurrency(),
                15000,
                100000000,
                1,
                13.80,
                false,
                false,
                false
        );
    }

    public static DepositShortResponseDto buildGazprombankDepositShortResponseDto() {
        return new DepositShortResponseDto(
                buildGazprombankShortResponseDto(),
                "Газпромбанк Вклад \"Копить\", для всех",
                "https://www.gazprombank.ru/personal/increase/deposits/detail/2491/",
                1,
                13.80,
                false,
                false,
                false
        );
    }

    public static List<CalculatedDeposit> buildGazprombankCalculatedDeposits() {
        return List.of(buildGazprombankCalculatedDeposit());
    }

    public static CalculatedDeposit buildGazprombankCalculatedDeposit() {
        return new CalculatedDeposit(
                buildGazprombankDeposit(),
                13800.0,
                1149.9999999999998,
                101150.0
        );
    }

    public static List<CalculatedDepositResponseDto> buildGazprombankCalculatedDepositResponseDtos() {
        return List.of(buildCalculatedDepositResponseDto());
    }

    public static CalculatedDepositResponseDto buildCalculatedDepositResponseDto() {
        return new CalculatedDepositResponseDto(
                buildGazprombankDepositShortResponseDto(),
                13800.0,
                1149.9999999999998,
                101150.0
        );
    }

    public static Credit buildGazprombankCredit() {
        return new Credit(
                1L,
                buildGazprombank(),
                "Газпромбанк Кредит наличными",
                "https://www.gazprombank.ru/personal/take_credit/consumer_credit/5004451/",
                true,
                buildRubCurrency(),
                10000,
                7000000,
                13,
                24.40,
                PaymentType.ANNUITY
        );
    }

    public static CreditShortResponseDto buildGazprombankCreditShortResponseDto() {
        return new CreditShortResponseDto(
                buildGazprombankShortResponseDto(),
                "Газпромбанк Кредит наличными",
                "https://www.gazprombank.ru/personal/take_credit/consumer_credit/5004451/",
                13,
                24.40
        );
    }

    public static List<CalculatedCredit> buildGazprombankCalculatedCredits() {
        return List.of(buildGazprombankCalculatedCredit());
    }

    public static CalculatedCredit buildGazprombankCalculatedCredit() {
        return new CalculatedCredit(
                buildGazprombankCredit(),
                8831.207127687578,
                114805.6926599385,
                14805.692659938504
        );
    }

    public static List<CalculatedCreditResponseDto> buildGazprombankCalculatedCreditResponseDtos() {
        return List.of(buildGazprombankCalculatedCreditResponseDto());
    }

    public static CalculatedCreditResponseDto buildGazprombankCalculatedCreditResponseDto() {
        return new CalculatedCreditResponseDto(
                buildGazprombankCreditShortResponseDto(),
                8831.207127687578,
                114805.6926599385,
                14805.692659938504
        );
    }

    public static Bank buildGazprombank() {
        return new Bank(
                "044525823",
                "Газпромбанк",
                "АО \"Газпромбанк\"",
                "Один из крупнейших универсальных финансовых институтов России",
                "gazprombank-logo.svg",
                "https://www.gazprombank.ru"
        );
    }

    public static BankShortResponseDto buildGazprombankShortResponseDto() {
        return new BankShortResponseDto(
                "Газпромбанк", "gazprombank-logo.svg"
        );
    }

    public static Currency buildRubCurrency() {
        return new Currency(643L, "RUB", "Российский рубль");
    }

    public static List<Bank> buildBanks() {
        return List.of(buildGazprombank());
    }

    public static List<Credit> buildCredits() {
        return List.of(buildGazprombankCredit());
    }

    public static List<Currency> buildCurrencies() {
        return List.of(buildRubCurrency());
    }

    public static CurrencyRate buildUsdRubCurrencyRate() {
        return new CurrencyRate(
                1L,
                LocalDateTime.parse("2024-01-10T11:30:00.000"),
                buildUsdCurrency(),
                buildRubCurrency(),
                90.4040,
                89.6883,
                LocalDateTime.parse("2023-12-30T11:30:00.000"),
                90.4040 - 89.6883
        );
    }

    public static Currency buildUsdCurrency() {
        return new Currency(840L, "USD", "Доллар США");
    }

    public static List<CurrencyRate> buildCurrencyRates() {
        return List.of(buildUsdRubCurrencyRate());
    }

    public static List<Deposit> buildDeposits() {
        return List.of(buildGazprombankDeposit());
    }

    public static NewCreditDto buildNewGazprombankCreditDto() {
        return new NewCreditDto(
                "044525823",
                "Газпромбанк Кредит наличными",
                Boolean.TRUE,
                643L,
                "https://www.gazprombank.ru/personal/take_credit/consumer_credit/5004451/",
                10000,
                7000000,
                24.4,
                13,
                "Аннуитетный"
        );
    }

    public static CreditDto buildGazprombankCreditDto() {
        return new CreditDto(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                25.1,
                12,
                null
        );
    }

    public static Credit buildGazprombankUpdatedCredit() {
        return new Credit(
                1L,
                buildGazprombank(),
                "Газпромбанк Кредит наличными",
                "https://www.gazprombank.ru/personal/take_credit/consumer_credit/5004451/",
                true,
                buildRubCurrency(),
                10000,
                7000000,
                12,
                25.1,
                PaymentType.ANNUITY
        );
    }

    public static CreditResponseDto toCreditResponseDto(Credit credit) {
        return new CreditResponseDto(
                credit.getId(),
                buildGazprombankResponseDto(),
                credit.getName(),
                credit.getProductUrl(),
                credit.getIsActive(),
                new CurrencyResponseDto(credit.getCurrency().getNum(), credit.getCurrency().getCurrency(),
                        credit.getCurrency().getCode()),
                credit.getAmountMin(),
                credit.getAmountMax(),
                credit.getTerm(),
                credit.getRate(),
                credit.getPaymentType().getTitle()
        );
    }

    public static List<CreditResponseDto> buildCreditResponseDtos() {
        List<CreditResponseDto> creditResponseDtoList = new ArrayList<>();
        creditResponseDtoList.add(toCreditResponseDto(buildGazprombankCredit()));
        return creditResponseDtoList;
    }

    private static BankResponseDto buildGazprombankResponseDto() {
        return new BankResponseDto(
                "044525823",
                "Газпромбанк",
                "АО \"Газпромбанк\"",
                "Один из крупнейших универсальных финансовых институтов России",
                "gazprombank-logo.svg",
                "https://www.gazprombank.ru"
        );
    }

}
