package com.example.cv6bonus.catalog;

import com.example.cv6bonus.document.Book;
import com.example.cv6bonus.document.Document;
import com.example.cv6bonus.document.Interview;
import com.example.cv6bonus.document.WebPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {
    static Catalog catalog;
    static Book book;
    static WebPage page;
    static Document document;
    static Interview interview;

    @BeforeAll
    static void setUp() {
        catalog = new Catalog();

        book = new Book(
                "Dášeňka čili život štěněte",
                "978-80-242-2614-9",
                "Knižní klub",
                "2009",
                80
        );

        page = new WebPage(
                "https://fis.vse.cz",
                "Fakulta informatiky a statistiky – Vysoká škola ekonomická v Praze",
                "Fakulta sdružuje katedry a studijní programy zabývající se informačními systémy a statistickými, ekonometrickými i dalšími matematickými metodami aplikovanými ve všech oblastech hospodářského života."
        );

        document = new Document(
                "198229-2/OAM-2022",
                "Rozhodnutí o udělení stipendia",
                "Dne 27.02.2023 Vám bylo uděleno stipendium."
        );

        interview = new Interview(
                "Karel Čapek",
                "Josef Čapek",
                "KČ: Dobrý den. JČ: Ahoj., ...",
                27
        );

        catalog.setStoredItem1(book);
        catalog.setStoredItem2(page);
        catalog.setStoredItem3(document);
        catalog.setStoredItem4(interview);
    }

    @Test
    void randomStringReturnsNoResults() {
        assert(catalog.find("sdagadagadfs").contains("Žádný záznam nevyhovuje..."));
    }

    @Test
    void findDoesNotReturnNull() {
        assertNotNull(catalog.find("život"));
    }

    @Test
    void findReturnsExpectedResult() {
        var expectedResult = new ArrayList<String>();
        expectedResult.add("Dášeňka čili život štěněte");
        expectedResult.add("Fakulta informatiky a statistiky – Vysoká škola ekonomická v Praze");

        assert(catalog.find("život").equals(expectedResult));
    }
}