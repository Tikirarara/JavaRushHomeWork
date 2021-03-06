package com.javarush.test.level21.lesson08.task01;

import java.util.LinkedHashMap;
import java.util.Map;

/* Глубокое клонирование карты
Клонируйтие объект класса Solution используя глубокое клонирование.
Данные в карте users также должны клонироваться.
Метод main изменять нельзя.
*/
public class Solution implements Cloneable
{

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try
        {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

            System.out.println("!!!");
            System.out.println(solution.users.get("Hubert").name);
            System.out.println(clone.users.get("Hubert").name);
            clone.users.get("Hubert").name = "Mor";
            System.out.println(solution.users.get("Hubert").name);
            System.out.println(clone.users.get("Hubert").name);


        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable
    {
        int age;
        String name;

        public User(int age, String name)
        {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            return super.clone();
        }
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException
    {
        Solution sol = new Solution();
        for (User u : users.values())
        {
            User copy = (User) u.clone();
            sol.users.put(copy.name, copy);
        }
        return sol;
    }
}
