package task;

import channel.Channel;
import lombok.extern.slf4j.Slf4j;
import request.Request;

import java.util.Random;

@Slf4j
public class ClientThread extends Thread {

    private static final Random random = new Random();

    private Channel channel;

    public ClientThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    public void run() {
        try {
            for (int i = 0; true; i++) {
                Request request = new Request(getName() + "-Request" + i);
                channel.putRequest(request);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
