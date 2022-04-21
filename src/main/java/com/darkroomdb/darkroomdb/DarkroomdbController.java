package com.darkroomdb.darkroomdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;

@CrossOrigin
@RestController
public class DarkroomdbController {
    @Autowired
    FilmRepository filmRepository;

    @Autowired
    RatingRepository ratingRepository;

    @GetMapping("/film")
    public ResponseEntity<List<Film>> getAllFilm() {
        return ResponseEntity.status(HttpStatus.OK).body(filmRepository.findAll());
    }

    @GetMapping("/film/{id}")
    public ResponseEntity<Film> getPokemonById(@PathVariable String id) {
        for (Film film : filmRepository.findAll()) {
            if (film.getFilmId() == parseInt(id)) {
                return ResponseEntity.status(HttpStatus.OK).body(film);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping("/film")
    public ResponseEntity<String> createFilm(@RequestBody Film film) {
        for (Rating rating : film.getRatings()) {
            rating.setFilm(film);
        }
        for (Format format : film.getFormats()) {
            format.setFilm(film);
        }
        filmRepository.save(film);
        return ResponseEntity.status(HttpStatus.CREATED).body("Film added");
    }

    @PostMapping("/film/{id}")
    public ResponseEntity<String> addRatingToFilm(@PathVariable String id, @RequestBody float newRating) {
        Film film = filmRepository.findById(Integer.valueOf(id)).orElse(null);
        if (film == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Film does not exist - cannot add rating!");
        Rating rating = new Rating(newRating, film);
        ratingRepository.save(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body("Rating added");
    }

    @DeleteMapping("/film/{id}")
    public ResponseEntity<String> deleteFilm(@PathVariable String id) {
        try {
            filmRepository.deleteById(parseInt(id));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Film with id of: " + id + " was deleted");
        } catch (EmptyResultDataAccessException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Film with the id of: " + id + " doesn't exist, can't delete!");
        }
    }

}
