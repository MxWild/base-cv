package com.gmail.basecv.repository;

import com.gmail.basecv.model.Resume;

import java.util.Arrays;

import static com.gmail.basecv.common.Constant.RESUME_WITH_UUID;
import static com.gmail.basecv.common.Constant.STORAGE_LIMIT;

public abstract class AbstractArrayStorage implements Storage {

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            printMessage(RESUME_WITH_UUID + resume.getUuid() + " already exist");
        } else if (size == STORAGE_LIMIT) {
            printMessage("Storage overflow");
        } else {
            insertElement(resume, index);
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            printMessage(RESUME_WITH_UUID + uuid + " not found");
            return null;
        }
        return storage[index];
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            printMessage(RESUME_WITH_UUID + resume.getUuid() + " not exist");
        } else {
            storage[index] = resume;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            printMessage("ERROR, resume not found");
        } else {
            deleteElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void deleteElement(int index);

    protected abstract int getIndex(String uuid);

    protected void printMessage(String message) {
        System.out.println(message);
    }

}
