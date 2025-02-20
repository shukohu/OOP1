package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private final Map<String, Searchable> searchableItems;

    public SearchEngine() {
        this.searchableItems = new HashMap<>();
    }

    public void add(Searchable item) {
        searchableItems.put(item.getName(), item);
    }

    public Map<String, Searchable> search(String term) {
        Map<String, Searchable> results = new TreeMap<>();

        for (Searchable item : searchableItems.values()) {
            if (item.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                results.put(item.getName(),item);
            }
        }

        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : searchableItems.values()) {
            if (item != null) {
                int count = countOccurences(item.getSearchTerm(), search);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = item;
                }
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящих результатов для запроса");
        }
        return bestMatch;
    }

    private int countOccurences(String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.toLowerCase().indexOf(substring.toLowerCase(), index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }

}

