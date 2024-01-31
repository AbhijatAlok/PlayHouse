package day2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LongestSubSeq {


    @Test
    public void longest(){
        int[] t1 = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        Assert.assertArrayEquals(new int[]{2, 3, 7, 101} , longRun(t1));
    }

    private int[] longRun(int[] t1) {
        int[] result = new int[0];
        for(int i=0; i<t1.length;i++){
            int[] subArr = Arrays.copyOfRange(t1,i,t1.length);
            longRun(subArr);
        }
        return result;
    }
}
