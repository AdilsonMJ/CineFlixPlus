package com.adilsonjager.project.list.apiList.controller;

import com.adilsonjager.project.list.apiList.Services.MovieServices;
import com.adilsonjager.project.list.apiList.entities.MovieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieServices movieServices;

    @GetMapping
    public ResponseEntity<List<MovieModel>> getAllMovieSortByAlph() {
        return ResponseEntity.status(HttpStatus.OK).body(movieServices.getAllMoviesSortByAlph());

    }

    @GetMapping("/moviesbyyear")
    public ResponseEntity<List<MovieModel>> getAllMoviesSortByYear() {
        return ResponseEntity.status(HttpStatus.OK).body(movieServices.getAllMoviesSortByYear());
    }

    @GetMapping("/moviesbyshuffle")
    public ResponseEntity<List<MovieModel>> getAllMoviesSortByShuffle() {
        return ResponseEntity.status(HttpStatus.OK).body(movieServices.getAllMovieByshuffled());
    }

    @GetMapping("/moviesbygender")
    public ResponseEntity<List<MovieModel>> getAllMoviesSortByYGender() {
        return ResponseEntity.status(HttpStatus.OK).body(movieServices.getAllMovieSortByGender());
    }

    @GetMapping("/moviesbydirector")
    public ResponseEntity<List<MovieModel>> getAllMoviesSortByDirector() {
        return ResponseEntity.status(HttpStatus.OK).body(movieServices.getAllMovieSortByDirector());
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<MovieModel> getById(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(movieServices.findByID(id));
    }

    @GetMapping(value = "/gender/{gender}")
    public ResponseEntity<List<MovieModel>> getByGender(@PathVariable(value = "gender") String gender) {
        return ResponseEntity.status(HttpStatus.OK).body(movieServices.findByGender(gender));
    }

    @GetMapping(value = "/year/{year}")
    public ResponseEntity<List<MovieModel>> getByYear(@PathVariable(value = "year") short year) {
        return ResponseEntity.status(HttpStatus.OK).body(movieServices.findByYear(year));
    }

    @GetMapping(value = "/director/{director}")
    public ResponseEntity<List<MovieModel>> getBydirector(@PathVariable(value = "director") String director) {
        return ResponseEntity.status(HttpStatus.OK).body(movieServices.findByDirector(director));
    }

    @GetMapping(value = "/title/{title}")
    public ResponseEntity<MovieModel> getByTitle(@PathVariable(value = "title") String title){
        return ResponseEntity.status(HttpStatus.OK).body(movieServices.findByTitle(title));
    }


}
