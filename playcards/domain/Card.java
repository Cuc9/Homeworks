package playcards.domain;

import java.util.Objects;

/**
 * Created by rostyslavs on 11/21/2015.
 */
public class Card {
    public final long id;
    public final String name;

    public Card(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id == card.id &&
                Objects.equals(name, card.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " name: " + this.name;
    }
}
