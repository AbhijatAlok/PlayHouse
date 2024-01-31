package day1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class UniqueChar {

    public int firstUniqChar(String s) {
        var store = new HashMap<Character, Integer>(s.length());

        char[] elements = s.toCharArray();

        for(var ele:elements){
            store.merge(ele,1, Integer::sum);
        }

        for(var i = 0; i< elements.length ; i++){
           if(store.get(elements[i]) > 1){
               continue;
           }else{
               return i;
           }
        }

        return -1;

    }

    @Test
    public void ex1(){
        var s = "leetcode";
        Assert.assertEquals(0,firstUniqChar(s));

        s = "loveleetcode";
        Assert.assertEquals(2,firstUniqChar(s));

        s = "aabb";
        Assert.assertEquals(-1,firstUniqChar(s));

    }

}
