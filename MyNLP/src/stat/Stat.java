/**
 * Program used to calculated statistics for given documents
 */
package stat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author Jiachen
 *
 */
public class Stat {

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * @param filePath
     *            (plain text)
     * @return tokenList
     * @throws IOException
     */
    public List<String> getTokens(String filePath) throws IOException {
        List<String> tokenList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath)));

        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.length() == 0) {
                continue;
            }

            String[] tokens = line.split("\\s+");
            for (int i = 0; i < tokens.length; i++) {
                tokens[i] = tokens[i].replaceAll("\\W", "").toLowerCase();
                if (tokens[i].length() > 0) {
                    tokenList.add(tokens[i]);
                }
            }
        }
        br.close();

        return tokenList;
    }

    /**
     * Get the statistics from the tokens
     * 
     * @param tokens
     * @return statMap
     */
    public HashMap<String, Float> getStats(List<String> tokens) {
        HashMap<String, Float> stat = new HashMap<>();

        HashMap<String, Integer> word_map = new HashMap<>();
        HashSet<String> word_set = new HashSet<>();
        HashMap<String, Integer> bigram_map = new HashMap<>();
        HashSet<String> bigram_set = new HashSet<>();

        int[] letterCount = new int[26];

        // # word & bigram
        for (int i = 0; i < tokens.size(); i++) {
            String word = tokens.get(i);

            if (!word_set.contains(word)) {
                word_set.add(word);
                word_map.put(word, 1);
            } else {
                word_map.put(word, word_map.get(word) + 1);
            }

            if (i != tokens.size() - 1) {
                String bigram = tokens.get(i) + " " + tokens.get(i + 1);
                if (!bigram_set.contains(bigram)) {
                    bigram_set.add(bigram);
                    bigram_map.put(bigram, 1);
                } else {
                    bigram_map.put(bigram, bigram_map.get(word) + 1);
                }
            }
        }

        return stat;
    }

}
