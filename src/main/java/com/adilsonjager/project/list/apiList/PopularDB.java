package com.adilsonjager.project.list.apiList;

import com.adilsonjager.project.list.apiList.entities.model.MovieModel;
import com.adilsonjager.project.list.apiList.repository.localDB.RepositoryMovieDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PopularDB implements CommandLineRunner {

    @Autowired
    RepositoryMovieDB repositoryMovieDB;

    @Override
    public void run(String... args) throws Exception {

        List<MovieModel> listMovie = Arrays.asList(

                new MovieModel("Inception", (short) 2010, "Sci-Fi", "Christopher Nolan"),
                new MovieModel("The Shawshank Redemption", (short) 1994, "Drama", "Frank Darabont"),
                new MovieModel("Pulp Fiction", (short) 1994, "Crime", "Quentin Tarantino"),
                new MovieModel("The Godfather", (short) 1972, "Crime", "Francis Ford Coppola"),
                new MovieModel("The Dark Knight", (short) 2008, "Action", "Christopher Nolan"),
                new MovieModel("Fight Club", (short) 1999, "Drama", "David Fincher"),
                new MovieModel("Goodfellas", (short) 1990, "Crime", "Martin Scorsese"),
                new MovieModel("Interstellar", (short) 2014, "Sci-Fi", "Christopher Nolan"),
                new MovieModel("The Matrix", (short) 1999, "Sci-Fi", "Lana Wachowski, Lilly Wachowski"),
                new MovieModel("Forrest Gump", (short) 1994, "Drama", "Robert Zemeckis"),
                new MovieModel("The Lord of the Rings: The Fellowship of the Ring", (short) 2001, "Fantasy", "Peter Jackson"),
                new MovieModel("The Social Network", (short) 2010, "Biography", "David Fincher"),
                new MovieModel("The Silence of the Lambs", (short) 1991, "Thriller", "Jonathan Demme"),
                new MovieModel("The Departed", (short) 2006, "Crime", "Martin Scorsese"),
                new MovieModel("Inglourious Basterds", (short) 2009, "War", "Quentin Tarantino"),
                new MovieModel("The Avengers", (short) 2012, "Action", "Joss Whedon"),
                new MovieModel("The Lion King", (short) 1994, "Animation", "Roger Allers, Rob Minkoff"),
                new MovieModel("The Great Gatsby", (short) 2013, "Drama", "Baz Luhrmann"),
                new MovieModel("Titanic", (short) 1997, "Romance", "James Cameron"),
                new MovieModel("The Green Mile", (short) 1999, "Drama", "Frank Darabont")
        );

        for (MovieModel movie : listMovie){
            String title = movie.getTitle();
            short year = movie.getYear();

            if (!repositoryMovieDB.existsByTitleAndYear(title, year)){
                repositoryMovieDB.save(movie);
            }

        }
    }
}
