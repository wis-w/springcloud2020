package demo.cas;

import java.util.concurrent.TimeUnit;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/9 17:35
 */
public class Volatile3 {
    public static void main(String[] args) {
        myData my = new myData();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            my.addValue();
            System.out.println("测试线程1结束");
        }).start();
        while (my.value==0){}
        System.out.println("main线程结束第一步骤");
    }
}
class myData{
    public volatile int value = 0;
    public void addValue(){
        value++;
    }
}
