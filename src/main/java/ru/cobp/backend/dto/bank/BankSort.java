package ru.cobp.backend.dto.bank;

public enum BankSort {
    CREDITS("Параметр фильтрации банков с кредитами"),
    DEPOSITS("Параметр фильтрации банков с вкладами");

    public final String label;

    BankSort(String label) {
        this.label = label;
    }
}
