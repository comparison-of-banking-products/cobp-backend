package ru.cobp.backend.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.bank.BankShortResponseDto;
import ru.cobp.backend.dto.calculator.CalculatedCreditResponseDto;
import ru.cobp.backend.dto.calculator.CalculatedDepositResponseDto;
import ru.cobp.backend.dto.credit.CreditShortResponseDto;
import ru.cobp.backend.dto.deposit.DepositShortResponseDto;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.calculator.CalculatedCredit;
import ru.cobp.backend.model.calculator.CalculatedDeposit;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.credit.PaymentType;
import ru.cobp.backend.model.currency.Currency;
import ru.cobp.backend.model.deposit.Deposit;

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
                13.80
        );
    }

    public static List<CalculatedDeposit> buildGazprombankCalculatedDeposits() {
        return List.of(new CalculatedDeposit(
                buildGazprombankDeposit(), 2070.0, 172.5, 15172.5
        ));
    }

    public static List<CalculatedDepositResponseDto> buildGazprombankCalculatedDepositResponseDtos() {
        return List.of(new CalculatedDepositResponseDto(
                buildGazprombankDepositShortResponseDto(), 2070.0, 172.5, 15172.5
        ));
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
        return List.of(new CalculatedCredit(
                buildGazprombankCredit(),
                883.12,
                11480.57,
                1480.57
        ));
    }

    public static List<CalculatedCreditResponseDto> buildGazprombankCalculatedCreditResponseDtos() {
        return List.of(new CalculatedCreditResponseDto(
                buildGazprombankCreditShortResponseDto(),
                883.12,
                11480.57,
                1480.57
        ));
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

    public static List<Deposit> buildGazprombankDeposits() {
        return List.of(buildGazprombankDeposit());
    }

}
