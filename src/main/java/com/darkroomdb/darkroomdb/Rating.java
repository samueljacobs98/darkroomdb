package com.darkroomdb.darkroomdb;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ratingId;
    private float rating;
    @ManyToOne
    @JoinColumn(name = "film_id")
    @JsonBackReference
    private Film film;

    public Rating() {}

    public Rating(float rating, Film film) {
        this.rating = rating;
        this.film = film;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
