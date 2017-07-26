package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/
import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for (int c=1; c>0; c++) {
            String a = reader.readLine();
            if (a.equals("сумма"))
            {
                System.out.println(sum);
                break;
            }
            int b = Integer.parseInt(a);
            sum += b;
        }
    }
}