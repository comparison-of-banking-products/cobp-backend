package ru.cobp.backend.model.currency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "currencies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Currency {

    @Id
    @Column(name = "num", nullable = false)
    private String num;

    @Column(name = "code", length = 3, nullable = false, unique = true)
    private String code;

    @Column(name = "currency", length = 30, nullable = false, unique = true)
    private String currency;

}
