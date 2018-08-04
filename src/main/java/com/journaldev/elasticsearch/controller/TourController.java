package com.journaldev.elasticsearch.controller;

import com.journaldev.elasticsearch.bean.Book;
import com.journaldev.elasticsearch.bean.Tour;
import com.journaldev.elasticsearch.dao.TourDao;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tours")
public class TourController {

    private TourDao tourDao;

    public TourController(TourDao bookDao) {
        this.tourDao = bookDao;
    }

    @PostMapping
    public Tour insertTour(@RequestBody Tour tour) throws Exception {
        return tourDao.insertTour(tour);
    }

    @GetMapping("/{id}")
    public Map<String, Object> getBookById(@PathVariable String id) {
        return tourDao.getTourById(id);
    }


     //127.0.0.1:8080/tours?&minPrice=1300&maxPrice=5000
    @GetMapping()
    public   List<Map<String, Object>> search(@RequestParam(value = "from", required = false)
                                              @DateTimeFormat(pattern = "yyyy-MM-dd")final java.time.LocalDate departureDateFrom,
                                              @RequestParam(value = "to", required = false)

                                              @DateTimeFormat(pattern = "yyyy-MM-dd")final java.time.LocalDate departureDateTo,
                                              @RequestParam(value = "hotelName", required = false) final String hotelName,

                                              @RequestParam(value = "nights", required = false)  final  int nights,
                                              @RequestParam(value = "people", required = false) final int people,
                                              @RequestParam(value = "city", required = false) final String departureCity ) {

        return tourDao.searchDao(departureDateFrom,departureDateTo, hotelName,nights,people, departureCity);
    }


    @PutMapping("/{id}")
    public Map<String, Object> updateBookById(@RequestBody Book book, @PathVariable String id) {
        return tourDao.updateTourById(id, book);
    }

    @DeleteMapping("/{id}")
    public void removeTour(@PathVariable String id) {
         tourDao.removeTour(id);
    }

}
