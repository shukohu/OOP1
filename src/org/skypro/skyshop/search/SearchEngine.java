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
}
