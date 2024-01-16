package ru.cobp.backend.model.deposit;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DepositList {

    private List<Deposit> deposits;

    private Long totalElements;

}
