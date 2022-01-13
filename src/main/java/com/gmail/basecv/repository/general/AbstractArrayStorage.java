package com.gmail.basecv.repository.general;

import com.gmail.basecv.exception.StorageException;
import com.gmail.basecv.model.Resume;

import java.util.Arrays;
import java.util.List;

import static com.gmail.basecv.common.Constant.STORAGE_LIMIT;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract void insertElement(Resume resume, int index);
    protected abstract void deleteElement(int index);

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertElement(resume, (Integer) searchKey);
            size++;
        }
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage[(Integer) searchKey];
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        storage[(Integer) searchKey] = resume;
    }

    @Override
    protected void doDelete(Object searchKey) {
        deleteElement((Integer) searchKey);
        storage[size - 1] = null;
        size--;
    }

    public List<Resume> getAll() {
        return List.of(Arrays.copyOfRange(storage, 0, size));
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >= 0;
    }
}
