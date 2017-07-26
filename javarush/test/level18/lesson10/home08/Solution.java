package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> names = new ArrayList<>();

        while (true)
        {
            String fileName = reader.readLine();

            if (!fileName.equals("exit"))
            {
                names.add(fileName);
            } else
            {
                break;
            }
        }

        reader.close();

        for (String fileName : names)
        {

            new ReadThread(fileName).start();
        }
    }

    public static class ReadThread extends Thread
    {

        private String fileName;

        public ReadThread(String fileName)
        {
            this.fileName = fileName;
        }

        @Override
        public void run()
        {

            HashMap<Integer, Integer> map = new HashMap<>();
            ArrayList<Integer> bytes = new ArrayList<>();

            try
            {
                FileInputStream in = new FileInputStream(this.fileName);

                while (in.available() > 0)
                {
                    bytes.add(in.read());
                }

                in.close();
            }
            catch (IOException ex)
            {
                System.out.println(ex);
            }

            for (int i = 0; i < bytes.size(); i++)
            {

                int key = bytes.get(i);
                int value = 0;

                for (int j = 0; j < bytes.size(); j++)
                {

                    if (key == bytes.get(j))
                    {
                        value++;
                    }
                }
                map.put(key, value);
            }

            int maxKey = Byte.MIN_VALUE;
            int maxValue = Integer.MIN_VALUE;

            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {

                if (maxValue < entry.getValue())
                {
                    maxKey = entry.getKey();
                    maxValue = entry.getValue();
                }
            }

            synchronized (resultMap)
            {
                resultMap.put(this.fileName, maxKey);
            }
        }

    }
}
