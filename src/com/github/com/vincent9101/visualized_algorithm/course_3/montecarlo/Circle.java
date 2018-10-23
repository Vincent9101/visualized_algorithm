package com.github.com.vincent9101.visualized_algorithm.course_3.montecarlo;

import java.awt.*;

public class Circle {
    private int x,y,r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public boolean IsContained(Point p){
        return Math.pow(p.getX()-x,2)+Math.pow(p.getY()-y,2)<=r*r;
    }
    public Circle() {
    }

}
