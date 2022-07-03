package Q6.queue;

import Q6.entity.MockDataRequest;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MockQueue {

    private final Queue<MockDataRequest> queue = new ConcurrentLinkedQueue<>();

    public void queue(MockDataRequest t) {
        queue.add(t);
    }

    public MockDataRequest peek() {
        return queue.peek();
    }

    public MockDataRequest remove() {
        return queue.remove();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
