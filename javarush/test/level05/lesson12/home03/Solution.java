package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);

        Cat tomCat = new Cat("Tom", "man", "eating");
        Dog spaikDog = new Dog("Spaik", "old", "angry");
        Dog taikDog = new Dog("Taik", "young", "happy");
        Cat butchCat = new Cat("Butch", "man", "playing piano");
        Cat tutsCat = new Cat("Tuts", "woman", "walking in tha park");
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Dog
    {
        String name;
        String age;
        String emotion;

        public Dog(String name, String age, String emotion)
        {
            this.name = name;
            this.age = age;
            this.emotion = emotion;
        }
    }

    public static class Cat
    {
        String name;
        String sex;
        String action;

        public Cat(String name, String sex, String action)
        {
            this.name = name;
            this.sex = sex;
            this.action = action;
        }
    }
}
