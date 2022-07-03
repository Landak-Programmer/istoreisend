package Q1;

import Q1.weapon.Weapon;
import Q1.weapon.WeaponBuilder;

public class Q1 {

    public static void main(String[] args) {
        // tester class
        Weapon testWeapon = new WeaponBuilder().withAttr("att").withAttr("str").buildTest();

        // we imagine each iteration, a monster defeated and a weapon level up
        for (int i = 0; i < 5; i++) {
            testWeapon.levelUp();
        }
    }
}
