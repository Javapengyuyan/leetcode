package com.middleware.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: long
 * @create: 2022-05-31 13:59
 * @Description es配置文件
 **/
@Configuration
public class ElasticsearchConfigure {

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private int port;

    @Value("${elasticsearch.https}")
    private String https;

    @Bean
    public RestHighLevelClient client(){

        String[] split = host.split(",");
        HttpHost[] hosts = new HttpHost[split.length];
        for (int i = 0; i < split.length; i++) {
            hosts[i] = new HttpHost(split[i], port, https);
        }


        return new RestHighLevelClient(RestClient.builder(hosts));
    }

}
