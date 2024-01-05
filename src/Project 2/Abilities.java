/** 
 * Group authors and their NetIDs.
 * Ray Rojas xvc3
 * John Yamamoto JMY40
 * Joseph Sheraden-Urrutia jas759
 * Luis Herrera lah136
 * 
 * 
 */
package Project2;

    /** 
     * The Abilities interface represents the capabilities of an in-game character's abilities.
     * Implementing classes are expected to provide concrete functionality for these abilities.
     */

public interface Abilities {
    /**
     * The constant 100 for percentage calculations.
     */
    final int PERCENT = 100;

    /**
     * Calculate the damage dealt by an ability based on a hit value.
     * @param hit The hit value used for damage calculation.
     */
    int calculateDamage(int hit);

    /**
     * Apply a graphical effect associated with the ability.
     */
    void graphicEffect();
}



