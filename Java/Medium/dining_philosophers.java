//Problem Link: https://leetcode.com/problems/the-dining-philosophers/

package Java.Medium;

import java.util.concurrent.Semaphore;

class DiningPhilosophers {
    // Semaphores to represent the forks, allowing only one philosopher to use each
    // fork at a time
    private final Semaphore[] forks;
    // Semaphore to control how many philosophers can eat simultaneously, preventing
    // deadlock
    private final Semaphore eatLock;

    public DiningPhilosophers() {
        // Initialize the forks (5 forks for 5 philosophers)
        forks = new Semaphore[5];
        for (int i = 0; i < 5; i++) {
            // Each fork can only be used by one philosopher at a time
            forks[i] = new Semaphore(1);
        }
        // Only 1 philosopher can eat at a time
        eatLock = new Semaphore(1);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {
        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

        // Limit the number of philosophers eating simultaneously
        eatLock.acquire();

        // Acquire the left fork
        forks[leftFork].acquire();
        pickLeftFork.run();

        // Acquire the right fork
        forks[rightFork].acquire();
        pickRightFork.run();

        // Eat
        eat.run();

        // Put down the left fork
        putLeftFork.run();
        forks[leftFork].release();

        // Put down the right fork
        putRightFork.run();
        forks[rightFork].release();

        // Release eatLock to allow another philosopher to eat
        eatLock.release();
    }
}
