package com.orbitallcorp.hack21.cards.controllers;

import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<Card> save(@RequestBody Card card) {
        Card savedCard = cardService.save(card);
        return new ResponseEntity(savedCard, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> updated(@PathVariable String id, @RequestBody Card card) {
        Card fetchedCard = cardService.findById(Long.valueOf(id));

        fetchedCard.setCardNumber(card.getCardNumber());
        fetchedCard.setEmbossName(card.getEmbossName());
        fetchedCard.setCustomerName(card.getCustomerName());
        fetchedCard.setDocumentNumber(card.getDocumentNumber());
        fetchedCard.setMotherName(card.getMotherName());
        fetchedCard.setAddress(card.getAddress());
        fetchedCard.setCity(card.getCity());

        Card savedCard = cardService.save(fetchedCard);
        return new ResponseEntity(savedCard, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Card> delete(@PathVariable String id) {
        cardService.deleteById(Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/paginationAndSorting")
    public Page<Card> findAll(Pageable pageable) {
        return cardService.findAll(pageable);
    }

    @GetMapping
    public List<Card> findAll() {
        return cardService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> findById(@PathVariable String id) {
        Card fetchedCard = cardService.findById(Long.valueOf(id));
        return new ResponseEntity<Card>(fetchedCard, HttpStatus.OK);
    }
}