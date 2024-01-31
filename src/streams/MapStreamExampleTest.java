package streams;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MapStreamExampleTest {

    @Test
    public void testFilterMapByAge() {
        Map<String, Integer> ageMap = new HashMap<>();
        ageMap.put("Alice", 25);
        ageMap.put("Bob", 30);
        ageMap.put("Charlie", 22);
        ageMap.put("David", 35);

        // Call the method that filters the map based on age greater than 25
        Map<String, Integer> filteredMap = filterMapByAge(ageMap, 25);

        // Expected result after filtering
        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put("Bob", 30);
        expectedResult.put("David", 35);

        // Assert that the filtered map matches the expected result
        assertEquals(expectedResult, filteredMap);
    }

    // Method to filter the map based on age
    private Map<String, Integer> filterMapByAge(Map<String, Integer> ageMap, int ageThreshold) {
        return ageMap.entrySet().stream()
                .filter(entry -> entry.getValue() > ageThreshold)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
