package com.heroes.heroes.administrator.dto;


import java.util.List;

import com.heroes.heroes.administrator.model.Heroe;

import lombok.Data;

@Data
public class HeroResponse {

    private List<Heroe> data;

}
