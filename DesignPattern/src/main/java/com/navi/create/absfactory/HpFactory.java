package com.navi.create.absfactory;

/**
 * HpFactory Class
 *
 * @author ganxf
 * @date 2019-11-15
 */
public class HpFactory implements PcFactory {

    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keybo createKeybo() {
        return new HpKeybo();
    }
}
