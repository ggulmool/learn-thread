package channel;

import request.Request;

public interface Channel {

    Request getRequest();

    void putRequest(Request request);
}
