package day2;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

import static java.lang.String.format;

public class ResultSumArr {

    public static int simpleArraySum(List<Integer> ar) {
        // Write your code here
       return ar.stream().reduce(new BinaryOperator<>(){
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }).get();
    }

    public static void plusMinus(List<Integer> arr) {
        Long count = (long) arr.size();

        Long positive = arr.stream().filter(x->x>0).count();
        Long negative = arr.stream().filter(x->x<0).count();
        Long zero = count - positive - negative;


        System.out.println(format("%.5f",(double)positive/count ));
        System.out.println(format("%.5f",(double)negative/count ));
        System.out.println(format("%.5f",(double)zero/count ));



    }

    public static void main(String[] args) {
        List<Integer> arrs =Arrays.asList(new Integer[]{1,-1,0,-2,2,0,2});
        plusMinus(arrs);
    }


}
