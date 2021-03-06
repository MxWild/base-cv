package com.gmail.basecv.exception;

import lombok.Getter;

@Getter
public class StorageException extends RuntimeException{

    private final String uuid;

    public StorageException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

}
