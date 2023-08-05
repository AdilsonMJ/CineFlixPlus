package com.adilsonjager.project.list.apiList.Services.rickAndMortyServices;

import com.adilsonjager.project.list.apiList.entities.response.CharacterResponse;
import com.adilsonjager.project.list.apiList.entities.response.ListOfCharacters;
import com.adilsonjager.project.list.apiList.entities.response.LocationResponse;
import com.adilsonjager.project.list.apiList.repository.webRickAndMorty.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RickAndMortyService {

    @Autowired
    CharacterRepository characterRepository;

    public CharacterResponse getCharacterById(Long id){
        return characterRepository.findCharacterById(id).orElseThrow();
    }

    public ListOfCharacters getAllCharacters(){return characterRepository.getAllCharacter().orElseThrow();}

    public LocationResponse getLocationById(Long id){
        return characterRepository.findLocationById(id).orElseThrow();
    }

}
