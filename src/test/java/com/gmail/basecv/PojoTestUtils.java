package com.gmail.basecv;

import com.openpojo.random.RandomFactory;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoField;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.openpojo.validation.utils.ValidationHelper;

public class PojoTestUtils {

    private static final Validator ACCESSOR_VALIDATOR = ValidatorBuilder.create()
            .with(new GetterTester())
            .with(new SetterTester())
            .build();

    private static final Validator GET_SET_STRING_VALIDATOR = ValidatorBuilder.create()
            .with(new SetterTester())
            .with(new GetterTester())
            .with(new ReflectionToStringTester())
            .build();

    public static void validateAccessors(final Class<?> clazz) {
        ACCESSOR_VALIDATOR.validate(PojoClassFactory.getPojoClass(clazz));
    }

    public static void validateAccessorsWithToString(final Class<?> clazz) {
        GET_SET_STRING_VALIDATOR.validate(PojoClassFactory.getPojoClass(clazz));
    }

    public static Object createObject(PojoClass pojoClass) {
        final Object basicInstance = ValidationHelper.getBasicInstance(pojoClass);
        for (final PojoField fieldEntry : pojoClass.getPojoFields()) {
            if (fieldEntry.hasSetter() && !fieldEntry.isFinal()) {
                fieldEntry.set(basicInstance, RandomFactory.getRandomValue(fieldEntry));
            }
        }
        return basicInstance;
    }

}
