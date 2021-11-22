package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import static ru.stqa.pft.sandbox.Distance.distance;


    public class PointTests {
        @Test
        public void testPointTrue() {
            Point point1 = new Point(1, 4);
            Point point2 = new Point(2, 7);
            Assert.assertEquals(distance(point1, point2), 3.1622776601683795);
        }

        @Test
        public void testPointNotTrue() {
            Point point1 = new Point(1, 4);
            Point point2 = new Point(2, 7);
            Assert.assertEquals(distance(point1, point2), 4.1622776601683795);
        }
    }