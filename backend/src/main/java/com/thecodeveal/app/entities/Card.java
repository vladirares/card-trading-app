package com.thecodeveal.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thecodeveal.app.enums.CardSuit;
import com.thecodeveal.app.enums.CardType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "CARDS")
public class Card {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CARD_NAME")
    private String name;

    @Column(name = "CARD_TYPE")
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Column(name = "CREATED_ON")
    private Date createdAt;

    @Column(name = "UPDATED_ON")
    private Date updatedAt;

    @Column(name = "CARD_SUIT")
    private CardSuit suit;

    @Column(name = "CARD_NUMBER")
    private Integer number;

    @Column(name = "IMAGE_SKU")
    private String imageSKU;

    @Column(name = "enabled")
    private boolean enabled = true;

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "cards")
    private List<User> users;

    Card(){

    }

}
