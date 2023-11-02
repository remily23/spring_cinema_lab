package com.example.spring_cinema_lab.services;

import com.example.spring_cinema_lab.models.Movie;
import com.example.spring_cinema_lab.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public MovieService(){

    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public Movie getMovieById(long id){
        return movieRepository.getById(id);
    }

    public List<Movie> getMovieList(){
        return movieRepository.findAll();
    }



}

