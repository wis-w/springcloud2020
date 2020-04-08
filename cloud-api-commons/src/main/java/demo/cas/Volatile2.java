package demo.cas;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/8 19:44
 */

import java.util.concurrent.TimeUnit;

/**
 * Volatile关键字可见性证明
 */
public class Volatile2 {

    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(()->{
            System.out.println("****start");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.test();
            System.out.println("****end");
        }).start();

        while (myData.flag == 0) {
            // 阻碍main线程结束
        }
        System.out.println("main线程结束"+myData.flag);
    }
}

class MyData {
    volatile int flag = 0;
    public void test(){
        flag = 1;
    }
}
