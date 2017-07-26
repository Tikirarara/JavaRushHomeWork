package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileOutputStream out = new FileOutputStream(fileName);
        ArrayList<String> lines = new ArrayList<>();

        while (true)
        {
            String line = reader.readLine();
            lines.add(line);
            if (line.equals("exit"))
            {
                reader.close();
                break;
            }
        }

        for (int i = 0; i < lines.size(); i++)
        {
            byte[] bytes = lines.get(i).getBytes();
            out.write(bytes);
            if (i != lines.size() - 1)
                out.write('\n');
        }
        out.close();
    }
}
