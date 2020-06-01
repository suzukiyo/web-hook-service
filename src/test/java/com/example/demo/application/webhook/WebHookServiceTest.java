package com.example.demo.application.webhook;

import com.example.demo.domain.fundamentals.url.Url;
import com.example.demo.domain.model.webhook.MultiWebHook;
import com.example.demo.domain.model.webhook.WebHookItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class WebHookServiceTest {

    @Autowired
    WebHookService webHookService;

    @Test
    public void 複数のWebHookを並列で非同期にできる() {
        WebHookItem webHookItem1 = new WebHookItem(
                new Url("http", "localhost:8080", "/test", "param=1"),
                "hogehoge", "0123456abcdefg", "fugafuga");

        WebHookItem webHookItem2 = new WebHookItem(
                new Url("http", "localhost:8080", "/test", "param=2"),
                "hogehoge", "0123456abcdefg", "fugafuga");

        WebHookItem webHookItem3 = new WebHookItem(
                new Url("http", "localhost:8080", "/test", "param=3"),
                "hogehoge", "0123456abcdefg", "fugafuga");

        MultiWebHook multiWebHook = new MultiWebHook(List.of(webHookItem1, webHookItem2, webHookItem3));
        webHookService.webHooks(multiWebHook);
    }
}
