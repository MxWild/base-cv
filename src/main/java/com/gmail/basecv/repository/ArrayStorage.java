package com.gmail.basecv.repository;

import com.gmail.basecv.model.Resume;

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
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

}
