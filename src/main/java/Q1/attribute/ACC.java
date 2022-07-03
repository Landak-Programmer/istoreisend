package Q1.attribute;

import Q1.improvement.Improvement;
import Q1.improvement.StaticAttrImprovement;

public class ACC extends BaseAttribute {

    private final Improvement<Integer> improvement;

    public ACC() {
        this.baseValue = initBaseValue();
        this.value = baseValue;
        this.improvement = new StaticAttrImprovement();
    }

    @Override
    protected Improvement<Integer> getImprovement() {
        return improvement;
    }
}
