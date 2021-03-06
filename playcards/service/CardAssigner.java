package playcards.service;

import playcards.domain.Event;

import java.util.function.Consumer;

/**
 * Created by rostyslavs on 11/21/2015.
 */
public interface CardAssigner {
    void assignCard(long userId, long cardId);
    void subscribe(Consumer<Event> consumer);
}