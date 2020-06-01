package com.example.demo.domain.fundamentals.url;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Url {
    String scheme;
    String domain;
    String directory;
    String parameters;

    public String fullPath() {
        return String.format("%s://%s%s?%s", scheme, domain, directory, parameters);
    }
}
