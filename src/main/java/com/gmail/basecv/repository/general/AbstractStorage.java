package com.gmail.basecv.repository.general;

import com.gmail.basecv.exception.ExistStorageException;
import com.gmail.basecv.exception.NotExistStorageException;
import com.gmail.basecv.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import static com.gmail.basecv.common.Constant.ALREADY_EXIST;
import static com.gmail.basecv.common.Constant.NOT_EXIST;
import static com.gmail.basecv.common.Constant.RESUME_WITH_UUID;

public abstract class AbstractStorage<T> implements Storage {

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract void doSave(Resume resume, T searchKey);

    protected abstract Resume doGet(T searchKey);

    protected abstract void doUpdate(Resume resume, T searchKey);

    protected abstract void doDelete(T searchKey);

    protected abstract List<Resume> doCopyAll();

    protected abstract T getSearchKey(String uuid);

    protected abstract boolean isExist(T searchKey);

    @Override
    public void save(Resume resume) {
//        LOG.info("Save " + resume);
        T searchKey = getNotExistedSearchKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    @Override
    public Resume get(String uuid) {
        LOG.info("Get resume with uuid = " + uuid);
        T searchKey = getExistedSearchKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public void update(Resume resume) {
        LOG.info("Update " + resume);
        T searchKey = getExistedSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    @Override
    public void delete(String uuid) {
        LOG.info("Delete resume with uuid = " + uuid);
        T searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("Get all sorted resume");
        List<Resume> resumes = doCopyAll();
        Collections.sort(resumes);
        return resumes;
    }

    private T getExistedSearchKey(String uuid) {
        T searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning(RESUME_WITH_UUID + uuid + NOT_EXIST);
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private T getNotExistedSearchKey(String uuid) {
        T searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning(RESUME_WITH_UUID + uuid + ALREADY_EXIST);
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}
