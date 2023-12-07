package ru.cobp.backend.credit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.cobp.backend.bank.entity.Bank;
import ru.cobp.backend.currency.entity.Currency;

@Entity
@Table(name = "credits")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "banks_bic", referencedColumnName = "bic")
    private Bank bank;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "currencies_num", referencedColumnName = "num")
    private Currency currency;

    @Column(name = "product_url", nullable = false, length = 100)
    private String productUrl;

    @Column(name = "min_amount", nullable = false)
    private Integer minAmount;

    @Column(name = "max_amount", nullable = false)
    private Integer maxAmount;

    @Column(name = "min_rate", nullable = false)
    private Float minRate;

    @Column(name = "min_period", nullable = false)
    private Integer minPeriod;

    @Column(name = "max_period", nullable = false)
    private Integer maxPeriod;

    @ManyToOne
    @JoinColumn(name = "payment_type_id", nullable = false)
    private PaymentType paymentType;

    @Column(name = "deposit_is_required", nullable = false)
    private Boolean depositIsRequired;

    @Column(name = "online_approve", nullable = false)
    private Boolean onlineApprove;

    @Column(name = "online_getting", nullable = false)
    private Boolean onlineGetting;

    @Column(name = "insurance", nullable = false)
    private Boolean insurance;

}
