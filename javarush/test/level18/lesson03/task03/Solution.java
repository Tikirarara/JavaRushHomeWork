package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
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
        ArrayList<Integer> byteList = new ArrayList<Integer>();
        while (in.available() > 0)
        {
            byteList.add(in.read());
        }
        in.close();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < byteList.size(); i++)
        {
            int count = 0;
            for (int j = 0; j < byteList.size(); j++)
            {
                if (byteList.get(i).equals(byteList.get(j)))
                    count++;
            }
            map.put(byteList.get(i), count - 1);
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (max < entry.getValue())
                max = entry.getValue();
        }

        for (Map.Entry<Integer, Integer> entry1 : map.entrySet())
        {
            if (entry1.getValue().equals(max))
            {
                int key = entry1.getKey();
                System.out.print(key + " ");
            }
        }
    }
}
