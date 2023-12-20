package ru.cobp.backend.model.credit;

public enum PaymentType {

    ANNUITY("Аннуитетный"),

    DIFFERENTIATED("Дифференцированный");

    private final String paymentType;

    PaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentType() {
        return paymentType;
    }

}
