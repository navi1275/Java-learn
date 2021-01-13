package com.navi.create.factory;

/**
 * Factory Class
 *
 * @author ganxf
 * @date 2019-11-14
 */
public class Factory {

    public static Shape buildShape(String name){
        Shape shape = null;
        if("Circle".equals(name)){
            shape = new Circle();
        }else if("Rectangle".equals(name)){
            shape = new Rectangle();
        }else if("Square".equals(name)){
            shape = new Square();
        }
        return shape;
    }
}
