package com.gmail.basecv.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Resume {

    private final String uuid;

    public Resume() {
        this(UUID.randomUUID().toString());
    }

    public Resume(String uuid) {
        this.uuid = uuid;
    }

}
