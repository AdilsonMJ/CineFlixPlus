package com.adilsonjager.project.list.apiList.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name = "TB_MOVIES")
public class MovieModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idMovie;

    private String title;
    private short year;
    private String gender;
    private String director;


    public MovieModel() {
    }

    public MovieModel(String title, short year, String gender, String director) {
        this.title = title;
        this.year = year;
        this.gender = gender;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public UUID getIdMovie() {
        return idMovie;
    }
}
