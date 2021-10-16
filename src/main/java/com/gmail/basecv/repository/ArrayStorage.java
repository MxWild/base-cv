package com.gmail.basecv.repository;

import com.gmail.basecv.model.Resume;

import java.util.Arrays;

import static com.gmail.basecv.common.Constants.RESUME_WITH_UUID;
import static com.gmail.basecv.common.Constants.STORAGE_LIMIT;

public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) != -1) {
            printMessage(RESUME_WITH_UUID + resume.getUuid() + " already exist");
        } else if (size == STORAGE_LIMIT) {
            printMessage("Storage overflow");
        } else {
            storage[size++] = resume;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            printMessage(RESUME_WITH_UUID + resume.getUuid() + " not exist");
        } else {
            storage[size++] = resume;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            printMessage("ERROR, resume not found");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

}
