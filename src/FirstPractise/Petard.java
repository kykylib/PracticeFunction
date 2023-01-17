package FirstPractise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Petard {
    final private int powder;
    final private String length;

    private Petard(int powder, String length) {
        this.powder = powder;
        this.length = length;
    }

    public int getPowder() {
        return powder;
    }

    public String getLength() {
        return length;
    }

    public static List<Petard> createPetards() {
        List<String> listLengthOfPetards = new ArrayList<>();
        listLengthOfPetards.add("Short");
        listLengthOfPetards.add("Middle");
        listLengthOfPetards.add("Long");

        List<Petard> petardsList = new ArrayList<>();

        while (petardsList.size() != 5) {
            int countOfPowder = new Random().nextInt(1, 21);
            int randomSize = new Random().nextInt(3);
            Petard petard = new Petard(countOfPowder, listLengthOfPetards.get(randomSize));
            petardsList.add(petard);
        }
        return petardsList;
    }

    @Override
    public String toString() {
        return "FirstPractise.Petard{" +
                "porox=" + powder +
                " length=" + length + '}' + '\n';
    }
}
