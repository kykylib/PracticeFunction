package FirstPractise;

import java.util.List;

public interface Filter {
    List<Petard> getPetardsWithMorePowderThan10AndSizeShort(List<Petard> list);
}
