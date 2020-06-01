package com.example.demo.domain.model.webhook;

import com.example.demo.domain.fundamentals.url.Url;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WebHookItem {
    Url url;
    String secretKey;

    String uid;
    String status;

    public String fullPath() {
        return url.fullPath();
    }
}
