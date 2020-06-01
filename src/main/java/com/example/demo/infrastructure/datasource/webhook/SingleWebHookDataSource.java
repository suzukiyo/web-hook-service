package com.example.demo.infrastructure.datasource.webhook;

import com.example.demo.domain.model.webhook.WebHookItem;
import com.example.demo.domain.model.webhook.WebHookRepository;
import com.example.demo.infrastructure.datasource.webhook.communication.WebHookRequest;
import com.example.demo.infrastructure.datasource.webhook.communication.WebHookResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository("singleWebHookRepository")
public class SingleWebHookDataSource implements WebHookRepository {

    static Logger logger = LoggerFactory.getLogger(SingleWebHookDataSource.class);

    RestTemplate restTemplate;
    SingleWebHookDataSource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Async
    @Override
    public void send(WebHookItem ... webHookItems) {
        WebHookItem webHookItem = webHookItems[0];

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            if (!webHookItem.getSecretKey().isEmpty()) {
                headers.set("Authorization", String.format("Bearer %s", webHookItem.getSecretKey()));
            }
            HttpEntity<Object> request = new HttpEntity<>(WebHookRequest.create(webHookItem), headers);
            logger.info("Request: " + request);
            WebHookResponse response = restTemplate.postForObject(webHookItem.fullPath(), request, WebHookResponse.class);
            logger.info("Response: " + response);
            logger.info("Success : {}", webHookItem.fullPath());
        } catch (Exception e) {
            logger.warn("Can't send web hooks: {}", webHookItem.fullPath());
        }
    }
}
