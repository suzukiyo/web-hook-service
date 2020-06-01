package com.example.demo.infrastructure.datasource.webhook.communication;

import com.example.demo.domain.model.webhook.WebHookItem;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WebHookRequest {
    String uid;
    String status;

    public static WebHookRequest create(WebHookItem webHookItem) {
        return new WebHookRequest(webHookItem.getUid(), webHookItem.getStatus());
    }
}
