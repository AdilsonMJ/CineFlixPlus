package com.adilsonjager.project.list.apiList.repository.localDB;

import com.adilsonjager.project.list.apiList.entities.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RepositoryMovieDB extends JpaRepository<MovieModel, UUID> {

    boolean existsByTitleAndYear(String title, short year);

    List<MovieModel> findByYear(short year);
    List<MovieModel> findByDirector(String director);
    List<MovieModel> findByGender(String gender);

    Optional<MovieModel> findByTitle(String title);

}
