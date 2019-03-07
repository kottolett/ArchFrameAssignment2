package no.oslomet.oblig2_s315278.controller;

import no.oslomet.oblig2_s315278.model.*;
import no.oslomet.oblig2_s315278.search.Search;
import no.oslomet.oblig2_s315278.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@Controller
public class HomeController {

    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    OrderService orderService;
    @Autowired
    ShippingService shippingService;
    @Autowired
    private Search bookSearch;

    @GetMapping({"/", "/list"})
    public String showHome(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "index";
    }

    @GetMapping("/addBook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "addBook";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:/list";
    }

    @GetMapping("/addAuthor")
    public String addAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "addAuthor";
    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("author") Author author) {
        authorService.addAuthor(author);
        return "redirect:/addBook";
    }

    @GetMapping("/editBook/{isbn}")
    public String editBook(@PathVariable("isbn") String isbnParam, Model model) {
        Book book = bookService.getBook(Long.parseLong(isbnParam));
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "addBook";
    }

    @GetMapping("/deleteBook/{isbn}")
    public String deleteBook(@PathVariable("isbn") String isbnParam) {
        bookService.deleteBook(Long.parseLong(isbnParam));
        return "redirect:/list";
    }

    @GetMapping("/createCustomer")
    public String createCustomer(Model model) {
        model.addAttribute("shipping", new Shipping());
        return "createCustomer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("shipping") Shipping shipping) {
        shippingService.addShipping(shipping);
        return "redirect:/addOrder";
    }

    @GetMapping("/addOrder")
    public String addOrder(Model model) {
        model.addAttribute("order", new Orders());
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("shippings", shippingService.getAllShipping());
        model.addAttribute("books", bookService.getAllBooks());
        return "addOrder";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(@ModelAttribute("order") Orders order) {
        orderService.addOrder(order);
        bookService.buyBooks(order.getBooks());
        return "redirect:/seeOrders";
    }

    @GetMapping({"/seeOrders"})
    public String seeOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "seeOrders";
    }

    @RequestMapping("/search")
    public String search(String q, Model model) {
        List searchResults = null;
        try {
            searchResults = bookSearch.search(q);
        }
        catch (Exception ex) {

        }
        model.addAttribute("searchResults", searchResults);
        return "search";
    }
}
