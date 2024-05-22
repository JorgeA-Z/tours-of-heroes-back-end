package com.heroes.heroes.administrator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Heroe {

    @Id
    @GeneratedValue
    @Column(name = "HEROE_ID")
    private Long id;

    @Column(name = "HEROE_NAME")    
    private String name;

    @Column(name = "HERO_ATT")
    private int att;

    @Column(name = "HERO_DEF")
    private int def;

    @Column(name = "HERO_SPEED")
    private int speed;

    @Column(name= "HERO_HP")
    private int hp;

    @Column(name= "HERO_STATUS")
    private boolean status;

}
