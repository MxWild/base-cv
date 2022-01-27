package com.gmail.basecv;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoField;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.test.Tester;
import com.openpojo.validation.utils.ValidationHelper;

import java.util.HashSet;
import java.util.Set;

public class ReflectionToStringTester implements Tester {

    private static final String TO_STRING = "toString";

    private Object fillClassInstance(PojoClass pojoClass, Set<String> fieldNames) {
        final Object basicInstance = ValidationHelper.getBasicInstance(pojoClass);
        for (final PojoField fieldEntry : pojoClass.getPojoFields()) {
            if (fieldEntry.hasSetter() && !fieldEntry.isFinal()) {
                fieldNames.add(fieldEntry.getName());
            }
        }
        return basicInstance;
    }

    @Override
    public void run(PojoClass pojoClass) {
        Set<String> fieldNames = new HashSet<>();
        final Object classInstance = fillClassInstance(pojoClass, fieldNames);
        String string = classInstance.toString();
        for (String fieldName : fieldNames) {
            Affirm.affirmTrue("Не отображается поле " + fieldName, string.contains(fieldName));
        }
    }
}
