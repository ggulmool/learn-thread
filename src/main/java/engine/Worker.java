package engine;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Worker implements Runnable {

    private final String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        log.info(Thread.currentThread().getName() + " executes " + this);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "[ Worker : " + name + " ]";
    }
}
