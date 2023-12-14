package ru.cobp.backend.dto.bank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewBankDto {

    @NotNull
    private Long bic;

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
