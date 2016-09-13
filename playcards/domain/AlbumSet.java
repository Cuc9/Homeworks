package playcards.domain;

import java.util.Objects;
import java.util.Set;


/**
 * Created by rostyslavs on 11/21/2015.
 */
public class AlbumSet {

    public final long id;
    public final String name;
    public final Set<Card> cards;

    public AlbumSet(long id, String name, Set<Card> cards) {
        this.id = id;
        this.name = name;
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumSet albumSet = (AlbumSet) o;
        return id == albumSet.id &&
                Objects.equals(name, albumSet.name) &&
                Objects.equals(cards, albumSet.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cards);
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " name: " + this.name;
    }
}
