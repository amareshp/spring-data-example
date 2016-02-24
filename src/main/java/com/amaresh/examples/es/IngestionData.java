package com.amaresh.examples.es;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.Id;

/**
 * Created by apatta2 on 2/24/16.
 */
@Document(indexName = "my-index", type = "my-type")
public class IngestionData {

    @Id
    private String id;

    private String hostname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
}
