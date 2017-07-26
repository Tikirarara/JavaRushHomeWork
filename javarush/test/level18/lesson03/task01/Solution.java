package com.javarush.test.level18.lesson03.task01;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream in = new FileInputStream(fileName);
        ArrayList<Integer> byteList = new ArrayList<Integer>();
        while (in.available() > 0)
        {
            byteList.add(in.read());
        }
        int max = byteList.get(0);
        for (int i = 1; i < byteList.size(); i++)
        {
            if (max < byteList.get(i))
                max = byteList.get(i);
        }
        System.out.print(max);

        reader.close();
        in.close();
    }
}
