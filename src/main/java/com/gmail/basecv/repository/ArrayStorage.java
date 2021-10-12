package com.gmail.basecv.repository;

import com.gmail.basecv.model.Resume;

public class ArrayStorage {

    private final Resume[] storage = new Resume[10000];
    private int size = 0;

    public void save(Resume resume) {
        if (size == 0 || get(resume.getUuid()) == null) {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (isResumeExist(uuid, storage[i])) {
                return storage[i];
            }
        }
        return null;
    }

    public Resume[] getAll() {
        Resume[] all = new Resume[size];
        if (size >= 0) {
            System.arraycopy(storage, 0, all, 0, size);
        }
        return all;
    }

    public void update(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (isResumeExist(resume.getUuid(), storage[i])) {
                storage[i] = resume;
                break;
            }
        }
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (isResumeExist(uuid, storage[i])) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
            }
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    private boolean isResumeExist(String uuid, Resume resume) {
        return uuid.equalsIgnoreCase(resume.getUuid());
    }
}
