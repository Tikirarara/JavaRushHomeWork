package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream in = new FileInputStream(fileName);
        ArrayList<Integer> byteList = new ArrayList<Integer>();
        while (in.available() > 0)
        {
            byteList.add(in.read());
        }
        in.close();

        int min = byteList.get(0);
        for (int i = 1; i < byteList.size(); i++)
        {
            if (min > byteList.get(i))
                min = byteList.get(i);
        }
        System.out.print(min);
    }
}
