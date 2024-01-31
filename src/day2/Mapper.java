package day2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Mapper {


    @Test
    public void testLargestInMap(){
        Map<String,String> m = new HashMap<>();
        m.put("B","b");
        m.put("A","a");
        m.put("D","d");
        m.put("C","c");

        Assert.assertEquals("a",findLargest(m));

    }

    private String findLargest(Map<String, String> m) {
        Optional<Map.Entry<String, String>> min = m.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue));
        return min.get().getValue();
    }

}
