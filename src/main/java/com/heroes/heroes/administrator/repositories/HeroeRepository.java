package com.heroes.heroes.administrator.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.heroes.heroes.administrator.model.Heroe;

@Repository
public interface HeroeRepository extends JpaRepository<Heroe, Long> {

}
