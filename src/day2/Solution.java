package day2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.function.*;

public class Solution {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {

        List<Integer> distance = new ArrayList<>();

        //find largest distance for a city and put it in distance. Do for each city
        for(int i=0 ; i<n ; i++){
            Integer dist = findLargestDistance(i,n,c);
            distance.add(dist);
            System.out.printf("Distance %s is %d %n",i,dist );
        }

        //return max of distance
        return Collections.max(distance);

    }

    private static Integer findLargestDistance(int i, int totalCities, int[] c ){
        List<Integer> stationIndices = Arrays.stream(c).boxed().collect(Collectors.toList());
        Integer distanceRight = 1;
        Integer distanceLeft = 1;

        if(isSpaceStation(i,stationIndices)){
            return 0;
        }

        int pointer=i;
        while(!isSpaceStation(++pointer , stationIndices)){
            if(pointer >= totalCities-1){
                distanceRight = 0;
                break;
            }
            distanceRight++;
        }

        //ResetPointer
        pointer = i;
        while(!isSpaceStation(--pointer , stationIndices)){
            if(pointer <= 0){
                distanceLeft = 0;
                break;
            }
            distanceLeft++;
        }

        Integer distance =0;
        if(distanceRight.equals(0)){
            distance = distanceLeft;
        }
        else if(distanceLeft.equals(0)){
            distance = distanceRight;
        }else {
            distance = Math.min(distanceRight, distanceLeft);

        }
        System.out.printf( "  %s  distanceLeft=%s distanceRight=%s distance=%s %n",i,distanceLeft,distanceRight,distance );
        return distance;
    }

    private static Boolean isSpaceStation(int pointer , List<Integer> stationIndices){
        return stationIndices.contains(pointer);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] c = new int[]{13,1,11,10,6};
        System.out.println(flatlandSpaceStations(20,c));
    }
}
