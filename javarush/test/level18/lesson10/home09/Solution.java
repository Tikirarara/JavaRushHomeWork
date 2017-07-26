package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.*;

public class Solution
{

    private static String fileName;
    private static FileInputStream in;

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {

            fileName = reader.readLine();
            try
            {
                in = new FileInputStream(fileName);
            }
            catch (FileNotFoundException ex)
            {
                System.out.println(fileName);
                System.out.println("i close reader " + fileName);
                reader.close();
            }

        }

        //System.out.println("i close in " + fileName);
        //in.close();

    }
}
