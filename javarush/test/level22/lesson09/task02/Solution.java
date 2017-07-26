package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution
{

    public static StringBuilder getCondition(Map<String, String> params)
    {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet())
        {
            if (entry.getValue() != null)
                sb.append(entry.getKey()).append(" = \'").append(entry.getValue()).append("\' and ");
        }
        if (sb.length() > 0)
        {
            sb.delete(sb.lastIndexOf("and") - 1, sb.length());
        }
        return sb;
    }

    public static void main(String[] args)
    {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        Map<String, String> map2 = new HashMap<>();

        Map<String, String> map3 = new HashMap<>();
        map3.put("name", null);
        map3.put("country", null);
        map3.put("city", null);
        map3.put("age", null);

        System.out.println(getCondition(map2));
    }
}
