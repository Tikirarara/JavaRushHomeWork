package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Разберитесь почему не работает метод main()
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(java.lang.String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {
            File your_file_name = new File("your_file_name");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            //loadedObject.string1.print();
            loadedObject.string2 = new String(); //string #4
            //loadedObject.string2.print();

            loadedObject.load(inputStream);
            //loadedObject.string1.print();
            //loadedObject.string2.print();
            //check here that the object variable equals to loadedObject - проверьте тут, что object и loadedObject равны
            System.out.println(loadedObject.equals(object));

            outputStream.close();
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object
    {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception
        {
            PrintWriter pw = new PrintWriter(outputStream);
            pw.println(string1.number);
            pw.println(string2.number);
            pw.flush();
        }

        public void load(InputStream inputStream) throws Exception
        {
            int countStringDef = countStrings;
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            countStrings = Integer.parseInt(br.readLine()) - 1;
            this.string1 = new String();
            this.string2 = new String();
            countStrings = countStringDef;
        }
    }

    public static int countStrings;

    public static class String
    {
        private final int number;

        public String()
        {
            number = ++countStrings;
        }

        public void print()
        {
            System.out.println("string #" + number);
        }
    }
}
