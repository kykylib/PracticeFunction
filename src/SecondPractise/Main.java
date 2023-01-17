package SecondPractise;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Object> someList = new ArrayList<>();

        someList.add(" Hello  ");
        someList.add(null);
        someList.add(10);
        someList.add(2.5);
        someList.add(true);
        someList.add(false);

        Filter filter = list -> {
            // Second version
            List<Object> filteredList = new ArrayList<>();
            for (Object object : list) {
                Object data = Optional.ofNullable(object).orElseGet(() -> {
                    filteredList.add(System.currentTimeMillis());
                    return Optional.empty();
                });
                Optional.ofNullable(data)
                        .map(currentData -> {
                            Optional.ofNullable(currentData)
                                    .filter(someData -> data.getClass() == String.class)
                                    .ifPresent(someData ->filteredList.add(Filter.getCleanString((String) someData)));
                            return currentData;
                        })
                        .map(currentData -> {
                            Optional.ofNullable(currentData)
                                    .filter(someData -> data.getClass() == Double.class)
                                    .ifPresent(someData -> filteredList.add(Filter.getIntegerNumber((Double) someData)));
                            return currentData;
                        })
                        .map(currentData -> {
                            Optional.ofNullable(currentData)
                                    .filter(someData -> data.getClass() == Boolean.class)
                                    .ifPresent(someData -> filteredList.add(Filter.getReverseBoolean((Boolean) someData)));
                            return currentData;
                        })
                        .filter(someData -> someData.getClass() != String.class && someData.getClass() != Double.class && someData.getClass() != Boolean.class && someData != Optional.empty())
                        .ifPresent(someData -> filteredList.add(someData));
// First version
//                Optional.ofNullable(object)
//                        .map(data -> {
//                            Optional.ofNullable(data)
//                            .ifPresent(someData -> {
//                                if (someData.getClass() == String.class) {
//                                    filteredList.add(Filter.getCleanString((String) someData));
//                                }
//                                else if (someData.getClass() == Double.class) {
//                                    filteredList.add(Filter.getIntegerNumber((Double) someData));
//                                }
//                                else if (someData.getClass() == Boolean.class) {
//                                    filteredList.add(Filter.getReverseBoolean((Boolean) someData));
//                                }
//                                else {
//                                    filteredList.add(someData);
//                                }
//                            });
//                            return data;
//                        })
//                        .orElseGet(() -> filteredList.add(System.currentTimeMillis()));
            }
            return filteredList;
        };
        System.out.println(filter.getModificatedList(someList));
    }
}
