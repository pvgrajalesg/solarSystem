package com.galaxy.solarSystem.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = Point.class)
public class PointTest {

    @Test
    public void distanceBeetweenTwoPoints(){

        Point point1 = new Point(1,1);
        Point point2 = new Point(0,0);

        double distance = point2.distance(point1);

        Assertions.assertEquals(distance, 1.41);

    }
}
