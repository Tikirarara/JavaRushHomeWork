package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.util.*;
import java.io.*;

public class Solution
{

    public static void main(String[] args) throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader readerFile = new BufferedReader(new FileReader(fileName));

        HashMap<Integer, Object> map = new HashMap<>();

        while (readerFile.ready())
        {
            String line = readerFile.readLine();
            String i = line.substring(0, (line.indexOf(" ")));
            int id = Integer.valueOf(i);

            if ((Integer.valueOf(args[0])).equals(id))
            {
                System.out.println(line);
            }
        }

        readerFile.close();

    }
}
