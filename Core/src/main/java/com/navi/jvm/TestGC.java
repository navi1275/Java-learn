package com.navi.jvm;

/**
 * TestPretenureSizeThreashold Class
 *
 * @author ganxf
 * @date 2019-12-25
 */
public class TestGC {

    private static final int N1MB = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {

        testAllocation();
        // testPretenureSizeThreashold();

    }

    private static void testAllocation(){
        byte[] allocation1,allocation2,allocation3,allocation4,allocation5,allocation6;
        allocation1 = new byte[2 * N1MB];
        allocation2 = new byte[2 * N1MB];
        allocation3 = new byte[2 * N1MB];
        allocation4 = new byte[4 * N1MB];
        allocation5 = new byte[1 * N1MB];

    }

    private static void  testPretenureSizeThreashold() throws InterruptedException {
        byte[] allocation;
        allocation = new byte[8 * N1MB];

        Thread.sleep(3 * 1000);
    }
}
