package Q6.entity;

import lombok.Data;

@Data
public class MockDataResponse {

    public MockDataResponse(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    private Long id;
    private String data;
}
