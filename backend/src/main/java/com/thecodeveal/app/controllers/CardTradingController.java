package com.thecodeveal.app.controllers;

import com.thecodeveal.app.dtos.CardDto;
import com.thecodeveal.app.services.CardService;
import com.thecodeveal.app.util.EntityToModelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static com.thecodeveal.app.util.EntityToModelUtil.toDto;

@RestController
@RequestMapping("/api/v1/card")
@CrossOrigin
@Slf4j
public class CardTradingController {

	@Autowired
	private CardService cardService;

	
	@GetMapping("/state/{username}")
	public ResponseEntity<List<CardDto>> getCards(@PathVariable String username){
		List<CardDto> cards = cardService.getCards(username).stream()
				.map(EntityToModelUtil::toDto)
				.collect(Collectors.toList());
		return ResponseEntity.ok(cards);
	}

	@PostMapping("/add/{username}")
	public ResponseEntity<CardDto> addCard(@PathVariable String username, @RequestBody CardDto cardDto){
		log.info("{} received {}",username,cardDto);
		CardDto card = toDto(cardService.addCard(username, cardDto));
		return ResponseEntity.ok(card);
	}

}
