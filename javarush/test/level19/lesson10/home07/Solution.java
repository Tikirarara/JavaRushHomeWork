package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter writer = new FileWriter(args[1]);
        String lineOut = "";
        while (reader.ready())
        {
            String lineIn = reader.readLine();
            String[] words = lineIn.split(" ");
            for (String word : words)
            {
                if (word.length() > 6)
                    lineOut += word + ",";
            }
        }
        writer.write(lineOut.substring(0, lineOut.length() - 1));
        reader.close();
        writer.close();
    }
}
