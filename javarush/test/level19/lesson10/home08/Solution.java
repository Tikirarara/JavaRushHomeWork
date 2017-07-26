package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = br.readLine();
        br.close();
        BufferedReader reader = new BufferedReader(new FileReader(filename1));
        while (reader.ready())
        {
            char[] lineInChars = reader.readLine().toCharArray();
            String lineOut = "";
            for (int i = lineInChars.length - 1; i >= 0; i--)
            {
                lineOut += lineInChars[i];
            }
            System.out.println(lineOut);
        }
        reader.close();
    }
}
