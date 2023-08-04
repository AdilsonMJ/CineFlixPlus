package com.adilsonjager.project.list.apiList.repository.webRickAndMorty;


import com.adilsonjager.project.list.apiList.entities.response.LocationResponse;
import com.adilsonjager.project.list.apiList.entities.response.CharacterResponse;
import com.adilsonjager.project.list.apiList.entities.response.ListOfCharacters;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CharacterRepository {
    Mono<CharacterResponse> findCharacterById(Long id);

    Mono<LocationResponse> findLocationById(Long id);

    Flux<ListOfCharacters> getAllCharacter();

}
