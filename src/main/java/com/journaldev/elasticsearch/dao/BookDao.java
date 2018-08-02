package com.journaldev.elasticsearch.dao;

import com.journaldev.elasticsearch.bean.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.journaldev.elasticsearch.bean.Tour;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookDao {

    private final String INDEX = "bookdata";
    private final String TYPE = "books";

    private final String INDEXTOUR = "tourdata";
    private final String TYPETOUR = "tours";


    private RestHighLevelClient restHighLevelClient;

    private ObjectMapper objectMapper;

    public BookDao( ObjectMapper objectMapper, RestHighLevelClient restHighLevelClient) {
        this.objectMapper = objectMapper;
        this.restHighLevelClient = restHighLevelClient;
    }


    public Tour insertTour(Tour tour) {
        tour.setId(UUID.randomUUID().toString());
        Map<String, Object> dataMap = objectMapper.convertValue(tour, Map.class);

        IndexRequest indexRequest = new IndexRequest(INDEXTOUR, TYPETOUR, tour.getId())
                .source(dataMap);
        try {
            IndexResponse response = restHighLevelClient.index(indexRequest);
        } catch(ElasticsearchException e) {
            e.getDetailedMessage();
        } catch (java.io.IOException ex){
            ex.getLocalizedMessage();
        }

        return tour;
    }


    public Map<String, Object> getTourById(String id){
        GetRequest getRequest = new GetRequest(INDEXTOUR, TYPETOUR, id);
        GetResponse getResponse = null;
        try {
            getResponse = restHighLevelClient.get(getRequest);
        } catch (java.io.IOException e){
            e.printStackTrace();
            e.getLocalizedMessage();
        }
        Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
        return sourceAsMap;
    }

    /**
     * Search per price range
     * @param minPrice
     * @param maxPrice
     * @return
     */
    public  List<Map<String, Object>> getTourByPriceRange(int minPrice, int maxPrice) {
        List<Map<String, Object>> search = new ArrayList<>();

                QueryBuilder qb = QueryBuilders
                .rangeQuery("price")
                .from(minPrice)
                .to(maxPrice)
                .includeLower(true)
                .includeUpper(true);

        SearchRequest searchRequest = new SearchRequest(INDEXTOUR);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(qb);
        searchRequest.types(TYPETOUR);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = null;
        try {
            searchResponse = restHighLevelClient.search(searchRequest);
        } catch (java.io.IOException e) {
            e.printStackTrace();
            e.getLocalizedMessage();
        }
        SearchHits hits = searchResponse.getHits();
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            search.add(sourceAsMap);
        }
        return search;
    }



    public Map<String, Object> updateTourById(String id, Book book) {
        UpdateRequest updateRequest = new UpdateRequest(INDEXTOUR, TYPETOUR, id)
                .fetchSource(true);    // Fetch Object after its update
        Map<String, Object> error = new HashMap<>();
        error.put("Error", "Unable to update book");
        try {
            String bookJson = objectMapper.writeValueAsString(book);
            updateRequest.doc(bookJson, XContentType.JSON);
            UpdateResponse updateResponse = restHighLevelClient.update(updateRequest);
            Map<String, Object> sourceAsMap = updateResponse.getGetResult().sourceAsMap();
            return sourceAsMap;
        }catch (JsonProcessingException e){
            e.getMessage();
        } catch (java.io.IOException e){
            e.getLocalizedMessage();
        }
        return error;
    }

    public void deleteBookById(String id) {
        DeleteRequest deleteRequest = new DeleteRequest(INDEXTOUR, TYPETOUR, id);
        try {
            DeleteResponse deleteResponse = restHighLevelClient.delete(deleteRequest);
        } catch (java.io.IOException e) {
            e.getLocalizedMessage();
        }
    }
//    public  List<Map<String, Object>> ff(int minPrice, int maxPrice) {
//        List<Map<String, Object>> search = null;
//
//        QueryBuilder qb = QueryBuilders
//                .rangeQuery("price")
//                .from(minPrice)
//                .to(maxPrice)
//                .includeLower(true)
//                .includeUpper(true);
//
//        SearchRequest searchRequest = new SearchRequest(INDEXTOUR);
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(qb);
//        searchRequest.types(TYPETOUR);
//        searchRequest.source(searchSourceBuilder);
//
//        SearchResponse searchResponse = null;
//        try {
//            searchResponse = restHighLevelClient.search(searchRequest);
//        } catch (java.io.IOException e) {
//            e.printStackTrace();
//            e.getLocalizedMessage();
//        }
//        SearchHits hits = searchResponse.getHits();
//        SearchHit[] searchHits = hits.getHits();
//        for (SearchHit hit : searchHits) {
//             search = (List<Map<String, Object>>) hit.getSourceAsMap();
//        }
//        return search;
//    }

}
