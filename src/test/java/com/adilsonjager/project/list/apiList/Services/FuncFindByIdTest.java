package com.adilsonjager.project.list.apiList.Services;

import com.adilsonjager.project.list.apiList.Services.exceptions.ResourceNotFoundException;
import com.adilsonjager.project.list.apiList.Services.moviesServices.MovieServices;
import com.adilsonjager.project.list.apiList.entities.model.MovieModel;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ComponentScan
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FuncFindByIdTest {

    @Autowired
    private MovieServices movieServices;

    @Test
    void findByIDShouldBeReturnTrue() {


        //The ID d136a6ad-64a8-4402-9e7b-3a0fb88cfc67 should be return the movie Fight Club

        MovieModel movieModel = movieServices.findByID(UUID.fromString( "d136a6ad-64a8-4402-9e7b-3a0fb88cfc67"));

        assertEquals(movieModel.getTitle(), "Fight Club");

    }

    @Test
    void findByIDShouldBeReturnFalse() {


        //The ID 1473d02-65f5-4202-926a-f657e782db91 should be return the movie Forrest Gump

        MovieModel movieModel = movieServices.findByID(UUID.fromString( "d136a6ad-64a8-4402-9e7b-3a0fb88cfc67"));

        assertNotEquals(movieModel.getTitle(), "Forrest Gump");

    }

    @Test
    void findByIDPassAInvalidID() {

        assertThrows(ResourceNotFoundException.class, () -> {

            //The ID d136a6ad-64a8-4402-9e7b-3a0fb88cf not exist.
            //This test should be true to custom exception when the Id is not exist.

            MovieModel movieModel = movieServices.findByID(UUID.fromString( "d136a6ad-64a8-4402-9e7b-3a0fb88cf"));

        });



    }

}
