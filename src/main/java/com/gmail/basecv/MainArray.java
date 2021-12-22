package com.gmail.basecv;

import com.gmail.basecv.model.Resume;
import com.gmail.basecv.repository.ArrayStorage;
import com.gmail.basecv.repository.base.Storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainArray {

    private static final Storage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Resume resume;
        while (true) {
            System.out.println("Введите одну из команд - (list | size | save uuid | delete uuid | get uuid | clear | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");

            String uuid = null;

            if (params.length == 2) {
                uuid = params[1].intern();
            }

            switch (params[0]) {
                case "list" :
                    printAll();
                    break;
                case "size" :
                    System.out.println(ARRAY_STORAGE.size());
                    break;
                case "save" :
                    resume = new Resume(uuid);
                    ARRAY_STORAGE.save(resume);
                    printAll();
                    break;
                case "delete" :
                    ARRAY_STORAGE.delete(uuid);
                    printAll();
                    break;
                case "get":
                    System.out.println(ARRAY_STORAGE.get(uuid));
                    break;
                case "clear" :
                    ARRAY_STORAGE.clear();
                    printAll();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Не верная команда");
                    break;
            }
        }
    }

    private static void printAll() {
        Resume[] allResume = ARRAY_STORAGE.getAll();
        System.out.println("---------------------------------");
        if (allResume.length == 0) {
            System.out.println("Empty");
        } else {
            for (Resume resume : allResume) {
                System.out.println(resume);
            }
        }
        System.out.println("---------------------------------");
    }
}
