package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream in = new FileInputStream(fileName);
        byte[] array1 = new byte[in.available()];
        char[] array2 = new char[array1.length];
        for (int i = 0; i < array1.length; i++)
        {
            array1[i] = (byte) in.read();
        }
        in.close();

        for (int i = 0; i < array1.length; i++)
        {
            array2[i] = (char) array1[i];
        }

        int count = 0;
        for (int i = 0; i < array2.length; i++)
        {
            if (array2[i] == ((char) 44))
                count++;
        }
        System.out.print(count);
    }
}
