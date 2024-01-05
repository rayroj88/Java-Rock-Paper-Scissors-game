/** 
 * Group authors and their NetIDs.
 * Ray Rojas xvc3
 * John Yamamoto JMY40
 * Joseph Sheraden-Urrutia jas759
 * Luis Herrera lah136
 * 
 */
package Project3;

/**
 * The FighterCharacter class represents a character with defensive abilities, extending the BaseCharacter class.
 * It equips a Shield for defense.
 */
public class FighterCharacter extends BaseCharacter{
    // The fighter's primary combat ability.
    private ShieldDefense shield;

    /**
     * Constructs a Fighter Character with default attributes
     * and equips a Shield.
     */
    public FighterCharacter() {
        hitPoints = 150; 
        armorType = "heavy";
        shield = new ShieldDefense();
    }

    /**
     * Returns the class type for the fighter.
     * @return The character class type.
     */ 
    public String getClassType() {
        return "Fighter";
    }

    /**
     * Returns the FighterCharacter's ShieldDefense ability.
     * @return The ShieldDefense instance.
     */
    public ShieldDefense getShieldDefense() {
        return shield;
    }
}

