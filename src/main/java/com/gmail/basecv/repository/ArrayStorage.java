package com.gmail.basecv.repository;

import com.gmail.basecv.model.Resume;

public class ArrayStorage {

    private final Resume[] storage = new Resume[10000];
    private int size = 0;

    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) != -1) {
            System.out.println("Resume with uuid := " + resume.getUuid() + " already exist");
        } else if (size == storage.length) {
            System.out.println("Storage overflow");
        } else {
            storage[size++] = resume;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume with uuid := " + uuid + " not found");
            return null;
        }
        return storage[index];
    }

    public Resume[] getAll() {
        Resume[] result = new Resume[size];
        if (size >= 0) {
            System.arraycopy(storage, 0, result, 0, size);
        }
        return result;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("Resume with uuid := " + resume.getUuid() + " not exist");
        } else {
            storage[size++] = resume;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR, resume not found");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
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

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
