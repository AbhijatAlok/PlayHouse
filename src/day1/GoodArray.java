package day1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class GoodArray {
    public static boolean isGood(int[] nums) {

        Arrays.sort(nums);
        for(int i=1; i<=nums.length-1;i++){
            if(i == nums[i-1]){
                continue;
            }else{
                return false;
            }
        }
        if(nums[nums.length-1] != nums.length-1) return false;

        return true;
    }


    @Test
    public void ex1(){
        int[] ex1 = new int[]{2,1,3};
        Assert.assertEquals(false, isGood(ex1));
    }

    @Test
    public void ex2(){
        int[] ex1 = new int[]{1, 3, 3, 2};
        Assert.assertEquals(true, isGood(ex1));
    }

    @Test
    public void ex3(){
        int[] ex1 = new int[]{1, 1,2};
        Assert.assertEquals(false, isGood(ex1));
    }

    @Test
    public void ex4(){
        int[] ex1 = new int[]{3, 4, 4, 1, 2, 1};
        Assert.assertEquals(false, isGood(ex1));
    }
}
