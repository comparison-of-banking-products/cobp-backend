package ru.cobp.backend.bank.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankDto {
    @NotNull
    private Integer bic;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 100)
    private String legalEntity;

    @NotNull
    private String description;

    @NotNull
    @Size(max = 100)
    private String logo;

    @NotNull
    @Size(max = 100)
    private String url;

}


