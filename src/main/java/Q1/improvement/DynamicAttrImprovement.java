package Q1.improvement;

import java.util.Random;

public class DynamicAttrImprovement implements Improvement<Integer> {

    private final Double MAX_POTENTIAL_STATS = 40.0;

    /**
     * @param value
     * @return
     */
    @Override
    public Integer improve(Integer value) {
        final Integer maxEnhancement = getHighestPossibleEnhancement(value);
        Integer improvementVal = 0;
        for (int i = maxEnhancement; i > 0; i--) {
            if (successEnhancement(value)) {
                improvementVal = i;
                break;
            }
        }
        return value + improvementVal;
    }

    /**
     * @param value
     * @return assuming max level = 5
     * and highest base stats = 15
     * and highest potential upgrade value 5 per level
     */
    private Integer getHighestPossibleEnhancement(Integer value) {
        if ((value / MAX_POTENTIAL_STATS) > 5) {
            return 5;
        } else {
            double hi = (value / MAX_POTENTIAL_STATS) * 5;
            return (int) hi;
        }
    }

    /**
     * @param value
     * @return assuming max level = 5
     * and highest base stats = 15
     * and highest potential upgrade value 5 per level
     */
    private boolean successEnhancement(Integer value) {
        final Random r = new Random();
        final int randComLimit = (int) (MAX_POTENTIAL_STATS - value);
        if (randComLimit <= 0) {
            return true;
        }
        // what does this mean, higher value, lower maximum random chances
        final int successCondition = r.nextInt((int) (MAX_POTENTIAL_STATS - value));
        final int staticEnhancementChancesVar = 10;
        return successCondition <= staticEnhancementChancesVar;
    }
}
