package day2;

import org.junit.Assert;
import org.junit.Test;

public class gs {

    @Test
    public void example1(){
        String s = "aaabbccddd";
        Assert.assertEquals("a3b2c2d3",abbrevite(s));
    }

    private String abbrevite(String s) {
        String abbr ="" ;

        for(int i=1 ; i<s.length() ; i++){
            abbr += s.charAt(i-1) ;
            int localCount =1;
            while(i<s.length() && (s.charAt(i-1) == s.charAt(i)) ){
                localCount++;
                i++;
            }
            abbr += localCount;

        }
        return abbr;
    }
}
