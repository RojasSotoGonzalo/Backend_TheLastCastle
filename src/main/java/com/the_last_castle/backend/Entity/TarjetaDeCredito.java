package com.the_last_castle.backend.Entity;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Use_credit_card")
public class TarjetaDeCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_credit_card", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID idCreditCard;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Corregido el nombre de la columna
    private UserEntity user;

    @Column(name = "card_code")
    private int cardCode;

    @Column(name = "expires")
    @Temporal(TemporalType.DATE)
    private Date expires;

    @Column(name = "card_title", length = 50)
    private String cardTitle;

    @Column(name = "card_issuer", length = 50)
    private String cardIssuer;

    @Column(name = "CVV")
    private int cvv;
}
