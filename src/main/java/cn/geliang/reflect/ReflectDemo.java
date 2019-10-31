package cn.geliang.reflect;

import java.lang.reflect.Field;

/**
 * @Classname ReflectDemo
 * @Description TODO
 * @Date 2019-08-28
 * @Created by Geliang TIAN
 */
public class ReflectDemo {

    private static class Human {
        private String name;
        private int age;

        public Human() {
        }

        @Override
        public String toString() {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        Human human = new Human();
        Class<Human> humanClass = Human.class;
        Field[] fields = humanClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            if (name.equals("name")) {
                field.set(human, "Ayden");
            }
            if (name.equals("age")) {
                field.set(human, 20);
            }
        }
        System.out.println(human );
    }
}
