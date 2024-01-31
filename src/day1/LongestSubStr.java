package day1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubStr {

    public int lengthOfLongestSubstring(String s) {


        HashMap<String , Integer> store = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for(int j= i+1 ; j<s.length();j++){
                if(! hasRepeatingCharacters(s.substring(i,j))){
                    store.put(s.substring(i,j),s.substring(i,j).length());
                }
            }
        }

        int longestVal = store.values().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        return longestVal;

    }

    private static boolean hasRepeatingCharacters(String str) {
        Set<Character> charSet = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (!charSet.add(c)) {
                // If the character is already in the set, it's a repeating character
                return true;
            }
        }

        // If no repeating character is found
        return false;
    }


}
