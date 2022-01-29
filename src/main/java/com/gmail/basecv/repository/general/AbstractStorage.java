package com.gmail.basecv.repository.general;

import com.gmail.basecv.exception.ExistStorageException;
import com.gmail.basecv.exception.NotExistStorageException;
import com.gmail.basecv.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {

    protected abstract void doSave(Resume resume, SK searchKey);
    protected abstract Resume doGet(SK searchKey);
    protected abstract void doUpdate(Resume resume, SK searchKey);
    protected abstract void doDelete(SK searchKey);
    protected abstract List<Resume> doCopyAll();

    protected abstract SK getSearchKey(String uuid);
    protected abstract boolean isExist(SK searchKey);

    @Override
    public void save(Resume resume) {
        SK searchKey = getNotExistedSearchKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    @Override
    public Resume get(String uuid) {
        SK searchKey = getExistedSearchKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public void update(Resume resume) {
        SK searchKey = getExistedSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    @Override
    public void delete(String uuid) {
        SK searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> resumes = doCopyAll();
        Collections.sort(resumes);
        return resumes;
    }

    private SK getExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}
