package wordcount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String untext = "The eagle has landed. The fat-man walks alone.";

        // Parse text
        String parsedText = untext.replaceAll("[[\\.\\?\\!\\,\\;\\:\\-\\{\\}\\(\\)\\']]", "").toUpperCase();
        System.out.println("\nOriginal text: " + untext);

        System.out.println("\nRemove punctuation: " + parsedText);

        String[] words = parsedText.split(" +");
        System.out.println("\nSplit string into words: ");

        // Create and populate hashmap
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            int count = wordMap.containsKey(word) ? wordMap.get(word) : 0;
            wordMap.put(word, count + 1);
            System.out.println(word);
        }
        System.out.println("\n wordMap: " + wordMap);
    }
}