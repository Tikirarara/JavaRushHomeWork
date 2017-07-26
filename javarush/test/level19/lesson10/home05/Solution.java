package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter writer = new FileWriter(args[1]);
        while (reader.ready())
        {
            String line = reader.readLine();
            String[] words = line.split(" ");
            for (String word : words)
            {
                //Pattern pat = Pattern.compile("[0-9]");
                if (word.matches(".+[0-9]|[0-9].+|.+[0-9].+"))
                    writer.write(word + " ");
            }
        }
        reader.close();
        writer.close();
    }
}
