package com.gmail.basecv.repository.general;

import com.gmail.basecv.model.Resume;

import java.util.List;

public interface Storage {

    void save(Resume resume);

    Resume get(String uuid);

    List<Resume> getAllSorted();

    void update(Resume resume);

    void delete(String uuid);

    void clear();

    int size();

}
