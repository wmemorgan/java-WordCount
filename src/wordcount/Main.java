package wordcount;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Import text from file
        String path = System.getProperty("user.dir");
        String content = new String(Files.readAllBytes(Paths.get(path + "/text.txt")));

        // Parse and split text
        String parsedText = content.replaceAll("[[\\.\\?\\!\\,\\;\\:\\-\\{\\}\\(\\)\\']]", "").toUpperCase();
        String[] words = parsedText.split(" +");

        // Create and populate hashmap
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            int count = wordMap.containsKey(word) ? wordMap.get(word) : 0;
            wordMap.put(word, count + 1);
        }

        // Sort hashmap
        // Convert hashmap to ArrayList
        // Sort by word frequency in descending order
        List<HashMap.Entry> sortedWordMap = new ArrayList<>(wordMap.entrySet());
        sortedWordMap.sort(Comparator.comparing(o -> ((int) o.getValue()), Comparator.reverseOrder()));
        // Sort alphabetically
        List<HashMap.Entry> alphaSortWordMap = new ArrayList<>(wordMap.entrySet());
        alphaSortWordMap.sort(Comparator.comparing(o -> ((String) o.getKey())));
        

        // Print contents of sorted hashmap
        int limit = 50;
        int count = 1;
        // Print by word frequency
        System.out.println("\nTop " + limit + " words\n");
        for (HashMap.Entry mapElem : sortedWordMap) {
            if (count > limit)
                break;
            System.out.println("Common Word <" + mapElem.getKey() + "> occurs " + mapElem.getValue() + " times");
            count++;
        }
        // Print alphabetically
        System.out.println("\n*** Sorted Alphabetically ***");
        count = 1;
        for (HashMap.Entry mapElem : alphaSortWordMap) {
            if (count > limit) break;
            System.out.println("Common Word <" + mapElem.getKey() + "> occurs " + mapElem.getValue() + " times");
            count++;
        }
    }
}