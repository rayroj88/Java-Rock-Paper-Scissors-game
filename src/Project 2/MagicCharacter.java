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
    * The MagicCharacter class represents a character with magical abilities, extending the BaseCharacter class.
    * It equips a FireballScroll and provides information about the character's class type.
    */

public class MagicCharacter extends BaseCharacter {
    private FireballScroll fireball;

    /**
     * Constructs a MagicCharacter with default attributes and equips a FireballScroll.
     */
    public MagicCharacter() {
        this.setHitPoints(70);
        this.setArmorType("light");
        this.fireball = new FireballScroll();
	}

    /**
     * @return The character class type.
    */ 
    public String getClassType() {
        return "Magic";
    }
    /**
     * Getter for the FireballScroll instance.
     * @return The FireballScroll instance.
     */
    public FireballScroll getFireballScroll() {
        return fireball;
    }
}

