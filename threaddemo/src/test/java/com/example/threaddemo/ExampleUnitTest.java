package com.example.threaddemo;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private Stack<Integer> stack = new Stack<>();

    @Test
    public void addition_isCorrect() throws InterruptedException {
        for (int i = 100; i > 0; i--)
            stack.push(i);
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        MyThread threadA = new MyThread("A", a, c);
        MyThread threadB = new MyThread("B", b, a);
        MyThread threadC = new MyThread("C", c, b);

        threadA.start();
        Thread.sleep(10);
        threadB.start();
        Thread.sleep(10);
        threadC.start();
    }

    class MyThread extends Thread {
        private String name;
        private Object self;
        private Object pre;

        MyThread(String name, Object self, Object pre) {
            this.name = name;
            this.self = self;
            this.pre = pre;
        }

        @Override
        public void run() {
            while (!stack.isEmpty()) {
                synchronized (pre) {
                    synchronized (self) {
                        System.out.println(name + "--" + stack.pop());
                        self.notify();
                    }
                    try {
                        if (stack.isEmpty())
                            pre.notify();
                        else
                            pre.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}