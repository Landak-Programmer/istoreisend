package Q1.attribute;

import Q1.improvement.Improvement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseAttribute implements Attribute {

    private final Logger LOGGER = LoggerFactory.getLogger(BaseAttribute.class);

    protected Integer value;
    protected Integer baseValue;

    @Override
    public Integer getBaseValue() {
        return baseValue;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void improve() {
        Integer oldVal = value;
        if (value > 0) {
            value = getImprovement().improve(value);
        }
        LOGGER.info("{} attribute improve from {} to {}", this.getClass().getSimpleName(), oldVal, value);
    }

    protected abstract Improvement<Integer> getImprovement();
}
