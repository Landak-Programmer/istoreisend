package Q6;

import Q6.cron.MockCron;
import Q6.entity.MockDataRequest;
import Q6.external.MockExternalService;
import Q6.queue.MockQueue;

import java.util.Date;

public class Q6 {

    public static void main(String[] args) {
        final MockQueue mockQueue = new MockQueue();
        final MockCron mockCron = new MockCron(mockQueue);
        mockCron.startCron();

        final MockDataRequest mockDataRequest = new MockDataRequest(
                new Date().getTime(), new Date(System.currentTimeMillis() - 3600 * 1000).getTime());
        try {
            MockExternalService.doAPICall(mockDataRequest);
        } catch (Exception e) {
            mockQueue.queue(mockDataRequest);
        }
    }
}
