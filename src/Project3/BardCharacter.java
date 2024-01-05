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
 * The BardCharacter class represents a character with Music abilities, extending the BaseCharacter class.
 * It equips a Lute for music.
 */
public class BardCharacter extends BaseCharacter {
    // The bard's primary combat ability.
    private LuteMusic lute;

    /**
     * Constructs a BardCharacter with default attributes
     * and equips a LuteMusic ability.
     */
    public BardCharacter() {
        hitPoints = 100; 
        armorType = "medium";
        lute = new LuteMusic();
    }

    /**
     * Returns the class type for the bard.
     * @return The character class type.
     */ 
    public String getClassType() {
        return "Bard";
    }

    /**
     * Returns the BardCharacter's LuteMusic ability.
     * @return The LuteMusic instance.
     */
    public LuteMusic getLuteMusic() {
        return lute;
    }
}

