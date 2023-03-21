package com.example.cv6bonus.controller;


import com.example.cv6bonus.catalog.Catalog;
import com.example.cv6bonus.document.Book;
import com.example.cv6bonus.document.Document;
import com.example.cv6bonus.document.Interview;
import com.example.cv6bonus.document.WebPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        StringBuilder output = new StringBuilder();
        Catalog catalog = new Catalog();

        Book book = new Book(
                "Dášeňka čili život štěněte",
                "978-80-242-2614-9",
                "Knižní klub",
                "2009",
                80
        );

        WebPage page = new WebPage(
                "https://fis.vse.cz",
                "Fakulta informatiky a statistiky – Vysoká škola ekonomická v Praze",
                "Fakulta sdružuje katedry a studijní programy zabývající se informačními systémy a statistickými, ekonometrickými i dalšími matematickými metodami aplikovanými ve všech oblastech hospodářského života."
        );

        Document document = new Document(
                "198229-2/OAM-2022",
                "Rozhodnutí o udělení stipendia",
                "Dne 27.02.2023 Vám bylo uděleno stipendium."
        );

        Interview interview = new Interview(
                "Karel Čapek",
                "Josef Čapek",
                "KČ: Dobrý den. JČ: Ahoj., ...",
                27
        );

        catalog.setStoredItem1(book);
        catalog.setStoredItem2(page);
        catalog.setStoredItem3(document);
        catalog.setStoredItem4(interview);

        String all = catalog.printAll();

        output.append("Vypisuji vše:\n");
        output.append(all);

        String query = "život";
        String result = catalog.find(query);
        output.append("Vyhledávám výraz '").append(query).append("':\n");
        output.append(result);

        output.append(page.printContents());
        output.append(document.printContents());

        model.addAttribute("output", output.toString());
        return "home.html";
    }
}
