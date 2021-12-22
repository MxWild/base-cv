package com.gmail.basecv.repository.base;

import com.gmail.basecv.model.Resume;

public interface Storage {

    void save(Resume resume);

    Resume get(String uuid);

    Resume[] getAll();

    void update(Resume resume);

    void delete(String uuid);

    void clear();

    int size();

}
