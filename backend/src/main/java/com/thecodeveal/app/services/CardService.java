package com.thecodeveal.app.services;

import com.thecodeveal.app.dtos.CardDto;
import com.thecodeveal.app.entities.Card;
import com.thecodeveal.app.entities.User;
import com.thecodeveal.app.repository.CardRepository;
import com.thecodeveal.app.repository.UserDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public List<Card> getCards(String username) {
        return userDetailsRepository.findByUserName(username).getCards();
    }

    public Card addCard(String username, CardDto cardDto) {
        Card newCard = Card.builder()
                .cardType(cardDto.getCardType())
                .createdAt(cardDto.getCreatedAt())
                .updatedAt(cardDto.getUpdatedAt())
                .id(cardDto.getId())
                .enabled(cardDto.isEnabled())
                .suit(cardDto.getCardSuit())
                .number(cardDto.getNumber())
                .imageSKU(cardDto.getCardSuit().getSku())
                .name(cardDto.getName()).build();
        User user = userDetailsRepository.findByUserName(username);
        log.info("logdebug {}",newCard);
        Card addedCard = cardRepository.save(newCard);
        user.getCards().add(addedCard);
        log.info("logdebug {}",user);
        userDetailsRepository.save(user);
        return newCard;
    }
}
