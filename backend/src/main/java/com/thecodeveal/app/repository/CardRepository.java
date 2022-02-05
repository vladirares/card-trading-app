package com.thecodeveal.app.repository;

import com.thecodeveal.app.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}
