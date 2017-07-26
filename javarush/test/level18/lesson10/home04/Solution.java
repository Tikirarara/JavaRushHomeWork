package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        reader.close();

        FileInputStream in1 = new FileInputStream(fileName1);
        byte[] array1 = new byte[in1.available()];
        in1.read(array1);
        in1.close();

        FileInputStream in2 = new FileInputStream(fileName2);
        byte[] array2 = new byte[in2.available()];
        in2.read(array2);
        in2.close();

        FileOutputStream out1 = new FileOutputStream(fileName1);
        out1.write(array2);
        out1.write(array1);
        out1.close();
    }
}
