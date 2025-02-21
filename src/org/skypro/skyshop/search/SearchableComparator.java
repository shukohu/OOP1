package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        int lengthComparison = Integer.compare(o1.getSearchTerm().length(), o2.getSearchTerm().length());
        if (lengthComparison != 0) {
            return -lengthComparison;
        }
        return o1.getSearchTerm().compareTo(o2.getSearchTerm());
    }
}
