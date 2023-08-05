package com.adilsonjager.project.list.apiList.repository.webRickAndMorty;

import com.adilsonjager.project.list.apiList.client.RickAndMortyClient;
import com.adilsonjager.project.list.apiList.entities.response.CharacterResponse;
import com.adilsonjager.project.list.apiList.entities.response.ListOfCharacters;
import com.adilsonjager.project.list.apiList.entities.response.LocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository{

    @Autowired
    RickAndMortyClient rickAndMortyClient;

    @Override
    public Optional<CharacterResponse> findCharacterById(Long id) {
        return Optional.ofNullable(rickAndMortyClient.findAndCharacterById(id));
    }

    @Override
    public Optional<LocationResponse> findLocationById(Long id) {
        return Optional.ofNullable(rickAndMortyClient.findLocationById(id));
    }

    @Override
    public Optional<ListOfCharacters> getAllCharacter() {
        return Optional.ofNullable(rickAndMortyClient.getAll());
    }
}
