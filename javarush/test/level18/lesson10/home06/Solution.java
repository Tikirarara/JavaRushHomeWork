package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.util.*;

public class Solution
{

    public static void main(String[] args) throws Exception
    {

        FileInputStream in = new FileInputStream(args[0]);

        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        in.close();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < bytes.length; i++)
        {
            map.put((char) bytes[i], 0);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet())
        {
            Character key = entry.getKey();
            int value = 0;

            for (int i = 0; i < bytes.length; i++)
            {
                if (key.equals((char) (bytes[i])))
                {
                    value++;
                }
            }
            map.put((char) entry.getKey(), value);
        }

        ArrayList<Byte> list = new ArrayList<>();

        for (Character i : map.keySet())
        {
            char j = i;
            list.add((byte) j);
        }

        Collections.sort(list);

        ArrayList<Character> listChars = new ArrayList<>();

        for (int i = 0; i < list.size(); i++)
        {
            byte j = list.get(i);
            listChars.add((char) j);
        }

        for (char i : listChars)
        {
            System.out.println(i + " " + map.get(i));
        }

    }
}
