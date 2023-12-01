package com.the_last_castle.backend.Entity;

import java.util.*;

import org.apache.catalina.User;

import jakarta.persistence.*;

@Entity
@Table(name = "Use_credit_card")
public class TarjetaDeCredito {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "idcredit_card", unique = true, nullable = false, columnDefinition = "BINARY(16)")
    private UUID idCreditCard;

    @ManyToOne
    @JoinColumn(name = "user_id_user", nullable = false)
    private User user;

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
