package com.gmail.basecv.exception;

import static com.gmail.basecv.common.Constant.RESUME_WITH_UUID;

public class NotExistStorageException extends StorageException {

    public NotExistStorageException(String uuid) {
        super(RESUME_WITH_UUID + uuid + " not exist", uuid);
    }
}
