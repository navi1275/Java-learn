import com.navi.concurrent.ArrayQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * ArrayQueueTest Class
 *
 * @author navi
 * @date 2019-04-10
 * @since 1.0.0
 */

@RunWith(JUnit4.class)
public class ArrayQueueTest {

    @Test
    public void test(){
        ArrayQueue<String> aq = new ArrayQueue(3);
        aq.put("123");
        aq.put("1234");
        aq.put("12345");

        System.out.println("size: " + aq.size());

        while (!aq.isEmpty()){
            System.out.println(aq.get());
        }
    }

    @Test
    public void test1(){
        ArrayQueue<String> aq = new ArrayQueue(3);

        new Thread(()->{
            System.out.println("线程[ " + Thread.currentThread().getName() + " ]消费队列：" + aq.get());
        }).start();

        aq.put("123");
        aq.put("1234");
        aq.put("12345");
        aq.put("123456");

        System.out.println("size: " + aq.size());

        while (!aq.isEmpty()){
            System.out.println(aq.get());
        }
    }

    @Test
    public void test2() throws InterruptedException {
        ArrayQueue<String> aq = new ArrayQueue(300);



        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++){
                aq.put(i+"");
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++){
                aq.put(i+"");
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 100; i++){
                aq.put(i+"");
            }
        });

        new Thread(()->{
            System.out.println("线程[ " + Thread.currentThread().getName() + " ]消费队列：" + aq.get());
        }).start();

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();


        System.out.println("size: " + aq.size());


    }
}
