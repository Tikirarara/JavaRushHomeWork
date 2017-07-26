package com.javarush.test.level03.lesson12.home02;

/* Я не хочу изучать Java, я хочу большую зарплату
Вывести на экран десять раз надпись «Я не хочу изучать Java, я хочу большую зарплату»
*/

public class Solution
{
    public static void main(String[] args)
    {
        print10Times("Я не хочу изучать Java, я хочу большую зарплату", 10);
    }
    public static void print10Times(String a, int i){
        for (i=0; i<10; i++){
            System.out.println(a);
        }
    }
}
