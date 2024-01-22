package ru.cobp.backend.dto.currency;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyCreateUpdateDto {

    @NotNull
    private Long num;

    @NotNull
    @Size(min = 3, max = 3)
    private String code;

    @NotNull
    @Size(max = 30)
    private String currency;
}
