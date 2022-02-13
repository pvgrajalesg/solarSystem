package com.galaxy.solarSystem.useCase.util;

import com.galaxy.solarSystem.model.Point;

import java.util.List;

public class Calculation {

    private static Point sunPoint = new Point(0,0);

    public static boolean isAlignedWithSun(List<Point> positionsPlanets){

        boolean alignedPoints123 = isThreePointsAligned(positionsPlanets.get(0), positionsPlanets.get(1), positionsPlanets.get(2));
        boolean alignedPointsSun12 = isThreePointsAligned(sunPoint, positionsPlanets.get(0), positionsPlanets.get(1));

        if(alignedPoints123 && alignedPointsSun12){
            return true;
        }

        return false;
    }

    public static boolean isAlignedWithoutSun(List<Point> positionsPlanets){

        boolean alignedPoints123 = isThreePointsAligned(positionsPlanets.get(0), positionsPlanets.get(1), positionsPlanets.get(2));
        boolean alignedPointsSun12 = isThreePointsAligned(sunPoint, positionsPlanets.get(0), positionsPlanets.get(1));

        if(alignedPoints123 && !alignedPointsSun12){
            return true;
        }

        return false;
    }

    private static boolean isThreePointsAligned (Point point1, Point point2, Point point3){


        double condition1 = ((point2.getY() - point1.getY())/(point2.getX() - point1.getX()));
        double condition2 = (point3.getY() - point2.getY())/(point3.getX() - point2.getX());

        if(condition1 == condition2){
            return true;
        }

        return false;

    }

    public static boolean isTriangle(List<Point> positionsPlanets, int day){

        double triangleOrientation123 = triangleOrientation(positionsPlanets.get(0), positionsPlanets.get(1), positionsPlanets.get(2));
        double triangleOrientationSun12 = triangleOrientation(sunPoint, positionsPlanets.get(0), positionsPlanets.get(1));
        double triangleOrientationSun13 = triangleOrientation(sunPoint, positionsPlanets.get(0), positionsPlanets.get(2));
        double triangleOrientationSun23 = triangleOrientation(sunPoint, positionsPlanets.get(1), positionsPlanets.get(2));

        if((triangleOrientation123 >= 0 && triangleOrientationSun12 >= 0 && triangleOrientationSun13 >= 0 && triangleOrientationSun23 >= 0)
                || (triangleOrientation123 <= 0 && triangleOrientationSun12 <= 0 && triangleOrientationSun13 <= 0 && triangleOrientationSun23 <= 0)){
            return true;
        }

        return false;

    }

    //Se calcula la orientación del triangulo
    // (A1.x - A3.x) * (A2.y - A3.y) - (A1.y - A3.y) * (A2.x - A3.x)
    private static double triangleOrientation(Point positionPlanet1, Point positionPlanet2, Point positionPlanet3){

        double triangleOrientation = ((positionPlanet1.getX() - positionPlanet3.getX()) *
                (positionPlanet2.getY() - positionPlanet3.getY()))
                - ((positionPlanet1.getY() - positionPlanet3.getY()) *
                (positionPlanet2.getX() - positionPlanet3.getX()));

        return triangleOrientation;
    }
}
