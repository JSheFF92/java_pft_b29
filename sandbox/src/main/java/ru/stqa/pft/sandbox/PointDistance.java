package ru.stqa.pft.sandbox;

public class PointDistance {
    public static double distance(Point point1, Point point2) {
        double dx = point1.x - point2.x;
        double dy = point1.y - point2.y;
        double r = Math.pow(dx, 2) + Math.pow(dy, 2);
        return Math.sqrt(r);
    }

    public static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

}
