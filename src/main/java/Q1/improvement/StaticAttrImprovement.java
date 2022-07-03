package Q1.improvement;

import java.util.Random;

public class StaticAttrImprovement implements Improvement<Integer> {

    @Override
    public Integer improve(Integer value) {
        final Random r = new Random();
        value = value + r.nextInt(6);
        return value;
    }
}
