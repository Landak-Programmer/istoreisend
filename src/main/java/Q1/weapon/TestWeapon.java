package Q1.weapon;

import Q1.attribute.Attribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TestWeapon extends Weapon {

    private final Logger LOGGER = LoggerFactory.getLogger(Weapon.class);

    private Integer level;
    private final List<Attribute> attributes;

    public TestWeapon(List<Attribute> attributes) {
        level = 0;
        LOGGER.info("Weapon current level {}", level);
        this.attributes = attributes;
        attributes.forEach(attribute -> {
            LOGGER.info("Weapon base {} is {}", attribute.getClass().getSimpleName(), attribute.getValue());
        });
    }

    @Override
    public Integer getLevel() {
        return level;
    }

    @Override
    public void levelUp() {
        if (level < MAX_LEVEL) {
            attributes.forEach(Attribute::improve);
            LOGGER.info("Weapon new level {}", ++level);
        } else {
            LOGGER.info("Weapon is level cap");
        }
    }

    @Override
    public List<Attribute> getAttribute() {
        return attributes;
    }
}
