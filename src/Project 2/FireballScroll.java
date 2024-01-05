   /*Ray Rojas xvc3
    * John Yamamoto JMY40
    * Joseph Sheraden-Urrutia jas759
    * Luis Herrera lah136
    */
package Project2;
   /**
    * The FireballScroll class represents an ability that allows the character to cast fireballs.
    * It implements the Abilities interface to provide methods for calculating damage.
    * It graphical effects associated with the ability.
    */
public class FireballScroll implements Abilities {
  
    //calculateDamage from the Abilities interface
    /**
     * Calculate the damage dealt by an ability based on a hit value.
     * @param hit The hit value used for damage calculation.
     */
    @Override
    public int calculateDamage(int hit) {
        return PERCENT - hit; // Calculation for the damage
    }

    // graphicalEffect from the Abilities interface
    /**
     * Apply a graphical effect associated with the ability.
     */
    @Override
    public void graphicEffect() {
        // Print to console
        System.out.println("A large ball of flame hurtles toward the target.");
    }
