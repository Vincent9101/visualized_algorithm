package com.github.com.vincent9101.visualized_algorithm.course_1_circle;

import java.awt.*;

/**
 * TODO:注意圆之间的碰撞 2018.09.09
 */
public class Circle {
    public int x, y;
    private int r;
    public int vx, vy;
    public boolean isFilled;

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", vx=" + vx +
                ", vy=" + vy +
                '}';
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
        isFilled = false;
    }

    public void move(int minx, int miny, int maxx, int maxy) {
        x += vx;
        y += vy;
        checkCollision(minx, miny, maxx, maxy);
    }

    public void checkCollision(int minx, int miny, int maxx, int maxy) {
        if (x - r < minx) {
            x = r;
            vx = -vx;
        }
        if (x + r >= maxx) {
            x = maxx - r;
            vx = -vx;
        }
        if (y - r < miny) {
            y = r;
            vy = -vy;
        }
        if (y + r >= maxy) {
            y = maxy - r;
            vy = -vy;
        }

    }

    public boolean contain(Point point) {
        return Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2) <= r * r;
    }
}
