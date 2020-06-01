package com.example.demo.application.webhook;

import com.example.demo.domain.model.webhook.MultiWebHook;
import com.example.demo.domain.model.webhook.WebHookRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WebHookService {

    WebHookRepository webHookRepository;
    WebHookService(@Qualifier("multiWebHookRepository") WebHookRepository webHookRepository) {
        this.webHookRepository = webHookRepository;
    }

    public void webHooks(MultiWebHook multiWebHook) {
        webHookRepository.send(multiWebHook.toArray());
    }

}
