package ru.cobp.backend.model.credit;

import jakarta.persistence.*;
import lombok.*;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.currency.Currency;

@Entity
@Table(name = "credits")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bank_bic", nullable = false)
    private Bank bank;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "product_url", length = 250, nullable = false)
    private String productUrl;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "currency_num", nullable = false)
    private Currency currency;

    @Column(name = "amount_min", nullable = false)
    private Integer amountMin;

    @Column(name = "amount_max", nullable = false)
    private Integer amountMax;

    @Column(name = "term", nullable = false)
    private Integer term;

    @Column(name = "rate", nullable = false)
    private Double rate;

}
