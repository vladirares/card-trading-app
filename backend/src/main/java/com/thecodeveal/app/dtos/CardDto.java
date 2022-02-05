package com.thecodeveal.app.dtos;

import com.thecodeveal.app.enums.CardSuit;
import com.thecodeveal.app.enums.CardType;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CardDto {

    private long id;
    private String name;
    private CardType cardType;
    private CardSuit cardSuit;
    private Integer number;
    private Date createdAt;
    private Date updatedAt;
    private String imageSKU;
    private boolean enabled;

}
