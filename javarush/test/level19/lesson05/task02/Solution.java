package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
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
        br.close();

        BufferedReader fr = new BufferedReader(new FileReader(file1));

        List<String> lines = new ArrayList<>();
        while (fr.ready())
        {
            lines.add(fr.readLine());
        }
        fr.close();

        int counter = 0;
        for (String line : lines)
        {
            String[] words = line.replaceAll("[,....?!\"-'-/+=*;:%$#@&^<>/[/]{}]", " ").trim().split(" ");
            for (String word : words)
            {
                if (word.equals("world"))
                    counter++;
            }
        }
        System.out.println(counter);
    }
}
