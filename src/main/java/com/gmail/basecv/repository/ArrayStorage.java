package com.gmail.basecv.repository;

import com.gmail.basecv.model.Resume;
import com.gmail.basecv.repository.general.AbstractArrayStorage;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume resume, int index) {
        storage[size] = resume;
    }

    @Override
    protected void deleteElement(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

}
