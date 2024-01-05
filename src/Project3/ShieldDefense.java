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
 * The ShieldDefense class represents an ability that allows the character to use ShieldDefenses.
 * It implements the Abilities interface to provide methods for calculating damage.
 * It graphical effects associated with the ability.
 */
public class ShieldDefense implements Abilities {
     /**
     * Calculates the damage dealt to the fighter's opponent when
     * the ability is used.
     * @param hit The damage dealt to the target.
    */
    public int calculateDamage(int hit) {
        return PERCENT - hit; // Calculation for the damage
    }

    /**
     * Displays a message indicating that the ShieldDefense ability
     * has been used.
     */
    public String graphicEffect() {
        return "The Shield rebounds the attack.";
    }

    /**
     * Outputs a message stating that the fighter's shield
     * has been dropped.
     */ 
    public String failureGraphic() {
        return"Shield is dropped as the fighter falls asleep.";
    }
}

