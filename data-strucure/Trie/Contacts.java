import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the contacts function below.
     */
    static int[] contacts(String[][] queries) {
     	ArrayList<Integer > results= new ArrayList<>();	
		Dict dict = new Dict();
		for(int i=0; i< queries.length; i++){
			String command = queries[i][0];
			String word = queries[i][1];
			if(command.equals("add")) {
				addToDict(word, dict);
			}else {
				results.add(getCount(word,dict));
			}
		}
        return results.stream().mapToInt(i->i).toArray();
    }
    
    private static int getCount(String word, Dict dict) {
		for(char ch : word.toCharArray()) {
			if(dict.children[ch - 'a'] == null) {
				return 0;
			}
			dict  = dict.children[ch - 'a'];
		}
		return dict.numOfWords;
	}

	private static void addToDict(String word, Dict dict) {
		for(char ch : word.toCharArray()) {
				if(dict.children[ch-'a'] == null) {
					dict.children[ch-'a'] = new Dict();
				}
				dict.numOfWords++;
				dict = dict.children[ch-'a'];
		}
		dict.numOfWords++;
		
	}
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

class Dict{
	Dict[] children = new Dict[26];
	int numOfWords;
}