package ru.stqa.pft.sandbox;

import static ru.stqa.pft.sandbox.PointDistance.distance;

public class Distance {

        public static void main(String[] args) {

            //не внутри функции задавать параметры, а отдельно. вызывая эту функцию) .distance()
            System.out.println("Площадь прямоугольника равна " +
                    distance(new PointDistance.Point(10,10), new PointDistance.Point(20,20))
            );
        }
    }