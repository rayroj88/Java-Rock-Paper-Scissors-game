/** 
 * Group authors and their NetIDs.
 * Ray Rojas xvc3
 * John Yamamoto JMY40
 * Joseph Sheraden-Urrutia jas759
 * Luis Herrera lah136
 * 
 * 
 */
package Project3;

/**
 * The FireballScroll class represents an ability that allows the character to cast fireballs.
 * It implements the Abilities interface to provide methods for calculating damage.
 * It graphical effects associated with the ability.
 */
public class FireballScroll implements Abilities {
    //calculateDamage from the Abilities interface
    public int calculateDamage(int hit) {
        return PERCENT - hit; // Calculation for the damage
    }

    // graphicalEffect from the Abilities interface
    public String graphicEffect() {
        // Print to console
        return "A large ball of flame hurtles toward the target.";
    }

    /**
     * Outputs a message stating that the mage's fireball
     * has rebounded into their scroll
     */ 
    public String failureGraphic() {
        return "Fireball rebounds into the mage's scroll.";
    }
}

