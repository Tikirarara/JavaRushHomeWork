package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader in = new BufferedReader(new FileReader(fileName1));
        FileWriter writer = new FileWriter(fileName2);

        String[] numbers;

        while (in.ready())
        {
            numbers = in.readLine().split(" ");

            for (int i = 0; i < numbers.length; i++)
            {

                if (i != numbers.length - 1)
                {
                    writer.write(String.valueOf(Math.round(Double.parseDouble(numbers[i]))));
                    writer.write((char) 32);
                } else
                    writer.write(String.valueOf(Math.round(Double.parseDouble(numbers[i]))));
            }
        }

        in.close();
        writer.close();

    }
}
