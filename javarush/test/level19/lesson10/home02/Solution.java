package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> results = new TreeMap<>();
        while (reader.ready())
        {
            String line = reader.readLine();
            String name = line.split(" ")[0];
            Double value = Double.parseDouble(line.split(" ")[1]);
            if (results.containsKey(name))
            {
                results.put(name, results.get(name) + value);
            } else
            {
                results.put(name, value);
            }
        }

        Double maxValue = Collections.max(results.values());
        reader.close();
        for (Map.Entry<String, Double> entry : results.entrySet())
        {
            if (entry.getValue().equals(maxValue))
                System.out.println(entry.getKey());
        }
    }
}
