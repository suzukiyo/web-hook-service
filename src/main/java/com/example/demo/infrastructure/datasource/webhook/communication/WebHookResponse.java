package com.example.demo.infrastructure.datasource.webhook.communication;

import lombok.Data;

@Data
public class WebHookResponse {
    String status;
    String body;
}
