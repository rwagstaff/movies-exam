package ms.movie.fake;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ms.movie.Genre;
import ms.movie.Movie;
import ms.movie.MovieRepository;

import org.springframework.stereotype.Repository;

@Repository
public class FakeMovieRepository implements MovieRepository {

    @Override
    public Movie findById(String id) {
        return new Movie("The Notebook", Genre.ROMANCE, new Date());
    }

    @Override
    public List<Movie> findByGenre(Genre genre) {
        return movies();
    }

    @Override
    public List<Movie> findByYear(String date) {
        return movies();
    }

    @Override
    public List<Movie> findAll() {
        return movies();
    }

    private List<Movie> movies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Up!", Genre.COMEDY, new Date()));
        movies.add(new Movie("Gladiator", Genre.ACTION, new Date()));
        movies.add(new Movie("Forest Gump", Genre.ACTION, new Date()));
        return movies;
    }

}
