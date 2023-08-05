package com.adilsonjager.project.list.apiList.repository.webRickAndMorty;


import com.adilsonjager.project.list.apiList.entities.response.LocationResponse;
import com.adilsonjager.project.list.apiList.entities.response.CharacterResponse;
import com.adilsonjager.project.list.apiList.entities.response.ListOfCharacters;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public interface CharacterRepository {
    Optional<CharacterResponse> findCharacterById(Long id);

    Optional<LocationResponse> findLocationById(Long id);

    Optional<ListOfCharacters> getAllCharacter();

}
