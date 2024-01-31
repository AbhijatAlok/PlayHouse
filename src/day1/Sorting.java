package day1;

import java.util.*;

import static java.util.Collections.rotate;

public class Sorting {

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("Geeks For Geeks");
        al.add("Friends");
        al.add("Dear");
        al.add("Is");
        al.add("Superb");

        //Collections.sort(al, myComparator);
        System.out.println( al);


//        String[] s = {"a","b","d","c","b"};
//        List<String> sL = Arrays.asList(s);

        System.out.println(mySort(al));

        List<Integer> ll = List.of(1,2,3,4,5);
        rotLeft(ll,3);

        System.out.println(sum35(100));

    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        List<Integer> ll = new LinkedList<>(a);
        for (int i = 0; i < d; i++) {
            Integer j = ll.remove(0);
            ll.add(a.size()-1,j);

        }
        return ll;
    }

    public static Integer sum35(Integer num){
        int sum=0;

        for (int i = 1; i < num; i++) {
            if(i%3==0 || i%5==0){
                sum+=i;
            }
        }
        return sum;
    }



    private static List<String> mySort(ArrayList<String> al) {


        for (int i = 0; i < al.size(); i++) {

            for (int i1 = i ; i1 < al.size(); i1++) {

                if(al.get(i).compareTo(al.get(i1)) < 0){
                    String temp = al.get(i);
                    al.set(i,al.get(i1));
                    al.set(i1,temp);
                }
            }
        }
        return al;
    }


}
