package wordcount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String untext = "The eagle has landed. The fat-man walks alone.";
        System.out.println("\nOriginal text: " + untext);

        System.out.println("\nRemove punctuation: " + untext.replaceAll("[[\\.\\?\\!\\,\\;\\:\\-\\{\\}\\(\\)\\']]", "").toUpperCase());
    }
}