package com.example.demo.domain.model.webhook;

public interface WebHook {
    WebHookItem toFirst();
    WebHookItem[] toArray();
}
