package no.oslomet.oblig2_s315278;

import no.oslomet.oblig2_s315278.model.*;
import no.oslomet.oblig2_s315278.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;


@SpringBootApplication
public class Oblig2S315278Application implements CommandLineRunner {


    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ShippingService shippingService;

    public static void main(String[] args) {
        SpringApplication.run(Oblig2S315278Application.class, args);
    }

    @Override
    public void run(String... args) {

        authorService.addAuthor(new Author("Herman", "Melville", "10"));
        authorService.addAuthor(new Author("Raymond", "Chandler", "8"));
        authorService.addAuthor(new Author("Marta", "Breen", "7"));
        authorService.addAuthor(new Author("Jenny", "Jordahl", "8"));
        authorService.addAuthor(new Author("Jo", "Nesbø", "5"));
        authorService.addAuthor(new Author("Thomas", "Erikson", "7"));
        authorService.addAuthor(new Author("Are", "Brean", "6"));
        authorService.addAuthor(new Author("Geir Olve", "Skeie", "5"));
        authorService.addAuthor(new Author("Sumaya", "Jirde Ali", "9"));
        authorService.addAuthor(new Author("Chris", "Kraus", "8"));

        categoryService.addCategory(new Category("Fiction"));
        categoryService.addCategory(new Category("Non-fiction"));

        Book mobydick = new Book(9780393972832L, "Moby Dick", "1851", 4);
        mobydick.setCategory(categoryService.getCategory("Fiction"));
        mobydick.setAuthors(Collections.singletonList(authorService.getAuthor(1L)));

        Book bigsleep = new Book(9780241144497L, "The Big Sleep", "1939", 7);
        bigsleep.setCategory(categoryService.getCategory("Fiction"));
        bigsleep.setAuthors(Collections.singletonList(authorService.getAuthor(2L)));

        Book kvinnerikamp = new Book(9788202559410L, "Kvinner i kamp", "2018", 25);
        kvinnerikamp.setCategory(categoryService.getCategory("Non-fiction"));
        kvinnerikamp.setAuthors(Arrays.asList(authorService.getAuthor(3L), authorService.getAuthor(4L)));

        Book snomannen = new Book(9788203361876L, "Snømannen", "2017", 50);
        snomannen.setCategory(categoryService.getCategory("Fiction"));
        snomannen.setAuthors(Collections.singletonList(authorService.getAuthor(5L)));

        Book omgitt = new Book(9788205520127L, "Omgitt av idioter", "2018", 23);
        omgitt.setCategory(categoryService.getCategory("Non-fiction"));
        omgitt.setAuthors(Collections.singletonList(authorService.getAuthor(6L)));

        Book musikkhjernen = new Book(9788202569723L, "Musikk og hjernen", "2019", 32);
        musikkhjernen.setCategory(categoryService.getCategory("Non-fiction"));
        musikkhjernen.setAuthors(Arrays.asList(authorService.getAuthor(7L), authorService.getAuthor(8L)));

        Book kvinnersomhatermenn = new Book(9788293097426L, "Kvinner som hater menn", "2017", 20);
        kvinnersomhatermenn.setCategory(categoryService.getCategory("Fiction"));
        kvinnersomhatermenn.setAuthors(Collections.singletonList(authorService.getAuthor(9L)));

        Book ilovedick = new Book(9788203373336L, "I Love Dick", "2018", 12);
        ilovedick.setCategory(categoryService.getCategory("Fiction"));
        ilovedick.setAuthors(Collections.singletonList(authorService.getAuthor(10L)));

        bookService.addBook(mobydick);
        bookService.addBook(bigsleep);
        bookService.addBook(kvinnerikamp);
        bookService.addBook(snomannen);
        bookService.addBook(omgitt);
        bookService.addBook(musikkhjernen);
        bookService.addBook(kvinnersomhatermenn);
        bookService.addBook(ilovedick);

        shippingService.addShipping(new Shipping("Ole", "Hansen", "Pilestredet 35", "0132"));
    }
}
