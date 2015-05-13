package ms.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        super();
        this.repository = repository;
    }

    public Movie findMovie(String id) {
        return repository.findById(id);
    }

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public List<Movie> findByGenre(Genre genre) {
        return repository.findByGenre(genre);
    }

    public List<Movie> findByYear(String year) {
        return repository.findByYear(year);
    }
}
