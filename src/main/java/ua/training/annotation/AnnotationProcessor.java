package ua.training.annotation;


import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class AnnotationProcessor {
    /**
     * Invokes methods with annotation Collect and adds return values to the List of Strings
     * @param obj
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static List<String> collectInfo(Object obj) throws ClassNotFoundException,
            IllegalAccessException, InvocationTargetException{
        List<String> list = new ArrayList<>();
        Class<?> type = Class.forName(obj.getClass().getName());
        for (Method method : type.getMethods()) {
            if (method.isAnnotationPresent(Collect.class))
                list.add(method.getName() + ": " + String.valueOf(method.invoke(obj)));
        }
        return list;
    }
}
