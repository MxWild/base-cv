package com.gmail.basecv.repository;

import com.gmail.basecv.model.Resume;

import static com.gmail.basecv.common.Constants.RESUME_WITH_UUID;
import static com.gmail.basecv.common.Constants.STORAGE_LIMIT;

public abstract class AbstractArrayStorage implements Storage {

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            printMessage(RESUME_WITH_UUID + uuid + " not found");
            return null;
        }
        return storage[index];
    }

    public int size() {
        return size;
    }

    protected abstract int getIndex(String uuid);

    protected void printMessage(String message) {
        System.out.println(message);
    }

}
