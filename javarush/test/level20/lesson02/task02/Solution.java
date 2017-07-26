package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static com.javarush.test.level20.lesson02.task02.User.Country.RUSSIA;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
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

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User u1 = new User();
            u1.setFirstName("Kolobok");
            u1.setLastName("Petrovich");
            u1.setBirthDate(new GregorianCalendar(2000, 12 - 1, 12).getTime());
            u1.setMale(true);
            u1.setCountry(RUSSIA);
            javaRush.users.add(u1);

            User u2 = new User();
            u2.setFirstName("Fedor");
            u2.setLastName("Sumkin");
            u2.setCountry(User.Country.OTHER);
            javaRush.users.add(u2);

            User u3 = new User();
            javaRush.users.add(u3);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

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

    public static class JavaRush
    {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            if (!users.isEmpty())
            {
                String jrData = "hasUsers";
                int count = 0;
                for (User user : users)
                {
                    if (user.getFirstName() != null) count++;
                }
                jrData = jrData + " " + count;
                pw.println(jrData);
                for (User user : users)
                {
                    if (user.getFirstName() != null)
                    {
                        String userData = user.getFirstName();
                        if (user.getLastName() != null)
                        {
                            userData = userData + " " + user.getLastName();
                        } else userData = userData + " noLastName";
                        if (user.getBirthDate() != null)
                        {
                            userData = userData + " " + sdf.format(user.getBirthDate());
                        } else userData = userData + " noBirthday";
                        userData = userData + " " + user.isMale();
                        if (user.getCountry() != null)
                        {
                            userData = userData + " " + user.getCountry().getDisplayedName();
                        } else userData = userData + " noCountry";
                        pw.println(userData);
                        pw.flush();
                    }
                }
            } else pw.println("noUsers");

        }

        public void load(InputStream inputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while (br.ready())
            {
                String[] jrData = br.readLine().split(" ");
                if (jrData[0].equals("hasUsers"))
                {
                    for (int i = 0; i < Integer.parseInt(jrData[1]); i++)
                    {
                        String[] userData = br.readLine().split(" ");
                        User user = new User();

                        user.setFirstName(userData[0]);

                        if (!userData[1].equals("noLastName"))
                        {
                            user.setLastName(userData[1]);
                        }

                        if (!userData[2].equals("noBirthday"))
                        {
                            String[] date = (userData[2].split("/"));
                            user.setBirthDate(new GregorianCalendar(Integer.parseInt(date[0]),
                                    Integer.parseInt(date[1]) - 1,
                                    Integer.parseInt(date[2]))
                                    .getTime());
                        }

                        user.setMale(Boolean.parseBoolean(userData[3]));

                        if (!userData[4].equals("noCountry"))
                        {
                            user.setCountry(User.Country.valueOf(userData[4].toUpperCase()));
                        }
                        users.add(user);
                    }
                }
            }
        }
    }
}
