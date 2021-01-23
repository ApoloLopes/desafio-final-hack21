package com.orbitallcorp.hack21.cards.services;

import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public List<Card> findAll() {
        return (List<Card>) cardRepository.findAll();
    }

    public Page<Card> findAll(Pageable pageable) {
        return cardRepository.findAll(pageable);
    }

    public Card findById(Long id) {
        return cardRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        cardRepository.deleteById(id);
    }
}