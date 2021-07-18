package com.rafaelnaranjo.pbb.utils;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public class TestPojos {
    private static final Validator ACCESOR_VALIDATOR = ValidatorBuilder.create()
            .with(new GetterTester())
            .with(new SetterTester())
            .build();
    public static void validateAccessors(final Class<?> object){
        ACCESOR_VALIDATOR.validate(PojoClassFactory.getPojoClass(object));
    }
}
