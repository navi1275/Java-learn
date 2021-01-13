package com.navi.jvm;

/**
 * JavaVMStackSOF Class
 * -Xss128k
 *
 * @author ganxf
 * @date 2019-12-24
 */
public class JavaVMStackSOF {

    private int stackLength = 0;

    private void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {

        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();

        }catch (Throwable e){
            e.printStackTrace();
            System.out.printf("JavaVM stack length: " + sof.stackLength);
        }

    }
}
