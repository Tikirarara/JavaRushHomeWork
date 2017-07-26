package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome
{
    public ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            move();
            print();
            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {
                System.out.println("Thread problems");
            }
        }
    }

    public void move()
    {
        for (Horse horse : horses)
        {
            horse.move();
        }
    }

    public void print()
    {
        for (Horse horse : horses)
        {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner()
    {
        Horse winner = horses.get(0);
        for (int i = 1; i < horses.size(); i++)
        {
            if (Math.round(winner.getDistance()) < Math.round(horses.get(i).getDistance()))
                winner = horses.get(i);
        }
        return winner;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }


    public static void main(String[] args)
    {
        game = new Hippodrome();
        Horse plotva = new Horse("Plotva", 3, 0);
        Horse binki = new Horse("Binki", 3, 0);
        Horse smolka = new Horse("Smolka", 3, 0);

        game.getHorses().add(plotva);
        game.getHorses().add(binki);
        game.getHorses().add(smolka);

        game.run();
        game.printWinner();
    }
}
