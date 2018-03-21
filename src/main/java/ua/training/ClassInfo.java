package ua.training;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ClassInfo {
    public static void printImplementedInterfacesInfo(Class<?> type) {
        if (type == null)
            return;

        for (Class cInterface : type.getInterfaces())
            System.out.println(cInterface.getName());

        printImplementedInterfacesInfo(type.getSuperclass());
    }

    public static void printDeclaredFieldsInfo(Class<?> type) {
        for (Field field : type.getDeclaredFields()) {
            for (Annotation annotation : field.getDeclaredAnnotations())
                System.out.println(annotation.annotationType());

            System.out.println(field.getType().getSimpleName() + " " + field.getName());
        }
    }
}
