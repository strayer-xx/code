package com.yingjie.other;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * <p>Title: AlternatePrint</p>
 * <p>Description: </p>
 *
 * @author LiuYingjie
 * @version 1.0
 * @date 2023/4/3 9:31
 */
public class AlternatePrint {

    public static void main(String[] args) {
        new AlternatePrint().alternatePrint();

    }

    private ReentrantLock lock = new ReentrantLock();
    private final Condition signA = lock.newCondition();
    private final Condition signB = lock.newCondition();
    private final Condition signC = lock.newCondition();

    private volatile char flag = 'A';

    public void alternatePrint() {
        Thread a = new Thread(new PrintA());
        Thread b = new Thread(new PrintB());
        Thread c = new Thread(new PrintC());
        a.start();
        b.start();
        c.start();
    }

    public class PrintA implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                while (true) {
                    // 避免虚假唤醒
                    while (flag != 'A') {
                        signA.await();
                    }
                    System.out.println("A");
                    flag = 'B';
                    signB.signalAll();
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }
    }

    public class PrintB implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                while (true) {
                    while (flag != 'B') {
                        signB.await();
                    }
                    System.out.println("B");
                    flag = 'C';
                    signC.signalAll();
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public class PrintC implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                while (true) {
                    while (flag != 'C') {
                        signC.await();
                    }
                    System.out.println("C");
                    flag = 'A';
                    signA.signalAll();
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
