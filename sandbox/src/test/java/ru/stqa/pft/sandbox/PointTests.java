package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;




    public class PointTests {
        @Test
        public void testPoint1() {
            PointMine p1 = new PointMine(10, 10);
            PointMine p2 = new PointMine(20, 20);

            Assert.assertEquals(p1.distance(p2), 14.142135623730951);
        }

        @Test
        public void testPoint2() {
            PointMine p1 = new PointMine(5, 50);
            PointMine p2 = new PointMine(8, 8);

            Assert.assertEquals(p1.distance(p2), 42.1070065428546);
        }

        @Test
        public void testPoint3() {

            PointMine p1 = new PointMine(8, 8);
            PointMine p2 = new PointMine(9, 11);

            Assert.assertEquals(p1.distance(p2), 3.1622776601683795);        }
    }