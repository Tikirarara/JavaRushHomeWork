package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution
{
    public static String getPartOfString(String string) throws TooShortStringException
    {
        try
        {
            if (string != null)
            {
                int space1 = string.indexOf(" ");
                int space2 = string.indexOf(" ", space1 + 1);
                int space3 = string.indexOf(" ", space2 + 1);
                int space4 = string.indexOf(" ", space3 + 1);
                int space5 = string.indexOf(" ", space4 + 1);

                return string.substring(space1 + 1, space5);
            } else throw new TooShortStringException();
        }
        catch (StringIndexOutOfBoundsException ex2)
        {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception
    {
    }
}
