package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {

            //File your_file_name = File.createTempFile("your_file_name", null);
            File your_file_name = new File("your_file_name");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human petrov = new Human("Petrov");
            petrov.save(outputStream);
            outputStream.flush();

            Human nobody = new Human();
            nobody.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);

            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
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


    public static class Human
    {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human()
        {
        }

        public Human(String name, Asset... assets)
        {
            this.name = name;
            if (assets != null)
            {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception
        {
            boolean humanHasName = name != null;
            boolean humanHasAsset = !assets.isEmpty();

            String humanInLine = "" + humanHasName;
            if (humanHasName)
            {
                humanInLine = humanInLine + " " + name + " " + humanHasAsset;
                if (humanHasAsset)
                {
                    humanInLine = humanInLine + " " + assets.size();
                    for (Asset asset : assets)
                    {
                        humanInLine = humanInLine + " " + asset.getName() + " " + asset.getPrice();
                    }
                }
                outputStream.write(humanInLine.getBytes());
                outputStream.write('\n');
                outputStream.flush();
            }
        }

        public void load(InputStream inputStream) throws Exception
        {
            String humanInLine = "";
            while (inputStream.available() > 0)
            {
                int i = inputStream.read();
                if ((char) i != '\n')
                {
                    humanInLine += (char) i;
                } else
                    break;
            }
            String[] humanData = humanInLine.split(" ");

            if (Boolean.parseBoolean(humanData[0]))
            {
                name = humanData[1];
                if (Boolean.parseBoolean(humanData[2]))
                {
                    int countAssets = Integer.parseInt(humanData[3]);
                    for (int i = 0; i < countAssets * 2; i += 2)
                    {
                        Asset humanAsset = new Asset(humanData[i + 4]);
                        humanAsset.setPrice(Double.parseDouble(humanData[i + 5]));
                        assets.add(humanAsset);
                    }
                }
            }
        }
    }
}


    /*public void save(OutputStream outputStream) throws Exception
    {
        PrintWriter pw = new PrintWriter(outputStream);

        boolean humanHasName = name != null;
        boolean humanHasAsset = !assets.isEmpty();

        pw.println(humanHasName);
        if (humanHasName)
        {
            pw.println(name);

            pw.println(humanHasAsset);
            if (humanHasAsset)
            {
                pw.println(assets.size());
                for (Asset asset : assets)
                {
                    pw.println(asset.getName() + " " + asset.getPrice());
                }
            }
            pw.flush();
        }
    }

    public void load(InputStream inputStream) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        if (Boolean.parseBoolean(br.readLine()))
        {
            name = br.readLine();
            if (Boolean.parseBoolean(br.readLine()))
            {
                int countAssets = Integer.parseInt(br.readLine());
                for (int i=0; i<countAssets; i++)
                {
                    assets.add(new Asset(br.readLine()));
                }
            }
        }
    }*/
