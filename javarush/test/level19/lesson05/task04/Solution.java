package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
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

        for (String oneLine : lines)
        {
            fw.write(oneLine.replace(".", "!"));
        }
        fw.close();
    }
}
