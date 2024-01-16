package ru.cobp.backend.model.credit;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CreditList {

    private List<Credit> credits;

    private Long totalElements;

}
