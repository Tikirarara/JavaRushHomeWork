package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution
{
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException
    {
        try (BufferedReader br = new BufferedReader(new FileReader(args[0])); // тело файла в win
             FileOutputStream fos = new FileOutputStream(args[1])) // тело файла в utf
        {
            Charset utf8 = Charset.forName("UTF-8");
            Charset win = Charset.forName("Windows-1251");
            while (br.ready())
            {
                fos.write(br.readLine().getBytes(win));
            }
            br.close();
            fos.close();
        }
        catch (Exception ignored)
        {
        }
    }
}
