package com.thecodeveal.app.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardType {
    BRONZE(10),
    SILVER(20),
    GOLD(50);

    private final Integer value;
}
