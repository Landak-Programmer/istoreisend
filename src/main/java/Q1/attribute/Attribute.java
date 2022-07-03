package Q1.attribute;

import java.util.Random;

public interface Attribute {

    default Integer initBaseValue() {
        final Random r = new Random();
        // can go between 10 - 14 as base value
        return r.nextInt(5) + 10;
    }

    Integer getBaseValue();

    Integer getValue();

    void improve();

    default boolean isCap() {
        return getValue() > (getBaseValue() * 2);
    }
}
