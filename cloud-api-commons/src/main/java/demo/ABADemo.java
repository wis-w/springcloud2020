package demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/17 8:11
 * t1、t2产生的ABA问题
 * t3、t4解决ABA问题
 */
public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {
        System.out.println("--------ABA问题产生start-----------");
        new Thread(()->{
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        },"ti").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2020) + "： t2 ：" + atomicReference.get());
        },"t2").start();
        System.out.println("--------ABA问题产生end-----------");


        System.out.println("--------ABA问题解决start-----------");
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3当前版本号：" + atomicStampedReference.getStamp() + ",当前值：" + atomicStampedReference.getReference());
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println("t3当前版本号：" + atomicStampedReference.getStamp() + ",当前值：" + atomicStampedReference.getReference());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println("t3当前版本号：" + atomicStampedReference.getStamp() + ",当前值：" + atomicStampedReference.getReference());
        },"t3").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t4当前版本号：" + stamp + ",当前值：" + atomicStampedReference.getReference());
            System.out.println(atomicStampedReference.compareAndSet(100, 101, stamp, atomicStampedReference.getStamp() + 1));
            System.out.println("t4当前版本号：" + atomicStampedReference.getStamp() + ",当前值：" + atomicStampedReference.getReference());
        },"t4").start();

        System.out.println("--------ABA问题解决end-----------");
    }
}
