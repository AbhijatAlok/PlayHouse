package day1;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CheckMag {

    @Test
    public void testCheckMagYes(){
        List<String> magazine = Arrays.stream("give me one grand today night".split(" ")).toList();
        List<String> note = Arrays.stream("give one grand today".split(" ")).toList();

        assertEquals("Yes", checkMagazine(magazine,note));
    }

    @Test
    public void testCheckMagNo(){
        List<String> magazine = Arrays.stream("two times three is not is four".split(" ")).toList();
        List<String> note = Arrays.stream("two times two is four".split(" ")).toList();

        assertEquals("No", checkMagazine(magazine,note));
    }
    private String checkMagazine(List<String> magazine, List<String> note) {

        Map<String,Integer> tracker = new HashMap<>();

        magazine.forEach(word->{
            Integer i = tracker.containsKey(word) ? tracker.put(word, tracker.get(word)+1) : tracker.put(word, 1);
            //tracker.computeIfPresent(word,(k,v)-> v+1);
            //tracker.computeIfAbsent(word, k-> 1);
        });

        for (String s : note) {
            Integer ret = tracker.computeIfPresent(s,(k,v)->v-1);
            if (ret == null || ret < 0){
                return "No";
            }
        }
        return "Yes";
    }

    private String checkMagazine1(List<String> magazine, List<String> note) {

        List<String> magazineCopy = new LinkedList<>(magazine);

        for (String s : note) {

            if (magazineCopy.contains(s)) {
                magazineCopy.remove(s);
            } else {
                return "No";

            }
        }
        return "Yes";
    }
}
