package com.project.controller;

import com.project.model.Movie;
import com.project.services.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by grgbibek22 on 12/20/2017.
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieServices movieServices;

    /*  READ MOVIE BY ID     */
    @RequestMapping("/{movieId}")
    public Movie getMovieById(@PathVariable(value = "movieId") int movieId ){
        return movieServices.getMovieById(movieId);
    }

    /*  CREATE  */
    @RequestMapping(value = "/add/{movieName}/{directors}/{movieTimeDuration}/{movieType}/{showTime}/{stars}/{ticketPrice}/{writer}",method = RequestMethod.POST, headers="Accept=application/json")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void saveMovie(@PathVariable("movieName") String movieName,@PathVariable("directors") String directors,
                         @PathVariable("movieTimeDuration") String movieTimeDuration, @PathVariable("movieType") String movieType,
                         @PathVariable("showTime") String showTime,@PathVariable("stars") String stars,
                         @PathVariable("ticketPrice") String ticketPrice,@PathVariable("writer") String writer){
        Movie movie = new Movie();
        movie.setMovieName(movieName);
        movie.setDirectors(directors);
        movie.setMovieTimeDuration(movieTimeDuration);
        movie.setMovieType(movieType);
        movie.setShowTime(showTime);
        movie.setStars(stars);
        movie.setTicketPrice(ticketPrice);
        movie.setWriter(writer);

        movieServices.addMovie(movie);
    }

    /*  GET HALL LIST   */
    @RequestMapping(value="/getMovieList", method = RequestMethod.GET)
    public List<Movie> getMovieList(){
        return movieServices.getMovieList();
    }

    @RequestMapping(value = "/update/{Id}/{movieName}/{directors}/{movieTimeDuration}/{movieType}/{showTime}/{stars}/{ticketPrice}/{writer}",method = RequestMethod.PUT, headers="Accept=application/json")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateMovie(@PathVariable("Id") int Id,@PathVariable("movieName") String movieName,@PathVariable("directors") String directors,
                            @PathVariable("movieTimeDuration") String movieTimeDuration, @PathVariable("movieType") String movieType,
                            @PathVariable("showTime") String showTime,@PathVariable("stars") String stars,
                            @PathVariable("ticketPrice") String ticketPrice,@PathVariable("writer") String writer){
        Movie movie = new Movie();
        movie.setId(Id);
        movie.setMovieName(movieName);
        movie.setDirectors(directors);
        movie.setMovieTimeDuration(movieTimeDuration);
        movie.setMovieType(movieType);
        movie.setShowTime(showTime);
        movie.setStars(stars);
        movie.setTicketPrice(ticketPrice);
        movie.setWriter(writer);

        movieServices.updateMovie(movie);
    }

    @RequestMapping(value = "/delete/{movieId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable("movieId") int movieId){
        Movie movie = movieServices.getMovieById(movieId);
        movieServices.removeMovie(movie);
    }
}
