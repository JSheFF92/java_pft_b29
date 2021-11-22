package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import static ru.stqa.pft.sandbox.Distance.distance;

public class SquareTests {
    @Test
    public void testArea(){
        Square s = new Square(5);
        Assert.assertEquals(s.area(), 25);

    }
}

