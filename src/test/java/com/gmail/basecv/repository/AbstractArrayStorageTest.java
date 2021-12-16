package com.gmail.basecv.repository;

import com.gmail.basecv.exception.ExistStorageException;
import com.gmail.basecv.exception.NotExistStorageException;
import com.gmail.basecv.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractArrayStorageTest {

    private final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    private static final String TMP_UUID = "tmp_uuid";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void save() {
        storage.save(new Resume(TMP_UUID));
        assertEquals(new Resume(TMP_UUID), storage.get(TMP_UUID));
    }

    @Test
    public void get() {
        assertEquals(new Resume(UUID_1), storage.get(UUID_1));
    }

    @Test
    public void getAll() {
        storage.getAll();
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
        storage.save(new Resume(TMP_UUID));
        assertEquals(4, storage.size());
        storage.delete(TMP_UUID);
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void getExist() {
        storage.save(new Resume(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }
}