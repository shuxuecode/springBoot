package javaCore.reflectTest2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Test2 {


    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {


        Class<Test2> test2Class = Test2.class;

        Field[] declaredFields = test2Class.getDeclaredFields();

        for (Field field : declaredFields) {
            // todo xue
            field.setAccessible(true);
        }


    }

}
