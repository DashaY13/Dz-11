import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class MovieManager {
    private final MovieRepository repo;
    private int limit = 10;

    public void save(Movie movie) {
        repo.add(movie);
    }

    public Movie[] lastFilms() {
        Movie[] allFromRepo = repo.findAll();
        Movie[] tmp = new Movie[Math.min(allFromRepo.length, limit)];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = allFromRepo[allFromRepo.length - 1 - i];
        }
        return tmp;
    }
}
