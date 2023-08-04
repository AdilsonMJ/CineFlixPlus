package com.adilsonjager.project.list.apiList.repository.webRickAndMorty;

import com.adilsonjager.project.list.apiList.client.RickAndMortyClient;
import com.adilsonjager.project.list.apiList.entities.response.CharacterResponse;
import com.adilsonjager.project.list.apiList.entities.response.ListOfCharacters;
import com.adilsonjager.project.list.apiList.entities.response.LocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository{

    @Autowired
    RickAndMortyClient rickAndMortyClient;

    @Override
    public Mono<CharacterResponse> findCharacterById(Long id) {
        return rickAndMortyClient.findAndCharacterById(id);
    }

    @Override
    public Mono<LocationResponse> findLocationById(Long id) {
        return rickAndMortyClient.findLocationById(id);
    }

    @Override
    public Flux<ListOfCharacters> getAllCharacter() {
        return rickAndMortyClient.getAll();
    }
}
