package org.skypro.skyshop.search;

public class SearchEngine {
    public final Searchable[] searchableItems;
    private int count;

    public SearchEngine(int size) {
        this.searchableItems = new Searchable[size];
        this.count = 0;
    }

    public void add(Searchable item) {
        if (count < searchableItems.length) {
            searchableItems[count] = item;
            count++;
        }
    }

    public Searchable[] search(String term) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (Searchable item : searchableItems) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                if (resultCount < 5) {
                    results[resultCount] = item;
                    resultCount++;
                } else {
                    break;
                }
            }
        }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : searchableItems) {
            if (item != null) {
                int count = countOccurences(item.getSearchTerm(), search);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = item;
                }
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящих результатов.");
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
