package Q1.attribute;

import Q1.improvement.DynamicAttrImprovement;
import Q1.improvement.Improvement;

public class DEX extends BaseAttribute {

    private final Improvement<Integer> improvement;

    public DEX() {
        this.baseValue = initBaseValue();
        this.value = baseValue;
        this.improvement = new DynamicAttrImprovement();
    }

    @Override
    protected Improvement<Integer> getImprovement() {
        return improvement;
    }
}
