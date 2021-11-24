package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import static ru.stqa.pft.sandbox.Distance.distance;


    public class PointTests {
        @Test
        public void testPoint1() {
            Point point1 = new Point(1, 4);
            Point point2 = new Point(2, 7);
            Assert.assertEquals(distance(point1, point2), 3.1622776601683795);
        }

        @Test
        public void testPoint2() {
            Point point1 = new Point(5, 5);
            Point point2 = new Point(5, 5);
            Assert.assertEquals(distance(point1, point2), 0);
        }

        @Test
        public void testPoint3() {
            Point point1 = new Point(1, 4);
            Point point2 = new Point(2, 7);
            Assert.assertEquals(distance(point1, point2), 3.1622776601683795);
        }
    }