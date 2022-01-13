package com.gmail.basecv.repository;

import com.gmail.basecv.exception.StorageException;
import com.gmail.basecv.model.Resume;
import com.gmail.basecv.repository.general.Storage;
import org.junit.Test;

import static com.gmail.basecv.common.Constant.STORAGE_LIMIT;
import static org.junit.Assert.fail;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = 4; i < STORAGE_LIMIT + 1; i++) {
                storage.save(new Resume(String.valueOf(i), "Name" + i));
            }
        } catch (StorageException e) {
            fail();
        }
        storage.save(new Resume(String.valueOf(STORAGE_LIMIT + 1), "Name" + STORAGE_LIMIT + 1));
    }
}
