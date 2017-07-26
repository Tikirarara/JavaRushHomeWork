package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
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

        FileReader fr = new FileReader(file1);
        FileWriter fw = new FileWriter(file2);

        List<Byte> bytes = new ArrayList<>();
        while (fr.ready())
        {
            bytes.add((byte) fr.read());
        }
        fr.close();

        for (int i = 0; i < bytes.size(); i++)
        {
            if ((i + 1) % 2 == 0)
            {
                System.out.println(i);
                fw.write(bytes.get(i));
            }
        }
        fw.close();
    }
}
