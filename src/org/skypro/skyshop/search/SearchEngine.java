package org.skypro.skyshop.search;

import org.skypro.skyshop.article.Article;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchableItems;

    public SearchEngine() {
        this.searchableItems = new HashSet<>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
    }

    public Set<Searchable> search(String term) {
        if (searchableItems == null) {
            return new TreeSet<>(new SearchableComparator());
        }
        Supplier<TreeSet<Searchable>> treeSetSupplier = () -> new TreeSet<>(new SearchableComparator());
        return searchableItems.stream().filter(item -> item.getSearchTerm().toLowerCase().contains(term.toLowerCase()) || (item instanceof Article && ((Article) item).getText().toLowerCase().contains(term.toLowerCase()))).
                collect(Collectors.toCollection(treeSetSupplier));
    }

    private static class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            int lengthCompare = Integer.compare(o1.getName().length(), o2.getName().length());
            if (lengthCompare != 0) {
                return -lengthCompare;
            }
            int nameCompare = o1.getName().compareTo(o2.getName());
            if (nameCompare != 0) {
                return nameCompare;
            }
            return Integer.compare(o1.hashCode(), o2.hashCode());
        }
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : searchableItems) {
            if (item != null) {
                int count = countOccurrences(item.getSearchTerm(), search);
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

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.toLowerCase().indexOf(substring.toLowerCase(), index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }

}

