package ru.cobp.backend.model.credit;

public enum PaymentType {

    ANNUITY("Аннуитетный"),

    DIFFERENTIAL("Дифференцированный");

    private String title;

    PaymentType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return getTitle();
    }

}
