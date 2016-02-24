package com.amaresh.examples.es;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * Created by apatta2 on 2/24/16.
 */

@RestController
public class IngestionDataService {

    @Autowired
    @Qualifier("esClient")
    private Client client;

    @Autowired
    @Qualifier("esTemplate")
    private ElasticsearchOperations esTemplate;

    //-------------------Retrieve Single Data--------------------------------------------------------

    @RequestMapping(value = "/ingestion/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getIngestionData(@PathVariable("id") String id) {

        StringQuery query = new StringQuery(id);
        System.out.println("Fetching Data with id " + id);
        GetResponse response = client.prepareGet("osmetrics-2016-02-24", "data", id)
                .execute()
                .actionGet();
        return response.getSourceAsString();
    }

}
