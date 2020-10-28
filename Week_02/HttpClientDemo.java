package com.shenge.study.week02;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author : Shi Yue Sheng
 * @date : 2020/10/28
 * @time : 5:38 PM
 */
public class HttpClientDemo {

    public static void main(String[] args) throws IOException {
        HttpGet httpGet = new HttpGet("http://localhost:8088/api/hello");
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            System.out.println(EntityUtils.toString(httpEntity));
        } finally {
            httpGet.releaseConnection();
        }
    }
}
