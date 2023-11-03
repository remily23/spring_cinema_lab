package com.example.spring_cinema_lab.controllers;
import com.example.spring_cinema_lab.models.Movie;
import com.example.spring_cinema_lab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> addMovie(RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable long id){
        Optional<Movie> optionalMovie = movieService.findMovieById(id);
        if(optionalMovie.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    public ResponseEntity<List<Movie>> returnAllMovies(){
        List<Movie> movies = movieService.getMovieList();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

//    @PatchMapping
//    public ResponseEntity<Movie> updateMovie( @RequestBody Movie updatedMovie, @PathVariable Integer id) {
//        Movie existingMovie = movieService.getMovieById(id);

}
