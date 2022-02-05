package com.thecodeveal.app.util;

import com.thecodeveal.app.dtos.CardDto;
import com.thecodeveal.app.entities.Card;

public class EntityToModelUtil {
    public static CardDto toDto (Card card){
        return CardDto.builder()
                .id(card.getId())
                .enabled(card.isEnabled())
                .imageSKU(card.getImageSKU())
                .cardSuit(card.getSuit())
                .name(card.getName())
                .number(card.getNumber())
                .createdAt(card.getCreatedAt())
                .updatedAt(card.getUpdatedAt())
                .cardType(card.getCardType())
                .build();
    }
}
