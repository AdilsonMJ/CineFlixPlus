package com.adilsonjager.project.list.apiList.client;

import com.adilsonjager.project.list.apiList.entities.response.CharacterResponse;
import com.adilsonjager.project.list.apiList.entities.response.ListOfCharacters;
import com.adilsonjager.project.list.apiList.entities.response.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
@Slf4j
public class RickAndMortyClient {

    private final WebClient webClient;


    public RickAndMortyClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public CharacterResponse findAndCharacterById(Long id){
        log.info("Buscando o personagem com o id [{}]", id);

        return webClient
                .get()
                .uri("/character/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(this::is4xxClientError,
                        error -> Mono.error(new RuntimeException("ID not found")))
                .bodyToMono(CharacterResponse.class).block();
    }


    private boolean is4xxClientError(HttpStatusCode httpStatusCode) {
        return httpStatusCode.is4xxClientError();
    }

    public LocationResponse findLocationById(Long id) {

        log.info("looking the location by id [{}]", id);
        return webClient
                .get()
                .uri("/location/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(this::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Id not found")))
                .bodyToMono(LocationResponse.class).block();


    }

    public ListOfCharacters getAll() {

        log.info("looking all characters");

        return webClient.get().uri("/character").accept(MediaType.APPLICATION_JSON).retrieve()
                .onStatus(this::is4xxClientError, error -> Mono.error(new RuntimeException("Error on get characters")))
                .bodyToMono(ListOfCharacters.class).block();

    }
}
