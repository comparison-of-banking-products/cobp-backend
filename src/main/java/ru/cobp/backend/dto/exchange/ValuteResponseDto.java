package ru.cobp.backend.dto.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
public class ValuteResponseDto {

    @JsonProperty("ID")
    private String id;

    @JsonProperty("NumCode")
    private String numCode;

    @JsonProperty("CharCode")
    private String charCode;

    @JsonProperty("Nominal")
    private Integer nominal;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Value")
    private Double value;

    @JsonProperty("Previous")
    private Double previous;

}
