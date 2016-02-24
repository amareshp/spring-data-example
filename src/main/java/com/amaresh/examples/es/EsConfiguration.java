package com.amaresh.examples.es;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import javax.annotation.Resource;

/**
 * Created by apatta2 on 2/24/16.
 */

@Configuration
@EntityScan(basePackages = {"com.amaresh.examples.es"})
//@PropertySource(value = "classpath:elasticsearch.properties")
@EnableElasticsearchRepositories(basePackages = "com.amaresh.examples.es")
public class EsConfiguration {
    //@Resource
    //private Environment environment;
    //environment.getProperty("elasticsearch.host")
    private Client client;

    @Bean(name = "esClient")
    public Client client() {
        Settings settings = ImmutableSettings.settingsBuilder()
                .put("cluster.name", "os-metrics-elk").build();
        // on startup
        client =    new TransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress("10.65.225.235", 9300))
                .addTransportAddress(new InetSocketTransportAddress("10.65.96.202", 9300));
        return client;
    }

    public void shutdown() {
        client.close();
    }

    @Bean(name = "esTemplate")
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }
}
