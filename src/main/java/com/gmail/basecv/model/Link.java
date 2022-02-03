package com.gmail.basecv.model;

import lombok.Data;

import java.util.Objects;

@Data
public class Link {

    private final String name;
    private final String url;

    public Link(String name, String url) {
        Objects.requireNonNull(name, "name must not be null");
        this.name = name;
        this.url = url;
    }
}
