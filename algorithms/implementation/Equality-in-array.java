//question link https://www.hackerrank.com/challenges/equality-in-a-array

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner console = new Scanner(System.in);
        HashMap<Integer,Integer> numCount = new HashMap<>();
        int arraySize = console.nextInt();
        int maxCount = 0;
        for(int i=0; i< arraySize; i++){
            int number = console.nextInt();
            numCount.put(number, numCount.getOrDefault(number,0)+1);
            if(numCount.get(number) > numCount.getOrDefault(maxCount,0)){
                maxCount = number;
                
            }
        }
        int needToDelete= 0;
        for(Entry<Integer,Integer> arrNumbers : numCount.entrySet()){
            if(arrNumbers.getKey() == maxCount){
                continue;
            }
            needToDelete+= arrNumbers.getValue();
        }
        System.out.println(needToDelete);
    }
}