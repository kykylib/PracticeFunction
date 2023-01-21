package SecondPractise;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Object> someList = new ArrayList<>();

        someList.add(" Hello  ");
        someList.add(" True  ");
        someList.add(null);
        someList.add(10);
        someList.add(2.5);
        someList.add(true);
        someList.add(false);

        Filter filter = list -> {
            List<Object> filteredList = new ArrayList<>();
            for (Object object : list) {
                Object data = Optional.ofNullable(object)
                        .map(currentData -> {
                            if (currentData.getClass() == String.class) {
                                return Filter.getCleanString((String) currentData);
                            }
                            if (currentData.getClass() == Double.class || currentData.getClass() == Float.class) {
                                return Filter.getIntegerNumber((Double) currentData);
                            }
                            if (currentData.getClass() == Boolean.class) {
                                return Filter.getReverseBoolean((boolean) currentData);
                            }
                            return currentData;
                        })
                        .filter(currentData -> currentData != Optional.empty())
                        .orElse(System.currentTimeMillis());
                filteredList.add(data);
            }
            return filteredList;
        };
        System.out.println(filter.getModificatedList(someList));
    }
}
