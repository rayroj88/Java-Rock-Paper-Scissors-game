/** 
 * Group authors and their NetIDs.
 * Ray Rojas xvc3
 * John Yamamoto JMY40
 * Joseph Sheraden-Urrutia jas759
 * Luis Herrera lah136 
 */
package Project3;

/**
 * The LuteMusic class represents an ability that lulls an enemy to sleep.
 * It implements the Abilities interface.
 */
public class LuteMusic implements Abilities {
    /**
     * Calculates the damage dealt to the bard's opponent when
     * the ability is used.
     * @param hit The damage dealt to the target.
     */
    public int calculateDamage(int hit) {
        return PERCENT - hit;
    }

    /**
     * Outputs a message to the console stating that the lullaby
     * has made the enemy combatant sleepy.
     */
    public String graphicEffect() {
        return "The lullaby makes the combatant sleepy.";
    }

    /**
     * Outputs a message stating that the bard's lute has been
     * engulfed in flames.
     */ 
    public String failureGraphic() {
        return "Lute is engulfed in flames.";
 
    }
}

