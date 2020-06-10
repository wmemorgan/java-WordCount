package wordcount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String untext = "The eagle has landed, hello. The fat-man walks alone, hello. Nice to meet you, hello.";

        // Parse text
        String parsedText = untext.replaceAll("[[\\.\\?\\!\\,\\;\\:\\-\\{\\}\\(\\)\\']]", "").toUpperCase();
        // System.out.println("\nOriginal text: " + untext);

        // System.out.println("\nRemove punctuation: " + parsedText);

        String[] words = parsedText.split(" +");
        // System.out.println("\nSplit string into words: ");

        // Create and populate hashmap
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            int count = wordMap.containsKey(word) ? wordMap.get(word) : 0;
            wordMap.put(word, count + 1);
        }
        // System.out.println("\n wordMap: " + wordMap);

        // Sort hashmap
        // Convert hashmap to ArrayList
        List<HashMap.Entry> sortedWordMap = new ArrayList<>(wordMap.entrySet());
        sortedWordMap.sort(Comparator.comparing(o -> ((int)o.getValue()), Comparator.reverseOrder()));
        // System.out.println("\n*** Sorted Word List ***");
        // System.out.println(sortedWordMap);

        // Print contents of sorted hashmap
        int limit = sortedWordMap.size();
        System.out.println("\nTop " + limit + " words\n");
        for (HashMap.Entry mapElem : sortedWordMap) {
            System.out.println("Common Word <" + mapElem.getKey() + "> occurs " + mapElem.getValue() + " times");
        }
    }
}