package com.javarush.test.level25.lesson02.task02;

import java.util.*;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution
{
    public static enum Wheel
    {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car
    {
        protected List<Wheel> wheels;

        public Car()
        {
            //init wheels here
            wheels = new ArrayList<>();
            String[] arr = loadWheelNamesFromDB();
            for (int i = 0; i < arr.length; i++)
            {
                try
                {
                    Wheel wheel = Wheel.valueOf(arr[i]);
                    wheels.add(wheel);
                }
                catch (Exception e)
                {
                    System.out.println(arr[i]);
                }
            }

        }

        protected String[] loadWheelNamesFromDB()
        {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }
}
