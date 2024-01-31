package streams;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStreamExample {
    public static void main(String[] args) {
        Map<String, Integer> ageMap = new HashMap<>();
        ageMap.put("Alice", 25);
        ageMap.put("Bob", 30);
        ageMap.put("Charlie", 22);
        ageMap.put("David", 35);

        // Filtering the map based on a condition (e.g., age greater than 25)
        Map<String, Integer> filteredMap = ageMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 24)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(filteredMap);
    }
}

