package com.galaxy.solarSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Point {

    private double x;
    private double y;

    /*
     * @return double
     * calcula la distancia a otro punto
     */
    public double distance (Point point){
        return Math.round(Math.sqrt(Math.pow(point.getX()-this.x, 2) + Math.pow(point.getY()-this.y, 2))*100.0)/100.0;
    }
}
