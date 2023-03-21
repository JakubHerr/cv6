package com.example.cv6bonus.catalog;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    public String printAll() {
        String result = "";

        if (storedItem1 != null) {
            result += " - " + storedItem1.getDisplayName() + "\n";
        }

        if (storedItem2 != null) {
            result += " - " + storedItem2.getDisplayName() + "\n";
        }

        if (storedItem3 != null) {
            result += " - " + storedItem3.getDisplayName() + "\n";
        }

        if (storedItem4 != null) {
            result += " - " + storedItem4.getDisplayName() + "\n";
        }

        if (result.isEmpty()) {
            result = "Žádný záznam nevyhovuje...";
        }

        return result;
    }

    public String find (String query) {
        String result = "";

        if (storedItem1.prepareSearchableString().contains(query)) {
            result += " - " + storedItem1.getDisplayName() + "\n";
        }

        if (storedItem2.prepareSearchableString().contains(query)) {
            result += " - " + storedItem2.getDisplayName() + "\n";
        }

        if (storedItem3.prepareSearchableString().contains(query)) {
            result += " - " + storedItem3.getDisplayName() + "\n";
        }

        if (storedItem4.prepareSearchableString().contains(query)) {
            result += " - " + storedItem4.getDisplayName() + "\n";
        }

        if (result.isEmpty()) {
            result = "Žádný záznam nevyhovuje...";
        }

        logger.info("Searched catalog for query: " + query);
        return result;
    }
}
