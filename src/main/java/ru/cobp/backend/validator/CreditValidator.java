package ru.cobp.backend.validator;


import org.springframework.stereotype.Component;
import ru.cobp.backend.dto.credit.CreditParams;
import ru.cobp.backend.dto.credit.CreditUpdateDto;
import ru.cobp.backend.exception.ValidationException;

import java.util.List;

@Component
public class CreditValidator {

    public boolean validateCreditParams(CreditParams params) {
        return ((validateCurrencyNum(params.getCurrencyNum())) && (validateAmountMin(params.getAmountMin())) &&
                (validateAmountMax(params.getAmountMax(), params.getAmountMin())) && (validateRate(params.getRate())) &&
                (validateMinPeriod(params.getMinPeriod())) && (validateMaxPeriod(params.getMaxPeriod(),
                params.getMinPeriod())) && (validateBanksBic(params.getBanksBic())));
    }

    public boolean validateCreditUpdateDto(CreditUpdateDto creditUpdateDto) {
        return ((validateName(creditUpdateDto.getName())) && (validateProductUrl(creditUpdateDto.getProductUrl())) &&
                (validateAmountMin(creditUpdateDto.getAmountMin())) &&
                (validateAmountMax(creditUpdateDto.getAmountMax(), creditUpdateDto.getAmountMin())) &&
                (validateRate(creditUpdateDto.getRate())) && (validateTerm(creditUpdateDto.getTerm())));
    }

    private boolean validateCurrencyNum(Long currencyNum) {
        if (currencyNum != null) {
            if ((currencyNum > 0) && (currencyNum < 1000)) {
                return true;
            }
            throw new ValidationException("Код валюты должен быть в переделах от 1 до 999");
        }
        return true;
    }

    private boolean validateAmountMin(Integer amountMin) {
        if (amountMin != null) {
            if ((amountMin >= 10000) && (amountMin <= 100000000)) {
                return true;
            }
            throw new ValidationException("Минимальная сумма кредита должна быть в пределах от 10000 до 100000000");
        }
        return true;
    }

    private boolean validateAmountMax(Integer amountMax, Integer amountMin) {
        if (amountMax != null) {
            if ((amountMax >= 10000) && (amountMax <= 100000000)) {
                if (amountMin != null) {
                    if (amountMax > amountMin) {
                        return true;
                    }
                    throw new ValidationException("Максимальная сумма кредита должна быть больше минимальной");
                }
                return true;
            }
            throw new ValidationException("Максимальная сумма кредита должна быть в пределах от 10000 до 100000000");
        }
        return true;
    }


    private boolean validateRate(Double rate) {
        if (rate != null) {
            if (rate > 0) {
                return true;
            }
            throw new ValidationException("Кредитная ставка не может быть меньше 0");
        }
        return true;
    }

    private boolean validateMinPeriod(Integer minPeriod) {
        if (minPeriod != null) {
            if ((minPeriod >= 3) && (minPeriod <= 120)) {
                return true;
            }
            throw new ValidationException("Минимальный период кредита должен быть от 3 до 120 месяцев");
        }
        return true;
    }

    private boolean validateMaxPeriod(Integer maxPeriod, Integer minPeriod) {
        if (maxPeriod != null) {
            if ((maxPeriod >= 3) && (maxPeriod <= 120)) {
                if (minPeriod != null) {
                    if (maxPeriod >= minPeriod) {
                        return true;
                    }
                    throw new ValidationException("Максимальный период не может быть меньше минимального");
                }
            }
            throw new ValidationException("Максимальный период кредита должен быть от 3 до 120 месяцев");
        }
        return true;
    }

    private boolean validateName(String name) {
        if (name != null) {
            if ((name.length() > 3) && (name.length() < 100)) {
                if (name.matches("[а-яА-Я\", -]+")) {
                    return true;
                }
                throw new ValidationException("Название кредита должно содержать только символы русского языка, " +
                        "кавычки, дефис");
            }
            throw new ValidationException("Название кредита должно содержать от 3 до 100 символов");
        }
        return true;
    }

    private boolean validateProductUrl(String productUrl) {
        if (productUrl != null) {
            if ((productUrl.length() > 10) && (productUrl.length() < 250)) {
                if (productUrl.matches("^(https:\\/\\/)?(([A-Z0-9][A-Z0-9_-]*)(\\.[A-Z0-9][A-Z0-9_-]*)+)")) {
                    return true;
                }
                throw new ValidationException("Некорректный URL-адрес продукта");
            }
            throw new ValidationException("URL адресс продукта должен иметь от 3 до 100 символов");
        }
        return true;
    }


    private boolean validateTerm(Integer term) {
        if (term != null) {
            if ((term > 3) && (term < 120)) {
                return true;
            }
            throw new ValidationException("Срок кредита должен быть в пределах от 3 до 120 месяцев");
        }
        return true;
    }

    private boolean validateBanksBic(List<String> banksBic) {
        if (banksBic.isEmpty()) {
            for (String bic : banksBic) {
                if (!bic.matches("^04\\d{7}$")) {
                    throw new ValidationException("БИК должен состоять из 9 цифр");
                }
            }
            return true;
        }
        return true;
    }

}
