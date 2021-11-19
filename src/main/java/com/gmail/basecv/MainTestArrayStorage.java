package com.gmail.basecv;

import com.gmail.basecv.model.Resume;
import com.gmail.basecv.repository.ArrayStorage;
import com.gmail.basecv.repository.SortedArrayStorage;
import com.gmail.basecv.repository.Storage;

public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {

        var resume1 = new Resume();
        resume1.setUuid("uuid1");

        var resume2 = new Resume();
        resume2.setUuid("uuid2");

        var resume3 = new Resume();
        resume3.setUuid("uuid3");

        ARRAY_STORAGE.save(resume1);
        ARRAY_STORAGE.save(resume2);
        ARRAY_STORAGE.save(resume3);

        System.out.println("Get resume1: " + ARRAY_STORAGE.get(resume1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        printAll();

        ARRAY_STORAGE.delete(resume1.getUuid());
        printAll();

        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (var resume: ARRAY_STORAGE.getAll()) {
            System.out.println(resume);
        }
    }
}