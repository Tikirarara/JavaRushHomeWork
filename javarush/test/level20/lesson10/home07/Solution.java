package com.javarush.test.level20.lesson10.home07;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable
{
    private transient FileOutputStream stream;
    private String filename;

    public Solution(String fileName) throws FileNotFoundException
    {
        this.stream = new FileOutputStream(fileName);
        this.filename = fileName;
    }

    public Solution()
    {
    }

    public void writeObject(String string) throws IOException
    {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException
    {
        out.defaultWriteObject();
        out.writeObject(filename);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        in.defaultReadObject();
        String name = (String) in.readObject();
        BufferedReader br = new BufferedReader(new FileReader(name));
        List<String> lines = new ArrayList<>();
        while (br.ready())
        {
            lines.add(br.readLine());
        }
        stream = new FileOutputStream(name);
        for (String line : lines)
        {
            writeObject(line);
        }
    }

    @Override
    public void close() throws Exception
    {
        System.out.println("Closing everything!");
        stream.flush();
        stream.close();
    }

    public static void main(String[] args) throws Exception
    {
        Solution saved = new Solution("your_file_name");
        saved.writeObject("lololo");
        //saved.writeObject("1111");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test"));
        oos.writeObject(saved);
        oos.flush();
        oos.close();
        saved.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test"));
        Solution loaded = (Solution) ois.readObject();
        loaded.writeObject(" eeeee");
        loaded.close();
    }
}
