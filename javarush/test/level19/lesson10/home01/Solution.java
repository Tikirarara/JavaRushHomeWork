package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
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
        reader.close();
        for (Map.Entry<String, Double> entry : results.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }
    }
}
