package ru.cobp.backend.model.credit;

import lombok.Getter;

@Getter
public enum PaymentType {

    ANNUITY("Аннуитетный"),
    DIFFERENTIAL("Дифференцированный");

    private final String title;

    PaymentType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return getTitle();
    }

}
