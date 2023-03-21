package com.example.cv6bonus.catalog;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private Searchable storedItem1;
    private Searchable storedItem2;
    private Searchable storedItem3;
    private Searchable storedItem4;
    private static final Logger logger = LogManager.getLogger(Catalog.class);

    public Searchable getStoredItem1() {
        return storedItem1;
    }

    public void setStoredItem1(Searchable storedItem1) {
        this.storedItem1 = storedItem1;
    }

    public Searchable getStoredItem2() {
        return storedItem2;
    }

    public void setStoredItem2(Searchable storedItem2) {
        this.storedItem2 = storedItem2;
    }

    public Searchable getStoredItem3() {
        return storedItem3;
    }

    public void setStoredItem3(Searchable storedItem3) {
        this.storedItem3 = storedItem3;
    }

    public Searchable getStoredItem4() {
        return storedItem4;
    }

    public void setStoredItem4(Searchable storedItem4) {
        this.storedItem4 = storedItem4;
    }

    public List<String> printAll() {
        List<String> results = new ArrayList<>();

        if (storedItem1 != null) {
            results.add(storedItem1.getDisplayName());
        }

        if (storedItem2 != null) {
            results.add(storedItem2.getDisplayName());
        }

        if (storedItem3 != null) {
            results.add(storedItem3.getDisplayName());
        }

        if (storedItem4 != null) {
            results.add(storedItem4.getDisplayName());
        }

        if (results.isEmpty()) {
            results.add("Žádný záznam nevyhovuje...");
        }

        return results;
    }

    public List<String> find (String query) {
        List<String> results = new ArrayList<>();

        if (storedItem1.prepareSearchableString().contains(query)) {
            results.add(storedItem1.getDisplayName());
        }

        if (storedItem2.prepareSearchableString().contains(query)) {
            results.add(storedItem2.getDisplayName());
        }

        if (storedItem3.prepareSearchableString().contains(query)) {
            results.add(storedItem3.getDisplayName());
        }

        if (storedItem4.prepareSearchableString().contains(query)) {
            results.add(storedItem4.getDisplayName());
        }

        if (results.isEmpty()) {
            results.add("Žádný záznam nevyhovuje...");
        }

        return results;
    }
}
