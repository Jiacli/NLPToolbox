/**
 * Program used to calculated statistics for given documents
 */
package langStat;

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
public class langStat {

    /**
     * @param args
     */
    public static void main(String[] args) {
        

    }
    
    /**
     * @param filePath (plain text)
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
    
    /** Get the statistics from the tokens
     * 
     * @param tokenList
     * @return hashMap
     */
    public HashMap<String, Float> getStats(List<String> tokens) {
        HashMap<String, Float> map = new HashMap<>();
        
        HashSet<String> set = new HashSet<>();
        
        
        return map;
    }

}
