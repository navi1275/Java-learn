package com.navi.create.absfactory;

/**
 * Test Class
 *
 * @author ganxf
 * @date 2019-11-15
 */
public class Test {

    public static void main(String[] args) {

        PcFactory factory = new DeilFactory();
        Mouse mouse = factory.createMouse();
        mouse.desc();
        Keybo keybo = factory.createKeybo();
        keybo.desc();

        PcFactory factory1 = new HpFactory();
        Mouse mouse1 = factory1.createMouse();
        mouse1.desc();
        Keybo keybo1 = factory1.createKeybo();
        keybo1.desc();
    }
}
