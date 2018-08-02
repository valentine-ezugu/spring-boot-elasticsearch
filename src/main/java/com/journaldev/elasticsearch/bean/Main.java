package com.journaldev.elasticsearch.bean;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class Main {

    private final String INDEX = "bookdata";
    private final String TYPE = "books";

    private RestHighLevelClient restHighLevelClient;

    private ObjectMapper objectMapper;

    public Main(ObjectMapper objectMapper, RestHighLevelClient restHighLevelClient) {
        this.objectMapper = objectMapper;
        this.restHighLevelClient = restHighLevelClient;
    }


    public static void main(String[] args) throws IOException {

    }

    public Tour insertTour(Tour tour){
        tour.setId(UUID.randomUUID().toString());
        Map<String, Object> dataMap = objectMapper.convertValue(tour, Map.class);

        IndexRequest indexRequest = new IndexRequest(INDEX, TYPE, tour.getId())
                .source(dataMap);
        try {
            IndexResponse response = restHighLevelClient.index(indexRequest);
        } catch(ElasticsearchException e) {
            e.getDetailedMessage();
        } catch (IOException ex){
            ex.getLocalizedMessage();
        }
        return tour;
    }


}
