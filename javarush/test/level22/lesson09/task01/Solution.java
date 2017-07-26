package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution
{
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args)
    {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            String filename = br.readLine();
            br.close();
            BufferedReader buf = new BufferedReader(new FileReader(filename));
            List<String> dataFromFile = new LinkedList<>();
            while (buf.ready())
            {
                dataFromFile.addAll(Arrays.asList(buf.readLine().split(" ")));
            }
            buf.close();
            for (int i = 0; i < dataFromFile.size(); i++)
            {
                String reversed = new StringBuilder(dataFromFile.get(i)).reverse().toString();
                if (!dataFromFile.get(i).equals(reversed) && dataFromFile.contains(reversed))
                {
                    Pair pair = new Pair();
                    pair.first = dataFromFile.get(i);
                    pair.second = reversed;
                    if (!(result.contains(pair)))
                    {
                        result.add(pair);
                        dataFromFile.remove(dataFromFile.get(i));
                        dataFromFile.remove(reversed);
                    }
                }
            }
            for (Pair pair : result)
            {
                System.out.println(pair.toString());
            }
        }
        catch (IOException ex)
        {
        }
    }

    public static class Pair
    {
        String first;
        String second;

        @Override
        public String toString()
        {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
