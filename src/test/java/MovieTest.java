import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {
    private final MovieRepository repo = new MovieRepository();
    private final Movie Betman = new Movie(1, "Betman", 1989, "thriller");
    private final Movie Forsash = new Movie(2, "Forsash", 2001, "thriller");

    @BeforeEach
    void setUp() {
        repo.add(Betman);
        repo.add(Forsash);
    }

    @Test
    void findAll() {
        assertArrayEquals(new Movie[]{Betman, Forsash}, repo.findAll());
    }
}










