package org.skypro.skyshop.search;

public interface Searchable {
    String getName();
    String getSearchTerm();
    String getContentType();

    default String getStringRepresentation() {
        return getSearchTerm() + "- тип " + getContentType();
    }
}

