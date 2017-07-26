package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution
{
    public static String[] getTokens(String query, String delimiter)
    {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        List<String> list = new ArrayList<>();
        while (st.hasMoreTokens())
        {
            list.add(st.nextToken());
        }
        return list.toArray(new String[list.size()]);
    }
}
