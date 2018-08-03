package com.journaldev.elasticsearch.controller;

import com.journaldev.elasticsearch.bean.Book;
import com.journaldev.elasticsearch.bean.Tour;
import com.journaldev.elasticsearch.dao.BookDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tours")
public class BookController {

    private BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @PostMapping
    public Tour insertBook(@RequestBody Tour tour) throws Exception {
        return bookDao.insertTour(tour);
    }

    @GetMapping("/{id}")
    public Map<String, Object> getBookById(@PathVariable String id) {
        return bookDao.getTourById(id);
    }

    //127.0.0.1:8080/tours?&minPrice=1300&maxPrice=5000
    @GetMapping()
    public   List<Map<String, Object>> getTourByPriceRange (@RequestParam(value = "minPrice", required = false)
                                                  final Integer minPrice,
                                                          @RequestParam(value = "maxPrice", required = false)  final Integer maxPrice,
                                                            @RequestParam(value = "city", required = false) final String city) {
        return bookDao.getTourByPriceRange(minPrice,maxPrice, city);
    }


    @PutMapping("/{id}")
    public Map<String, Object> updateBookById(@RequestBody Book book, @PathVariable String id) {
        return bookDao.updateTourById(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable String id) {
         bookDao.deleteBookById(id);
    }

}
