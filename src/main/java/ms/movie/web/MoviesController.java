package ms.movie.web;

import java.util.List;

import ms.movie.Genre;
import ms.movie.Movie;
import ms.movie.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/movie")
@RestController
public class MoviesController {

    @Autowired
    private MovieService service;

    @RequestMapping("/")
    public List<Movie> allMovies() {
        return service.findAll();
    }

    @RequestMapping("/genre")
    public List<Movie> findByGenre(@RequestParam(value = "genre", required = false) final Genre genre) {
        return service.findByGenre(genre);
    }

    @RequestMapping("year")
    public List<Movie> findByYear(@RequestParam(value = "year", required = false) final String year) {
        return service.findByYear(year);
    }
}
