//question link https://www.hackerrank.com/challenges/permutation-equation

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
       /* Enter your code here. Read input from STDIN. Print output to STDOUT */
       HashMap<Integer, Integer> seq = new HashMap<Integer, Integer>();
       Scanner console = new Scanner(System.in);
       int seqLength = console.nextInt();
       for(int i=1; i<= seqLength; i++){
           seq.put(console.nextInt(),i);
       }
       for(int x=1; x<=seqLength;x++){
           System.out.println(seq.get(seq.get(x)));
       }
    }
}
