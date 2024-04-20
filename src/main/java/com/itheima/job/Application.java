package com.itheima.job;

abstract class Geometry {
    abstract double getArea();
}

class Circle extends Geometry {
    double r;

    Circle(double r) {
        this.r = r;
    }

    @Override
    double getArea() {
        return Math.PI * r * r;
    }
}

class Triangle extends Geometry {
    double a, b, c;

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getArea() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

class Pillar {
    Geometry bottom;
    double height;

    Pillar(Geometry bottom, double height) {
        this.bottom = bottom;
        this.height = height;
    }

    double getSurfaceArea() {
        return bottom.getArea() * 2 + bottom.getArea() * height;
    }
}

public class Application {
    public static void main(String[] args) {
        Pillar pillar1 = new Pillar(new Circle(2), 10);
        System.out.println("以半径2为底的圆柱的表面积为：" + pillar1.getSurfaceArea());

        Pillar pillar2 = new Pillar(new Triangle(1, 1, 1), 10);
        System.out.println("三角形三边长度为1的三棱柱的表面积为：" + pillar2.getSurfaceArea());
    }
}