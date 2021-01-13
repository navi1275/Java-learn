package com.navi.create.absfactory;

import java.math.BigDecimal;

/**
 * DeilFactory Class
 *
 * @author ganxf
 * @date 2019-11-15
 */
public class DeilFactory implements PcFactory {

    @Override
    public Mouse createMouse() {
        return new DeilMouse();
    }

    @Override
    public Keybo createKeybo() {
        return new DeilKeybo();
    }

}
