package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей,
данные одного человека находятся в одной строке.
Метод read() должен читать данные одного человека.
*/

public class Solution
{
    public static class PersonScannerAdapter implements PersonScanner
    {
        private final Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException, ParseException
        {
            String data = scanner.nextLine();
            String[] personInf = data.split(" ");
            Calendar date = new GregorianCalendar(Integer.parseInt(personInf[5]),
                    Integer.parseInt(personInf[4]) - 1,
                    Integer.parseInt(personInf[3]));
            //SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");

            return new Person(personInf[1],
                    personInf[2],
                    personInf[0],
                    date.getTime());

            //sdf.parse(String.format("%s.%s.%s", personInf[3], personInf[4], personInf[5])));
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}
