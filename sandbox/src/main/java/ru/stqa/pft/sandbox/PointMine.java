package ru.stqa.pft.sandbox;

public class PointMine {

    public double x;
    public double y;

    public PointMine(double x1, double y1) {
        this.x = x1;
        this.y = y1;
    }

    public double distance(PointMine p2) {

        double dx = p2.x - this.x;
        double dy = p2.y - this.y;
        double r = Math.pow(dx, 2) + Math.pow(dy, 2);
        return Math.sqrt(r);

    }

}

