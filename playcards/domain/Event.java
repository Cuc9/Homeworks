package playcards.domain;

import java.util.Objects;

/**
 * Created by rostyslavs on 11/21/2015.
 */
public class Event {

    public final long userId;
    public final Type type;

    public Event(long userId, Type type) {
        this.userId = userId;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return userId == event.userId &&
                type == event.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, type);
    }

    @Override
    public String toString() {
        return "ID: " + this.userId + " type: " + this.type;
    }

    public enum Type {
        SET_FINISHED, ALBUM_FINISHED
    }
}