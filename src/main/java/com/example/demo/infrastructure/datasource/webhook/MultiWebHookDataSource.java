package com.example.demo.infrastructure.datasource.webhook;

import com.example.demo.domain.model.webhook.WebHookItem;
import com.example.demo.domain.model.webhook.WebHookRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository("multiWebHookRepository")
public class MultiWebHookDataSource implements WebHookRepository {

    WebHookRepository webHookRepository;
    MultiWebHookDataSource(@Qualifier("singleWebHookRepository") WebHookRepository webHookRepository) {
        this.webHookRepository = webHookRepository;
    }

    @Override
    public void send(WebHookItem... webHookItems) {
        Arrays.asList(webHookItems)
                .parallelStream()
                .forEach(value -> webHookRepository.send(value));
    }
}
