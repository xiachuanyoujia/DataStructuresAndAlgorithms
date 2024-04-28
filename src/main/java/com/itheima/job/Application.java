package com.itheima.job;

abstract class Geometry {
    abstract double getArea();
    abstract double getLength();
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

    @Override
    double getLength() {
        return 2 * Math.PI * r;
    }
}

class Triangle extends Geometry {
    double bottom, height;

    Triangle(double bottom, double height) {
        this.bottom = bottom;
        this.height = height;
    }

    @Override
    double getArea() {
        return 0.5 * bottom * height;
    }

    @Override
    double getLength() {
        return bottom + 2 * Math.sqrt(Math.pow(height, 2) + Math.pow(bottom / 2, 2));
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
        return bottom.getArea() * 2 + bottom.getLength() * height;
    }
}

public class Application {
    public static void main(String[] args) {
        Pillar pillar1 = new Pillar(new Circle(2), 10);
        System.out.println("以半径2为底的圆柱的表面积为：" + pillar1.getSurfaceArea());

        Pillar pillar2 = new Pillar(new Triangle(2, 1), 10);
        System.out.println("三角形底为2高为1的三棱柱的表面积为：" + pillar2.getSurfaceArea());
    }
}