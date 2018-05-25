package main;

import channel.Channel;
import channel.TestChannel;
import engine.WorkerManager;
import task.ClientThread;

public class Main {

    public static void main(String[] args) {
        Channel channel = new TestChannel();

        new ClientThread("Tester1", channel).start();
        new ClientThread("Tester2", channel).start();

        WorkerManager workerManager = new WorkerManager();
        workerManager.setChannels(channel);
        workerManager.start();
    }
}
