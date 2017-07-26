package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
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
        String filename2 = reader.readLine();
        String filename3 = reader.readLine();

        FileInputStream in2 = new FileInputStream(filename2);
        FileInputStream in3 = new FileInputStream(filename3);
        FileOutputStream out1 = new FileOutputStream(fileName1);

        byte[] array2 = new byte[in2.available()];
        byte[] array3 = new byte[in3.available()];

        in2.read(array2);
        in3.read(array3);

        out1.write(array2);
        out1.write(array3);

        reader.close();
        in2.close();
        in3.close();
        out1.close();
    }
}
