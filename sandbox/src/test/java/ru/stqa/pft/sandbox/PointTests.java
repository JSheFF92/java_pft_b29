package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;




    public class PointTests {
        @Test
        public void testPoint1() {

            Assert.assertEquals(PointDistance.distance(new PointDistance.Point(10,10), new PointDistance.Point(20,20)), 14.142135623730951);
        }

        @Test
        public void testPoint2() {
            Assert.assertEquals(PointDistance.distance(new PointDistance.Point(5,5), new PointDistance.Point(5,5)), 0);
        }

        @Test
        public void testPoint3() {

            Assert.assertEquals(PointDistance.distance(new PointDistance.Point(1,4), new PointDistance.Point(2,7)), 3.1622776601683795);
        }
    }