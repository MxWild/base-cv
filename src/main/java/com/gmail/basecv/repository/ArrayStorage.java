package com.gmail.basecv.repository;

import com.gmail.basecv.model.Resume;

import java.util.Arrays;

public class ArrayStorage implements Storage {

    private static final String RESUME_WITH_UUID = "Resume with uuid := ";
    private static final int STORAGE_LIMIT = 10000;

    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) != -1) {
            printMessage(RESUME_WITH_UUID + resume.getUuid() + " already exist");
        } else if (size == storage.length) {
            printMessage("Storage overflow");
        } else {
            storage[size++] = resume;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
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

    private void printMessage(String message) {
        System.out.println(message);
    }
}
