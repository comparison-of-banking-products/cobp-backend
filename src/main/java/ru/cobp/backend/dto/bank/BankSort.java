package ru.cobp.backend.dto.bank;

public enum BankSort {
    CREDITS("Параметр сортировки банков с кредитами"),
    DEPOSITS("Параметр сортировки банков с вкладами");

    public final String label;

    BankSort(String label) {
        this.label = label;
    }
}
