package com.adilsonjager.project.list.apiList.client;

import com.adilsonjager.project.list.apiList.entities.response.CharacterResponse;
import com.adilsonjager.project.list.apiList.entities.response.ListOfCharacters;
import com.adilsonjager.project.list.apiList.entities.response.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Slf4j
public class RickAndMortyClient {

    private final WebClient webClient;


    public RickAndMortyClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public Mono<CharacterResponse> findAndCharacterById(Long id){
        log.info("Buscando o personagem com o id [{}]", id);

        return webClient
                .get()
                .uri("/character/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(this::is4xxClientError,
                        error -> Mono.error(new RuntimeException("ID not found")))
                .bodyToMono(CharacterResponse.class);
    }


    private boolean is4xxClientError(HttpStatusCode httpStatusCode) {
        return httpStatusCode.is4xxClientError();
    }

    public Mono<LocationResponse> findLocationById(Long id) {

        log.info("looking the location by id [{}]", id);
        return webClient
                .get()
                .uri("/location/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(this::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Id not found")))
                .bodyToMono(LocationResponse.class);


    }

    public Flux<ListOfCharacters> getAll() {

        log.info("looking all characters");

        return webClient.get().uri("/character").accept(MediaType.APPLICATION_JSON).retrieve()
                .onStatus(this::is4xxClientError, error -> Mono.error(new RuntimeException("Error on get characters")))
                .bodyToFlux(ListOfCharacters.class);

    }
}
