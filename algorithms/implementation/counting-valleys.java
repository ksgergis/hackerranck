//question link https://www.hackerrank.com/challenges/counting-valleys
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int numOfValleys = 0;
        int currentLevel =0;
        Scanner console = new Scanner(System.in);
        int stepsNum = console.nextInt();
        String steps = console.next();
        for(char step : steps.toCharArray()){
            if(step == 'U'){
                currentLevel++;
                if(currentLevel == 0){
                    numOfValleys++;
                }
            }else{
                currentLevel--;
            }
        }
        System.out.println(numOfValleys);
    }
}