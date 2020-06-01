package com.example.demo.domain.model.webhook;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MultiWebHook implements WebHook {
    List<WebHookItem> values;

    @Override
    public WebHookItem toFirst() {
        return values.get(0);
    }

    @Override
    public WebHookItem[] toArray() {
        return values.toArray(new WebHookItem[0]);
    }
}
