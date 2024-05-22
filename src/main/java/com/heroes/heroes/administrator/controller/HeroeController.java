package com.heroes.heroes.administrator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heroes.heroes.administrator.dto.HeroResponse;
import com.heroes.heroes.administrator.model.Heroe;
import com.heroes.heroes.administrator.repositories.HeroeRepository;

import java.net.URI;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;


@RestController("HeroesController")
@RequestMapping("/v1")
public class HeroeController {

    @Autowired
    private HeroeRepository heroeRepository;

    @PostMapping("/heroes")
    public ResponseEntity<?> createHeroe(@RequestBody Heroe heroe)
    {
        heroe = heroeRepository.save(heroe);


        HttpHeaders httpHeaders = new HttpHeaders();
        
        URI newHeroUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(heroe.getId()).toUri();

        httpHeaders.setLocation(newHeroUri);

        return new ResponseEntity<>(heroe, httpHeaders ,HttpStatus.CREATED);


    }

    @GetMapping("/heroes/{id}")

    public ResponseEntity<?> getHeroe(@PathVariable Long id)
    {

        Optional<Heroe> heroe = heroeRepository.findById(id);
        

        if(heroe.isPresent())
        {
        
            return new ResponseEntity<>(heroe, HttpStatus.OK);
        
        }else
        {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    @GetMapping("/heroes")
    public ResponseEntity<?> getHeroeList()
    {
        

        HeroResponse heroResponse = new HeroResponse();

        heroResponse.setData(heroeRepository.findAll());


        return new ResponseEntity<>(heroResponse, HttpStatus.OK);

    }

    @PutMapping("/heroes/{id}")

    public ResponseEntity<?> updateHeroe(@RequestBody Heroe heroe, @PathVariable Long id)
    {

        heroe.setId(id);
        heroeRepository.save(heroe);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/heroes/{id}")

    public ResponseEntity<?> deleteHeroe(@PathVariable Long id)
    {
        Optional<Heroe> heroe = heroeRepository.findById(id);

        if(heroe.isPresent())
        {
            heroeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }else
        {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

}
