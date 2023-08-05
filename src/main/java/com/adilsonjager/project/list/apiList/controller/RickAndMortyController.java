package com.adilsonjager.project.list.apiList.controller;

import com.adilsonjager.project.list.apiList.Services.rickAndMortyServices.RickAndMortyService;
import com.adilsonjager.project.list.apiList.entities.response.CharacterResponse;
import com.adilsonjager.project.list.apiList.entities.response.ListOfCharacters;
import com.adilsonjager.project.list.apiList.entities.response.LocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rickAndMorty")
public class RickAndMortyController {

    @Autowired
    RickAndMortyService rickAndMortyService;

    @GetMapping("/character/{id}")
    public ResponseEntity<CharacterResponse> getCharacterById(@PathVariable (value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(rickAndMortyService.getCharacterById(id));
    }


    @GetMapping("/location/{id}")
    public ResponseEntity<LocationResponse> getLocationById(@PathVariable (value = "id") Long id){
            return  ResponseEntity.status(HttpStatus.OK).body(rickAndMortyService.getLocationById(id));
    }

    @GetMapping("/characters")
    public ResponseEntity<ListOfCharacters> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(rickAndMortyService.getAllCharacters());
    }


}
