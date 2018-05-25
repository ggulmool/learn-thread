package engine;

import channel.Channel;
import lombok.extern.slf4j.Slf4j;
import request.Request;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Slf4j
public class WorkerManager {

    private static final int THREAD_POOL_CNT = 10;

    private boolean isAlive = true;
    private List<Channel> channels;
    private ExecutorService executorService;

    public WorkerManager() {
        this.executorService = Executors.newFixedThreadPool(THREAD_POOL_CNT);
    }

    public void setChannels(Channel ... channels) {
        this.channels = Arrays.stream(channels).collect(Collectors.toList());
    }

    public void addChannel(Channel channel) {
        this.channels.add(channel);
    }

    public void start() {
        while (isAlive) {
            for (Channel channel : channels) {
                Request request = channel.getRequest();
                executorService.submit(new Worker(request.getName()));
            }
        }
    }

    public void stop() {
        isAlive = false;
    }
}
