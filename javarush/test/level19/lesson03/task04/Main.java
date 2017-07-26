package com.javarush.test.level19.lesson03.task04;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException, ParseException
    {
        Scanner sc = new Scanner(new File("C:/Users/osas/Desktop/JavaRushHomeWork/Daria.txt"));

        PersonScanner ps = new Solution.PersonScannerAdapter(sc);
        System.out.println(ps.read().toString());
    }
}
