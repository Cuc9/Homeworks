package playcards.domain;

import java.util.Objects;
import java.util.Set;

/**
 * Created by rostyslavs on 11/21/2015.
 */
public class Album {

    public final long id;
    public final String name;
    public final Set<AlbumSet> sets;

    public Album(long id, String name, Set<AlbumSet> sets) {
        this.id = id;
        this.name = name;
        this.sets = sets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return id == album.id &&
                Objects.equals(name, album.name) &&
                Objects.equals(sets, album.sets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sets);
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " name: " + this.name + " sets: " + sets;
    }
}
