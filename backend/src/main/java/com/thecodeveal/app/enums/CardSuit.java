package com.thecodeveal.app.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardSuit {
    SPADES("aa1dcf14-457d-43e8-9400-ce7b73688b35"),
    HEARTS("c4ef7b6c-cd03-4841-871a-a6778e66460c"),
    CLUBS("edac16a1-a0c5-4ad7-affe-784d4a3d71a6"),
    DIAMONDS("054c28ea-6ad8-4777-bf21-88e528c390cf");

    private final String sku;
}
