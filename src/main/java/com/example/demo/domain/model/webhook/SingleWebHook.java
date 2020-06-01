package com.example.demo.domain.model.webhook;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SingleWebHook implements WebHook {
    WebHookItem item;

    @Override
    public WebHookItem toFirst() {
        return item;
    }

    @Override
    public WebHookItem[] toArray() {
        return new WebHookItem[]{ item };
    }
}
