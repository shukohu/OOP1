package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        int lengthCompare = Integer.compare(o1.getSearchTerm().length(), o2.getSearchTerm().length());
        if (lengthCompare != 0) {
            return -lengthCompare;
        }
        return o1.getSearchTerm().compareTo(o2.getSearchTerm());
    }
}
