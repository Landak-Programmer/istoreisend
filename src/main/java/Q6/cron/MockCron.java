package Q6.cron;

import Q6.entity.MockDataRequest;
import Q6.external.MockExternalService;
import Q6.queue.MockQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockCron {

    private final Logger LOGGER = LoggerFactory.getLogger(MockCron.class);

    private final MockQueue mockQueue;

    private final int MAX_RETRY = 5;

    public MockCron(MockQueue mockQueue) {
        this.mockQueue = mockQueue;
    }

    public void startCron() {
        new Thread(() -> {
            while (true) {

                if (!mockQueue.isEmpty()) {
                    final MockDataRequest request = mockQueue.peek();
                    try {
                        MockExternalService.doAPICall(request);
                    } catch (Exception e) {
                        request.setRetry(request.getRetry() + 1);
                        if (request.getRetry() > MAX_RETRY) {
                            // in this case, we may want to do another handling
                            LOGGER.error("Removing request due to exceed maximum retry. Request {}", request);
                            mockQueue.remove();
                        }
                    }
                }

                try {
                    // example delay
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // do nothing
                }
            }
        }).start();
    }
}
