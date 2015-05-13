package ms.movie;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository {

    Movie findById(String id);

    List<Movie> findByGenre(Genre genre);

    List<Movie> findByYear(String date);

    List<Movie> findAll();
}
