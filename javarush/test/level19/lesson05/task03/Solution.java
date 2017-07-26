package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();

        BufferedReader fr = new BufferedReader(new FileReader(file1));
        FileWriter fw = new FileWriter(file2);

        List<String> lines = new ArrayList<>();
        while (fr.ready())
        {
            String line = fr.readLine();
            lines.add(line);
        }
        fr.close();

        String neededLine = "";
        for (String oneLine : lines)
        {
            String[] words = oneLine.split(" ");
            //String[] words = oneLine.replaceAll("[a-z,.<>;:?!'\"*&^%$#@=]", "+").split(" ");
            for (String word : words)
            {
                if (word.matches("\\d+"))
                {
                    neededLine += word + " ";
                }
            }
        }
        neededLine = neededLine.trim();
        fw.write(neededLine);
        fw.close();
    }
}
