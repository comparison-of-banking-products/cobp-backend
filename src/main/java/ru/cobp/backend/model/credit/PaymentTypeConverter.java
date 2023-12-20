package ru.cobp.backend.model.credit;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class PaymentTypeConverter implements AttributeConverter<PaymentType, String> {

    @Override
    public String convertToDatabaseColumn(PaymentType paymentType) {
        if (paymentType == null) {
            return null;
        }
        return paymentType.getPaymentType();
    }

    @Override
    public PaymentType convertToEntityAttribute(String stringPaymentType) {
        if (stringPaymentType == null) {
            return null;
        }

        return Stream.of(PaymentType.values())
                .filter(c -> c.getPaymentType().equals(stringPaymentType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
