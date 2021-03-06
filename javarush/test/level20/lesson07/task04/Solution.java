package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Externalizable
{
    public static void main(String[] args)
    {
        try
        {
            Solution savedObject = new Solution(1);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("your_file_name"));
            System.out.println(savedObject.toString());
            savedObject.writeExternal(oos);
            oos.close();
            Solution loadedObject = new Solution(2);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("your_file_name"));
            System.out.println(loadedObject.toString());
            loadedObject.readExternal(ois);
            ois.close();
            System.out.println(loadedObject.toString());

        }
        catch (ClassNotFoundException ex1)
        {
            System.out.println("fuck!");
        }
        catch (IOException ex)
        {
            System.out.println("load/save");
        }
    }

    private static final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature)
    {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    public Solution()
    {
        super();
    }

    @Override
    public String toString()
    {
        return this.string;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeObject(string);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        string = (String) in.readObject();
    }
}
