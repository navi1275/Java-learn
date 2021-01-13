package com.navi.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * HeapOOM Class
 *
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDetails
 *
 * @author ganxf
 * @date 2019-12-24
 */
public class HeapOOM {

    static class OOMObj{

    }

    public static void main(String[] args) {
        List list = new ArrayList<Object>();
        for(;;){
            list.add(new OOMObj());
        }
    }
}
