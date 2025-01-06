//Problem Link : https://leetcode.com/problems/print-in-order/

package Java.Easy;

import java.util.concurrent.CountDownLatch;

class Foo {
    // CountDownLatch is used to synchronize threads. It allows one thread to wait
    // until another thread completes its execution.
    private CountDownLatch latchForSecond;
    private CountDownLatch latchForThird;

    public Foo() {
        latchForSecond = new CountDownLatch(1);
        latchForThird = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        latchForSecond.countDown(); // Signal that the first method has finished
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Wait for latchForSecond to finish
        latchForSecond.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        latchForThird.countDown(); // Signal that second method has finished
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Wait for latchForThird to finish
        latchForThird.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}