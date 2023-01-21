package FirstPractise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<Petard> petards = Petard.createPetards();

        Filter filter = list -> {
            List<Petard> filteredListOfPetard = new ArrayList<>();
            for (Petard petard : list) {
                Optional.ofNullable(petard)
                        .filter(currentPetard -> currentPetard.getPowder() > 10)
                        .filter(currentPetard -> currentPetard.getLength().equals("Short"))
                        .ifPresent(filteredListOfPetard::add);
            }
            return filteredListOfPetard;
        };

        List<Petard> petardsWithMorePoroxThan10AndSizeShort = filter.getPetardsWithMorePowderThan10AndSizeShort(petards);
        System.out.println("\nList before filtering\n");
        System.out.println(petards);
        System.out.println("----------------------------------------");
        System.out.println("\nList after filtering\n");
        System.out.println(petardsWithMorePoroxThan10AndSizeShort);
    }
}
