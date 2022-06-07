package com.middleware.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @author: long
 * @create: 2022-05-31 13:59
 * @Description es配置文件
 **/

public class ElasticsearchConfigure extends AbstractElasticsearchConfiguration {

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private int port;

    @Value("${elasticsearch.https}")
    private String https;

    @Override
    public RestHighLevelClient elasticsearchClient() {
        RestClientBuilder clientBuilder = RestClient.builder(new HttpHost(host, port));
        RestHighLevelClient highLevelClient = new RestHighLevelClient(clientBuilder);
        return highLevelClient;
    }
}
