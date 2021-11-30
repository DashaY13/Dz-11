import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    private final MovieRepository repo = Mockito.mock(MovieRepository.class);
    private final MovieManager manager = new MovieManager(repo, 2);
    private final Movie Betman = new Movie(1, "Betman", 1989, "thriller");
    private final Movie Forsash = new Movie(2, "Forsash", 2001, "thriller");
    private final Movie Matrix = new Movie(3, "Matrix", 1986, "thriller");

    @Test
    void save() {
        Mockito.doNothing().when(repo).add(ArgumentMatchers.any());
        manager.save(Betman);
        verify(repo).add(ArgumentMatchers.any());
    }

    private MovieRepository verify(MovieRepository repo) {
        return repo;
    }

    @Test
    void lastFilms() {
        Mockito.doReturn(new Movie[] {Betman, Forsash}).when(repo).findAll();
        assertArrayEquals(new Movie[] {Forsash, Betman}, manager.lastFilms());
    }

    @Test
    void lastFilmsWithLimit() {
        Mockito.doReturn(new Movie[] {Betman, Forsash, Matrix}).when(repo).findAll();
        assertArrayEquals(new Movie[] {Matrix, Forsash}, manager.lastFilms());
    }

}