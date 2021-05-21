package com.navi.concurrent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocalTest Class
 *
 * @author ganxf
 * @date 2021/5/13
 */
@RunWith(JUnit4.class)
public class ThreadLocalTest {

    @Test
    public void  test(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 1000; i++) {
            executor.execute(new ParseDate(i));
        }
    }
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static final ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>();
    static class ParseDate implements Runnable {

        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                // Date parse = sdf.parse("2020-05-13");
                if(tl.get() ==null){
                    tl.set(new SimpleDateFormat("yyyy-MM-dd"));
                }
                Date parse = tl.get().parse("2020-05-13");
                System.out.println(i + ":::" + parse);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
