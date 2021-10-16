package com.gmail.basecv.model;

import lombok.Data;

@Data
public class Resume implements Comparable<Resume>{

    private String uuid;

    @Override
    public int compareTo(Resume o) {
        return uuid.compareTo(o.getUuid());
    }
}
