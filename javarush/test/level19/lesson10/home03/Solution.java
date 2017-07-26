package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready())
        {
            String line = reader.readLine();
            String[] data = line.split(" ");
            String personName = "";
            String date = "";
            for (int i = 0; i < data.length; i++)
            {
                if (i > data.length - 4)
                {
                    date += data[i] + " ";
                } else
                {
                    personName += data[i] + " ";
                }
            }

            personName = personName.trim();
            date = date.trim();
            /*String personName = line.replaceAll("[0-9]", "").trim();
            String date = line.replaceAll("[a-zA-Zа-яА-Я]", "").trim();*/
            Calendar personDate = new GregorianCalendar(Integer.parseInt(date.split(" ")[2]),
                    Integer.parseInt(date.split(" ")[1]) - 1,
                    Integer.parseInt(date.split(" ")[0]));
            PEOPLE.add(new Person(personName, personDate.getTime()));
        }
        reader.close();
        /*for (Person person : PEOPLE)
        {
            System.out.println(person.getName() + " " + person.getBirthday());
        }*/
    }

}
