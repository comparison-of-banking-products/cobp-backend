package ru.cobp.backend.deposit.dto;

public class DepositDto {

    private String name;

    public DepositDto() {
    }

    public DepositDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
