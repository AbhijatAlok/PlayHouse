package day1;

import java.util.Stack;
import java.util.stream.Collectors;
public class Backspace {

    public boolean backspaceCompare(String s, String t) {
        return clean(s).equals(clean(t));
    }

    private String clean(String str){
        Stack<Character> result = new Stack<Character>();

        for(char c: str.toCharArray()){
            if( c != '#'){
                result.push(c);
            }else if(!result.empty()){
                result.pop();
            }
        }

        return result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}
