package Q6.entity;

import lombok.Data;

@Data
public class MockDataRequest {

    public MockDataRequest(Long startTime, Long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.retry = 0;
    }

    // in millis
    private Long startTime;
    private Long endTime;
    private int retry;
}
