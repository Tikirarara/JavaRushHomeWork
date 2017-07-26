package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        FileInputStream in = new FileInputStream(args[0]);
        byte[] bytesArray = new byte[in.available()];
        while (in.available() > 0)
        {
            in.read(bytesArray);
        }
        in.close();

        int count = 0;
        for (byte i : bytesArray)
        {
            if ((i > 64) && (i < 91) || (i > 96) && (i < 123))
            {
                count++;
            }
        }

        System.out.println(count);
    }
}
