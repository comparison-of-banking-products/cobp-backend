package ru.cobp.backend.dto.bank;

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
public class BankCreateUpdateDto {

    @NotNull
    private String bic;

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
