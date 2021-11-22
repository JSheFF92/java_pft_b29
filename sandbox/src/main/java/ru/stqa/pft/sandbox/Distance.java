package ru.stqa.pft.sandbox;

public class Distance {

    public static void main(String[] args) {
        hello("Алексей");

        Point point1 = new Point(1, 4);
        Point point2 = new Point(2, 7);

        System.out.println("Расстояние между двумя точками с координатами " + point1.x + ", " + point1.y + " и " + point2.x + ", " + point2.y + " = " + distance(point1, point2));

    }

    public static double distance(Point point1, Point point2) {
        double dx = point1.x - point2.x;
        double dy = point1.y - point2.y;
        double r = Math.pow(dx, 2) + Math.pow(dy, 2);
        return Math.sqrt(r);

    }

    public static void hello(String name) {
        System.out.println("Здравствуйте, "+ name + "!");

    }
}