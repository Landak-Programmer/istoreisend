package Q1.weapon;

import Q1.attribute.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class WeaponBuilder {

    private final Logger LOGGER = LoggerFactory.getLogger(WeaponBuilder.class);

    private final List<Attribute> attributeList = new ArrayList<>();

    public Weapon buildTest() {
        return new TestWeapon(attributeList);
    }

    public WeaponBuilder withAttr(String attr) {
        switch (attr) {
            case "att":
                attributeList.add(new ATT());
                break;
            case "acc":
                attributeList.add(new ACC());
                break;
            case "str":
                attributeList.add(new STR());
                break;
            case "dex":
                attributeList.add(new DEX());
                break;
            case "int":
                attributeList.add(new INT());
                break;
            default:
                LOGGER.debug("No such attribute name {}", attr);
        }
        return this;
    }
}
