package com.middleware.es;

import org.elasticsearch.client.indices.CreateIndexRequest;
import org.junit.Test;

/**
 * @author: long
 * @create: 2022-06-06 15:30
 * @Description
 **/

public class ESDemo {

    @Test
    public void createIndex(){
        String index = "index_test";
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(index);


    }

}
