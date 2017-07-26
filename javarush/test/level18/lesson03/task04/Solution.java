package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
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
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (in.available() > 0)
        {
            list.add(in.read());
        }
        in.close();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++)
        {
            int count = 0;
            for (int j = 0; j < list.size(); j++)
            {
                if (list.get(i).equals(list.get(j)))
                    count++;
            }
            map.put(list.get(i), count - 1);
        }

        int min = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (entry.getValue().equals(min))
            {
                int key = entry.getKey();
                System.out.print(key + " ");
            }
        }
    }
}
