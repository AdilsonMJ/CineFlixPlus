package com.adilsonjager.project.list.apiList.Services.moviesServices;

import com.adilsonjager.project.list.apiList.Services.exceptions.ResourceNotFoundException;
import com.adilsonjager.project.list.apiList.entities.model.MovieModel;
import com.adilsonjager.project.list.apiList.repository.localDB.RepositoryMovieDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServices {

    @Autowired
    private RepositoryMovieDB repositoryMovieDB;


    public List<MovieModel> getAllMoviesSortByAlph() {
        List<MovieModel> movieList = new ArrayList<>(repositoryMovieDB.findAll());
        movieList.sort(Comparator.comparing(MovieModel::getTitle));
        return movieList;
    }

    public List<MovieModel> getAllMoviesSortByYear() {
        List<MovieModel> movieList = new ArrayList<>(repositoryMovieDB.findAll());
        movieList.sort(Comparator.comparing(MovieModel::getYear));
        return movieList;
    }


    public List<MovieModel> getAllMovieByshuffled() {
        List<MovieModel> movieList = new ArrayList<>(repositoryMovieDB.findAll());
        Collections.shuffle(movieList);
        return movieList;

    }

    public List<MovieModel> getAllMovieSortByDirector() {
        List<MovieModel> movieList = new ArrayList<>(repositoryMovieDB.findAll());
        movieList.sort(Comparator.comparing(MovieModel::getDirector));

        return movieList;
    }

    public List<MovieModel> getAllMovieSortByGender() {
        List<MovieModel> movieList = new ArrayList<>(repositoryMovieDB.findAll());
        movieList.sort(Comparator.comparing(MovieModel::getGender));
         return movieList;
    }


    public MovieModel findByID(UUID id) {
        Optional<MovieModel> obj = repositoryMovieDB.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<MovieModel> findByYear(short year) {
        return repositoryMovieDB.findByYear(year);
    }

    public List<MovieModel> findByGender(String gender) {
        return repositoryMovieDB.findByGender(gender);
    }

    public List<MovieModel> findByDirector(String director) {
        return repositoryMovieDB.findByDirector(director);
    }

    public MovieModel findByTitle(String title) {
        Optional<MovieModel> obj = repositoryMovieDB.findByTitle(title);

        return obj.orElseThrow(() -> new ResourceNotFoundException(title));
    }

}
