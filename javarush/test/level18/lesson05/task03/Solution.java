package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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
        String filename1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        reader.close();

        FileInputStream in = new FileInputStream(filename1);
        int count = 0;
        if (in.available() % 2 == 0)
            count = (in.available()) / 2;
        else
            count = in.available() / 2 + 1;
        byte[] buffer1 = new byte[count];
        FileOutputStream out1 = new FileOutputStream(fileName2);
        in.read(buffer1);
        out1.write(buffer1);
        out1.close();

        byte[] buffer2 = new byte[in.available()];
        FileOutputStream out2 = new FileOutputStream(fileName3);
        in.read(buffer2);
        out2.write(buffer2);
        in.close();
        out2.close();


    }
}
