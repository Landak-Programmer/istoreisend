package Q6.external;

import Q6.entity.MockDataRequest;
import Q6.entity.MockDataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class MockExternalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MockExternalService.class);

    private static final int INTERMITTEN_FREQUENCY = 5;

    public static MockDataResponse doAPICall(final MockDataRequest mockDataRequest) throws Exception {
        LOGGER.info("Calling external API. Request {}", mockDataRequest);
        final Random r = new Random();
        int randInt = r.nextInt(10);
        if (randInt < INTERMITTEN_FREQUENCY) {
            // we assume this is 500, and API err
            LOGGER.warn("Failed to call external API. Request {}", mockDataRequest);
            throw new Exception("System down");
        }
        final MockDataResponse res = new MockDataResponse(1L, "success");
        LOGGER.info("Successful external API. Request {}", res);
        return res;
    }
}
