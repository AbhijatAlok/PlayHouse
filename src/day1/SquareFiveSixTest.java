package day1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SquareFiveSixTest {

    @Test
    public void testSq56(){

        System.out.println(countClumps(new int[]{1, 2, 2, 3, 4, 4}));
//        assertEquals(Arrays.asList(19, 11), square56(Arrays.asList(3, 1, 4)));
//        assertEquals(List.of(11), square56(List.of(1)));
//        assertEquals(Arrays.asList(new Integer[]{14}), square56(Arrays.asList(new Integer[]{2})));

    }

    List<Integer> square56(List<Integer> nums) {
        return nums.stream().map(x-> (x*x) + 10).filter(x-> (  x%10 != 5 && x%10 != 6 )).collect(Collectors.toList());
    }

    public int countClumps(int[] nums) {

        int clumps=0;
        for (int i = 0; i < nums.length; i++) {

            int start = nums[i];
            int streak = 0;
            for(int j=i;j< nums.length && start == nums[j];j++){
                    streak++;


                i=j;
            }
            if(streak > 1){
                clumps++;
            }
        }
return clumps;
    }

    public String[] wordsWithout(String[] words, String target) {
        return Arrays.stream(words).filter(x -> !x.equals(target)).toArray(String[]::new);
    }

    public String[] wordsWithout1(String[] words, String target) {
        return Arrays.stream(words).sorted().toArray(String[]::new);
    }

//    private int[] square56(int[] ints) {
//        return Arrays.stream(ints).map(x-> (x*x) + 10).filter(x-> (  x%10 != 5 && x%10 != 6 )).toArray();
//    }
}
