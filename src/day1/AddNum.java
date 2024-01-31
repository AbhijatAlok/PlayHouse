package day1;


import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AddNum {

    public static void main(String[] args) {
        System.out.println(1+1);
        System.out.println( frontTimes("Chocolate", 2));

        Map<String, String> a = new HashMap<>(){{
            put("a","candy");
            put("b", "dirt");
        }};

        mapBully(a);
        System.out.println(a);

        //linearIn(new int[]{1, 2, 4, 6}, new int[]{2, 4});
        System.out.println(wordAppend(new String[]{"a", "b", "a", "c", "a", "d", "a"}));
    }

    public static String wordAppend(String[] strings) {

        Set<String> tracker = new HashSet<>();
        String result = "";

        for (String string : strings) {
            if(tracker.contains(string)){
                result+= string;
                tracker.remove(string);
            }else{
                tracker.add(string);
            }
        }
    return result;
    }

    public List<Integer> rightDigit(List<Integer> nums) {
        return nums.stream().map(x->x%10).collect(Collectors.toList());

    }

    public List<String> noYY(List<String> strings) {

        return strings.stream().map(x->x+"y").filter(x-> !x.contains("yy")).collect(Collectors.toList());
    }


    public List<String> addStar(List<String> strings) {
        strings.replaceAll(x-> {return x+'*';});
        return strings;
    }


    public static boolean linearIn(int[] outer, int[] inner) {

        int found = 0;

        for (int innerNum : inner) {

            int i1 = 0;
            for (int j = i1; j < outer.length; j++) {
                int outerNum = outer[j];
                if (innerNum != outerNum) {
                    continue;
                } else {
                    i1 = j;
                    found++;
                    break;
                }
            }
        }
        return found == inner.length;
    }


    @Test
public void testLast2(){
    assertEquals(2, last2("xxxx"));
    assertEquals(1, last2("xaxxaxaxx"));
    assertEquals(2, last2("axxxaaxx"));
}

@Test
public void testFP(){
        assertArrayEquals(new int[] {1, 2},frontPiece(new int[] {1, 2, 3}) );
        assertArrayEquals(new int[] {1, 2},frontPiece(new int[] {1, 2}) );
        assertArrayEquals(new int[] {1},frontPiece(new int[] {1}) );
}

    public int[] frontPiece(int[] nums) {

        int itemCount = Math.min(nums.length , 2);
        int[] returnArr = new int[itemCount];

        for (int i = 0; i < itemCount; i++) {
            returnArr[i] = nums[i];
        }
        return returnArr;
    }

    public boolean scoresIncreasing(int[] scores) {
        for (int i = 0; i < scores.length -1; i++) {
            if (scores[i] > scores[i+1]){
                return false;
            }
        }
        return true;
    }


    public static Map<String, String> mapBully(Map<String, String> map) {
        if(map.containsKey("a")){
            map.put("b",map.get("a"));
            map.put("a","");
        }
        return map;
    }



    public int last2(String str) {

        if(str.length() < 2) return 0;

        String lastTwo = str.substring(str.length()-2);
        int counter = 0;

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length-2; i++) {
            String twoChars = String.valueOf(chars[i])+String.valueOf(chars[i+1]);
            if(twoChars.equals(lastTwo)) counter++;
        }

        return counter;
    }


    public String delDel(String str) {

        if(str.startsWith("del", 1)){
            return str.charAt(0) + str.substring(5);
        } else
            return str ;
    }

    public String everyNth(String str, int n) {

        char[] charArray = str.toCharArray();
       String result = "";//= String.valueOf(charArray[0]);

        for (int i = 0; i < charArray.length; i+=n) {
            result = result.concat(String.valueOf(charArray[i]));
        }
        return result;
    }

    public String endUp(String str) {
        if(str.length() <= 3)
            return str.toUpperCase() ;
        else
            return str.substring(0,str.length()-3) + str.substring(str.length()-3).toUpperCase();
    }

    public String stringX(String str) {
        if(str.length() <= 2)
              return str;

        return str.charAt(0) + str.substring(1,str.length()-1).replace("x","") + str.charAt(str.length()-1);
    }

    public static String frontTimes(String str, int n) {

        int lastIndex = Math.min(str.length(), 3);

        StringBuilder result= new StringBuilder();
        result.append(str.substring(0, lastIndex).repeat(Math.max(0, n)));
        return result.toString();
    }

    public int scoresAverage(int[] scores) {

        int avg1 = average(scores,0,scores.length/2 -1);
        int avg2 = average(scores,scores.length/2  , scores.length-1);
        return Math.max(avg1,avg2);
    }

    private int average(int[] scores, int start, int end) {
        int sum =0;
        for (int i = start; i <= end ; i++) {
            sum+= scores[i];
        }
        return sum / ((end -start)+1 );
    }

    public String[] mergeTwo(String[] a, String[] b, int n) {

        int pointerA = 0;
        int pointerB = 0;

        String[] returnArr = new String[n];

        for(int i=0 ; i< n ; i++){

            if(a[pointerA].compareTo(b[pointerB]) > 0){
                returnArr[i] = a[pointerA] ;
                pointerA++;
            }else if(a[pointerA].compareTo(b[pointerB]) < 0){
                returnArr[i] = b[pointerB] ;
                pointerB++;
            }else{
                returnArr[i] = a[pointerA] ;
                pointerA++;
                pointerB++;
            }
        }
        return returnArr;
    }


    public boolean startHi(String str) {
    if(str.startsWith("hi")) return true;

    return false;
    }



    }

