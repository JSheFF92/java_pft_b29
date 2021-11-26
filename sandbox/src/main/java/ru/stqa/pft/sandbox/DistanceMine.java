package ru.stqa.pft.sandbox;


public class DistanceMine {

    public static void main(String[] args) {
        hello("Алексей");

        PointMine p1 = new PointMine(8, 8);
        PointMine p2 = new PointMine(9, 11);
        System.out.println("Расстояние между двумя точками = " + p1.x +", "+ p1.y + " и " + p2.x + ", " + p2.y + " = " + p1.distance(p2));

    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }
}
