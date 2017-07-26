package com.javarush.test.level18.lesson10.home02;

import java.io.*;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {

        FileInputStream in = new FileInputStream(args[0]);
        byte[] array = new byte[in.available()];

        in.read(array);
        in.close();

        int all = array.length;
        int spases = 0;

        for (int i = 0; i < array.length; i++)
        {


            if (array[i] == 32)
            {
                spases++;
            }
        }

        System.out.printf("%.2f", ((double) spases / (double) all * 100));
    }
}
