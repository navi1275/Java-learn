package com.navi.create.factory;

/**
 * Test Class
 *
 * @author ganxf
 * @date 2019-11-15
 */
public class Test {

    public static void main(String[] args) {

        Shape shape = Factory.buildShape("Circle");
        shape.draw();
        Shape shape1 = Factory.buildShape("Rectangle");
        shape1.draw();
        Shape shape2 = Factory.buildShape("Square");
        shape2.draw();
    }
}
