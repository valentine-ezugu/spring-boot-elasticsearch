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
    public List<Tour> insertTour(@RequestBody List<Tour> tours) throws Exception {

        for(Tour tour :  tours){
              tourDao.insertTour(tour);
        }
        return tours;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getBookById(@PathVariable String id) {
        return tourDao.getTourById(id);
    }


    //127.0.0.1:9200/tourdata/tours/_search?size=7000&pretty=true
    @GetMapping()
    public   List<Tour>  search(@RequestParam(value = "from", required = false)
                                              @DateTimeFormat(pattern = "MMM d, yyyy hh:mm:ss a")final java.time.LocalDateTime departureDateFrom,
                                              @RequestParam(value = "to", required = false)

                                              @DateTimeFormat(pattern = "MMM d, yyyy hh:mm:ss a")final java.time.LocalDateTime departureDateTo,
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
