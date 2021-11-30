import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieRepository {
    private Movie[] items = new Movie[0];

    public void add(Movie item) {
        Movie[] tmp = new Movie[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = item;
        this.items = tmp;
    }

    public Movie[] findAll() {
        return items;
    }
}
