package day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4));
        a.add(5);
        callFunc(a);
        System.out.println(a.toString());
    }

    private static void callFunc(List<Integer> a) {
        a.add(6);
    }

}
