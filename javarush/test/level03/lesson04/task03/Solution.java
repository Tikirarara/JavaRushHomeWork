package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Zerg zerg1 = new Zerg();
        zerg1.name = "A";
        Zerg zerg2 = new Zerg();
        zerg2.name = "AA";
        Zerg zerg3 = new Zerg();
        zerg3.name = "AAA";
        Zerg zerg4 = new Zerg();
        zerg4.name = "AAAA";
        Zerg zerg5 = new Zerg();
        zerg5.name = "AAAAA";
        Zerg zerg6 = new Zerg();
        zerg6.name = "AAAAAA";
        Zerg zerg7 = new Zerg();
        zerg7.name = "AAAAAAA";
        Zerg zerg8 = new Zerg();
        zerg8.name = "AAAAAAAA";
        Zerg zerg9 = new Zerg();
        zerg9.name = "AAAAAAAAA";
        Zerg zerg10 = new Zerg();
        zerg10.name = "AAAAAAAAAA";

        Protos protos1 = new Protos();
        protos1.name = "B";
        Protos protos2 = new Protos();
        protos2.name = "BB";
        Protos protos3 = new Protos();
        protos3.name = "BBB";
        Protos protos4 = new Protos();
        protos4.name = "BBBB";
        Protos protos5 = new Protos();
        protos5.name = "BBBBB";

        Terran terran1 = new Terran();
        terran1.name = "C";
        Terran terran2 = new Terran();
        terran2.name = "CC";
        Terran terran3 = new Terran();
        terran3.name = "CCC";
        Terran terran4 = new Terran();
        terran4.name = "CCCC";
        Terran terran5 = new Terran();
        terran5.name = "CCCCC";
        Terran terran6 = new Terran();
        terran6.name = "CCCCCC";
        Terran terran7 = new Terran();
        terran7.name = "CCCCCCC";
        Terran terran8 = new Terran();
        terran8.name = "CCCCCCCC";
        Terran terran9 = new Terran();
        terran9.name = "CCCCCCCCC";
        Terran terran10 = new Terran();
        terran10.name = "CCCCCCCCCC";
        Terran terran11 = new Terran();
        terran11.name = "CCCCCCCCCCC";
        Terran terran12 = new Terran();
        terran12.name = "CCCCCCCCCCCC";


    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}