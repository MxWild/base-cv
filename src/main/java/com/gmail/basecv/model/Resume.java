package com.gmail.basecv.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Resume implements Comparable<Resume> {

    private final String uuid;

    public Resume() {
        this(UUID.randomUUID().toString());
    }

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public int compareTo(Resume o) {
        return uuid.compareTo(o.getUuid());
    }
}
