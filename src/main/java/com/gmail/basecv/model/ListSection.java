package com.gmail.basecv.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = false)
public class ListSection extends Section {

    private final List<String> items;

    public ListSection(List<String> items) {
        Objects.requireNonNull(items, "items must not be null");
        this.items = items;
    }
}
