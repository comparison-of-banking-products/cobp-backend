package ru.cobp.backend.currency.entity;
`` rthbn
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "currencies")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Currency {

    @Id
    @Column(name = "num", nullable = false)
    private Integer num;

    @Column(name = "code", length = 3, nullable = false, unique = true)
    private String code;

    @Column(name = "currency", length = 30, nullable = false, unique = true)
    private String currency;

}
