package com.gmail.basecv.repository;

import com.gmail.basecv.exception.ExistStorageException;
import com.gmail.basecv.exception.NotExistStorageException;
import com.gmail.basecv.model.Resume;
import com.gmail.basecv.repository.general.Storage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public abstract class AbstractStorageTest {

    protected final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME_1 = new Resume(UUID_1, "Name1");

    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME_2 = new Resume(UUID_2, "Name2");

    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_3 = new Resume(UUID_3, "Name3");

    private static final String TMP_UUID = "tmp_uuid";
    private static final Resume RESUME_TMP = new Resume(TMP_UUID, "Name_TMP");

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void save() {
        storage.save(RESUME_TMP);
        assertSize(4);
        assertEquals(RESUME_TMP, storage.get(TMP_UUID));
    }

    @Test
    public void get() {
        assertEquals(RESUME_1, storage.get(UUID_1));
    }

    @Test
    public void getAll() {
        Resume[] resumes = storage.getAll().toArray(new Resume[0]);
        assertEquals(3, resumes.length);
        assertEquals(RESUME_1, resumes[0]);
        assertEquals(RESUME_2, resumes[1]);
        assertEquals(RESUME_3, resumes[2]);
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_1, "Name1");
        storage.update(newResume);
        assertSame(newResume, storage.get(UUID_1));
    }

    @Test
    public void delete() {
        storage.save(RESUME_TMP);
        assertSize(4);
        storage.delete(TMP_UUID);
        assertSize(3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test(expected = ExistStorageException.class)
    public void getExist() {
        storage.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(RESUME_TMP);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteIfNotExist() {
        storage.delete(TMP_UUID);
    }

    private void assertSize(int size) {
        assertEquals(storage.size(), size);
    }
}