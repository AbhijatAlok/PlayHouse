package day1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class UniOcc {

    public boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer,Integer> store = new HashMap<>();
        for (int i : arr) {
            store.merge(i,1,Integer::sum);
        }

        for(Integer i:store.values()){
            long cnt = store.values().stream().filter(x->x.equals(i)).count();
            if(cnt ==1) {
                continue;
            }else{
                return false;
            }
        }
        return true;
    }


    @Test
    public void ex1(){
        int[] arr = new int[]{-3,0,1,-3,1,1,1,-3,10,0};
        Assert.assertTrue(uniqueOccurrences(arr));
    }
}
