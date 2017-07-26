package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution
{
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap()
    {
        //implement this method - реализуйте этот метод
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String filename = br.readLine();
            InputStream in = new FileInputStream(new File(filename));
            this.load(in);
        }
        catch (IOException e1)
        {
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e2)
        {
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public void save(OutputStream outputStream) throws Exception
    {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        for (Map.Entry entry : properties.entrySet())
        {
            prop.setProperty(entry.getKey().toString(), entry.getValue().toString());
        }
        prop.store(outputStream, "new props");
    }

    public void load(InputStream inputStream) throws Exception
    {
        Properties prop = new Properties();
        prop.load(inputStream);
        Enumeration enumer = prop.keys();
        while (enumer.hasMoreElements())
        {
            String key = enumer.nextElement().toString();
            properties.put(key, prop.getProperty(key));
        }
    }
}
