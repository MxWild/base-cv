package com.gmail.basecv.model;

import lombok.Data;

import java.util.Objects;
import java.util.UUID;

@Data
public class Resume implements Comparable<Resume> {

    private final String uuid;

    private final String fullName;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    @Override
    public int compareTo(Resume o) {
        int compare = fullName.compareTo(o.getFullName());
        return compare != 0 ? compare : uuid.compareTo(o.getUuid());
    }
}
