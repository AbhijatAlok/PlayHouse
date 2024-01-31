package streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class MapPlay {

    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Key1", 10);
        hashMap.put("Key2", 5);
        hashMap.put("Key3", 20);
        hashMap.put("Key", 320);
        hashMap.put("Key4", 15);
        hashMap.put("Key5", 20);


        //find largest key
        hashMap.keySet().stream().max(CharSequence::compare).ifPresent(System.out::println);

        //find largest value
        hashMap.values().stream().reduce(Integer::max).ifPresent(System.out::println);

        //generate Map incrementing values by 2 and filtering value > 20 and fin the min key for the condition
        Map<String, Integer> m = hashMap.entrySet().stream().map(kv->Map.entry(kv.getKey(),kv.getValue()+2)).filter(x->x.getValue()>20).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        m.keySet().stream().min(String::compareTo).ifPresent(System.out::println);

        hashMap.entrySet().stream().map(kv->new AbstractMap.SimpleEntry<>(kv.getKey(), kv.getValue() + 2)).filter(kv->kv.getValue()>20).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue)).keySet().stream().min(String::compareTo).ifPresent(System.out::println);


        //find key for smallest value

        hashMap.entrySet().stream().min(Map.Entry.comparingByValue()).ifPresent(entry -> System.out.println(entry.getKey()));

        //List all the values as list
        hashMap.values().stream().filter(x->x>20).toList().forEach(System.out::println);

        //List all the 'key+values' as Set
        hashMap.entrySet().stream().map(entry->new AbstractMap.SimpleEntry<>(entry.getKey(),entry.getKey()+entry.getValue())).collect(Collectors.toSet()).forEach(kv->System.out.println(kv.getValue()));

        //find set of keys
        hashMap.keySet().forEach(System.out::println);

        //find set of values
        hashMap.values().forEach(System.out::println);

        //convert Array to Arraylist
        String[] arr = new String[]{"a","b","c","d"};
        Arrays.stream(arr).toList().forEach(System.out::println);


    }


}