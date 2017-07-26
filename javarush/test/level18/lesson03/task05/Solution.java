package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream in = new FileInputStream(fileName);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (in.available() > 0)
        {
            list.add(in.read());
        }

        ArrayList<Integer> copy = new ArrayList<Integer>();
        copy.addAll(list);
        for (int i = 0; i < copy.size(); i++)
        {
            int count = 0;
            for (int j = 0; j < list.size(); j++)
            {
                if (copy.get(i).equals(list.get(j)))
                    count++;
            }
            if (count > 1)
                list.remove(copy.get(i));
        }

        Collections.sort(list);
        for (Integer i : list)
            System.out.print(i + " ");

        reader.close();
        in.close();
    }
}