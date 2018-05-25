package channel;

import lombok.extern.slf4j.Slf4j;
import request.Request;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
public class TestChannel implements Channel {

    private static final int MAX_REQUEST = 100;

    private BlockingQueue<Request> requestQueue;

    public TestChannel() {
        this.requestQueue = new LinkedBlockingQueue<>(MAX_REQUEST);
    }

    @Override
    public Request getRequest() {
        Request req = null;
        try {
            req = requestQueue.take();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return req;
    }

    @Override
    public void putRequest(Request request) {
        try {
            requestQueue.put(request);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
