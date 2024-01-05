/**
 * Group authors and their NetIDs:
 * - Ray Rojas (xvc3)
 * - John Yamamoto (JMY40)
 * - Joseph Sheraden-Urrutia (jas759)
 * - Luis Herrera (lah136)
 */
package Project2;

    /**
     * This is the BaseCharacter class, which serves as the base for character objects in the project.
     */

public abstract class BaseCharacter {
    private Object characterModel; 
    protected int hitPoints; 
    protected String armorType; 

    /**
     * Set the character model for this character.
     * @param characterModel The character model to set.
     */
    public void setCharacterModel(Object characterModel) {
        this.characterModel = characterModel;
    }

    /**
     * Get the character model associated with this character.
     * @return The character model.
     */
    public Object getCharacterModel() {
        return characterModel;
    }

    /**
     * Set the hit points for this character.
     * @param hitPoints The hit points to set.
     */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    /**
     * Get the current hit points of this character.
     * @return The hit points.
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Set the armor type for this character.
     * @param armorType The armor type to set.
     */
    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }

    /**
     * Get the type of armor worn by this character.
     * @return The armor type.
     */
    public String getArmorType() {
        return armorType;
    }

    /**
     * This is an abstract method that must be implemented by subclasses.
     * It returns the class type of the character.
     * @return The class type of the character.
     */
    public abstract String getClassType();
}
