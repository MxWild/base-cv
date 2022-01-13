package com.gmail.basecv;

import com.gmail.basecv.model.Resume;
import com.gmail.basecv.repository.ArrayStorage;
import com.gmail.basecv.repository.general.Storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainArray {

    private static final Storage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Resume resume;
        while (true) {
            System.out.println("Введите одну из команд - (list | size | save fullName | delete uuid | get uuid fullName | clear | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");

            if (params.length < 1 || params.length > 3) {
                System.out.println("Неверная команда.");
                continue;
            }

            String param = null;
            if (params.length > 1) {
                param = params[1].intern();
            }

            switch (params[0]) {
                case "list":
                    printAll();
                    break;
                case "size":
                    System.out.println(ARRAY_STORAGE.size());
                    break;
                case "save":
                    resume = new Resume(param);
                    ARRAY_STORAGE.save(resume);
                    printAll();
                    break;
                case "update":
                    resume = new Resume(param, params[2]);
                    ARRAY_STORAGE.save(resume);
                    printAll();
                    break;
                case "delete":
                    ARRAY_STORAGE.delete(param);
                    printAll();
                    break;
                case "get":
                    System.out.println(ARRAY_STORAGE.get(param));
                    break;
                case "clear":
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
        List<Resume> allResume = ARRAY_STORAGE.getAll();
        System.out.println("---------------------------------");
        if (allResume.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (Resume resume : allResume) {
                System.out.println(resume);
            }
        }
        System.out.println("---------------------------------");
    }
}
