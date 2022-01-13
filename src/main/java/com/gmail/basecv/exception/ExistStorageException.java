package com.gmail.basecv.exception;

import static com.gmail.basecv.common.Constant.ALREADY_EXIST;
import static com.gmail.basecv.common.Constant.RESUME_WITH_UUID;

public class ExistStorageException extends StorageException {

    public ExistStorageException(String uuid) {
        super(RESUME_WITH_UUID + uuid + ALREADY_EXIST, uuid);
    }

}
