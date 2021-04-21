package com.lesson9;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) throws Exception {
        System.out.println(MainApp.class.getName());
        System.out.println(void.class.getName());
        System.out.println(int.class.getName());

        // 3. Способа получить объект типа Class:
        Class stringClass1 = "Java".getClass();
        Class stringClass2 = String.class;
        Class stringClass3 = Class.forName("java.lang.String");

        System.out.println(stringClass1);
        System.out.println(stringClass2);
        System.out.println(stringClass3);

        Class catClass = Cat.class;

        // Получение всех методов объявленных в классе (без унаследованных)
        System.out.println("--------------.getDeclaredMethods()-------------");
        Method[] methods = catClass.getDeclaredMethods();
        Arrays.stream(methods).forEach(o -> System.out.println(o.getName()));

        // Получение всех публичных методов объявленных в классе (включая унаследованные)
        System.out.println("---------------.getMethods()------------");
        Method[] methods1 = catClass.getMethods();
        Arrays.stream(methods1).forEach(o -> System.out.println(o.getName()));

        // Выполнение методов
        System.out.println("---------------Выполнение методов------------");
        Cat cat = new Cat(1,2,3,4);
        methods[0].invoke(cat);
        methods[1].setAccessible(true); // необходимо для получения доступа к приватному члену
        methods[1].invoke(cat);

        //  Получение модификаторов
        System.out.println("---------------Получение модификаторов------------");
        int mod = methods[0].getModifiers();
        System.out.println("is static: " + Modifier.isStatic(mod));
        System.out.println("is final: " + Modifier.isFinal(mod));
        System.out.println("is private: " + Modifier.isPrivate(mod));
        System.out.println("is public: " + Modifier.isPublic(mod));

        //  Получение полей
        System.out.println("---------------Получение полей------------");
        Field[] fields = catClass.getDeclaredFields();
        Arrays.stream(fields).forEach(s-> System.out.println(s.getName()));
        System.out.println(fields[0].getInt(cat));
        fields[0].set(cat, 5);
        System.out.println(fields[0].getInt(cat));
        fields[2].setAccessible(true);
        fields[2].set(cat, 20);
        System.out.println(fields[2].getInt(cat));
    }
}
