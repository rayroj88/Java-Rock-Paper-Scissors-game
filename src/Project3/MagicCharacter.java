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
 * The MagicCharacter class represents a character with magical abilities, extending the BaseCharacter class.
 * It equips a FireballScroll and provides information about the character's class type.
 */
public class MagicCharacter extends BaseCharacter {
    // The mage's primary combat ability.
    private FireballScroll fireball;

    /**
     * Constructs a MagicCharacter with default attributes
     * and equips a FireballScroll.
     */
    public MagicCharacter() {
        hitPoints = 70; 
        armorType = "light";
        fireball = new FireballScroll();
    }

    /**
     * Returns the class type for the mage.
     * @return The character class type.
     */ 
    public String getClassType() {
        return "Magic";
    }

    /**
     * Returns the MagicCharacter's FireballScroll ability.
     * @return The FireballScroll instance.
     */
    public FireballScroll getFireballScroll() {
        return fireball;
    }
}

