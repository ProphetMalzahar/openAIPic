package com.example.openAIPic.service.impl;

import com.example.openAIPic.service.PicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * Frenkie De Jong
 *
 * @projectName: openAIPic
 * @package: com.example.openAIPic.service.impl
 * @className: PicServiceImpl
 * @author: frenkie
 * @description: TODO
 * @date: 2023/3/31 23:31
 * @version: 1.0
 */
@Service
public class PicServiceImpl implements PicService {

    /**
     * openai url
     */
    private static final String OPEN_AI_URL = "https://api.openai.com/v1/images/generations";

    /**
     * 你的openai key
     */
    private static final String API_KEY = "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";


    @Override
    public String generateImages(String prompt, int num, String size) {
        RestTemplate restTemplate;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + API_KEY);
        // We are including only some of the parameters to the json request
        String requestJson = "{\"prompt\":\"" + prompt + "\",\"n\":" + num + "\",\"size\":" + size + "}";
        HttpEntity<String> request = new HttpEntity<>(requestJson, headers);
        //直接访问有问题需要走代理
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 7890));
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setProxy(proxy);
        restTemplate = new RestTemplate(requestFactory);
        ResponseEntity<String> response = restTemplate.postForEntity(OPEN_AI_URL, request, String.class);
        return response.getBody();
    }

}
