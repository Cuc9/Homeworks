package playcards.domain;

import java.security.PrivateKey;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * Created by arpi on 17.06.2016.
 */
public class MainClass {

    private static Album animals;


    private static Card getCard() {
        Random random = new Random();
        Iterator iterSets = animals.sets.iterator();
        Iterator iterCards;
        AlbumSet albumSet = null;
        Card randomCard = null;
        int itemNeeded = random.nextInt(animals.sets.size());

        for (int i = 0; i <= itemNeeded; i++) {
            if (iterSets.hasNext()) {
                albumSet = (AlbumSet) iterSets.next();
            }
        }

        if (null != albumSet) {
            itemNeeded = random.nextInt(albumSet.cards.size());
            iterCards = albumSet.cards.iterator();
            for (int i = 0; i < itemNeeded + 1; i++) {
                if (iterCards.hasNext()) {
                    randomCard = (Card) iterCards.next();
                }
            }
        } else System.out.println("Error in albumSet");
        return randomCard;
    }

    public static void main(String[] args) {
        Card stork = new Card(0, "Stork");
        Card tit = new Card(1, "Tit");
        Card eagle = new Card(2, "Eagle");

        Card perch = new Card(3, "Perch");
        Card pike = new Card(4, "Pike");
        Card marlin = new Card(5, "Marlin");

        Card tiger = new Card(6, "Tiger");
        Card lion = new Card(7, "Lion");
        Card jaguar = new Card(8, "Jaguar");


        Set<Card> bird = new HashSet<>();
        bird.add(stork);
        bird.add(tit);
        bird.add(eagle);
        AlbumSet birdSet = new AlbumSet(0, "Birds", bird);

        Set<Card> fish = new HashSet<>();
        fish.add(perch);
        fish.add(pike);
        fish.add(marlin);
        AlbumSet fishSet = new AlbumSet(1, "Fishes", fish);

        Set<Card> cat = new HashSet<>();
        cat.add(tiger);
        cat.add(lion);
        cat.add(jaguar);
        AlbumSet catSet = new AlbumSet(2, "Cats", cat);

        Set<AlbumSet> animalSets = new HashSet<>();
        animalSets.add(birdSet);
        animalSets.add(fishSet);
        animalSets.add(catSet);

        animals = new Album(0, "Animals", animalSets);
        for (int i = 0; i < 100; i++) {
            System.out.println(MainClass.getCard());
        }
    }
}
