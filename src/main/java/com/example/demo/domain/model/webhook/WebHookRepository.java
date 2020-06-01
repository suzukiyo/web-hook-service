package com.example.demo.domain.model.webhook;

public interface WebHookRepository {
    void send(WebHookItem ... webHookItems);
}
