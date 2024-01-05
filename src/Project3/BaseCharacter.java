/**
 * Group authors and their NetIDs:
 * - Ray Rojas (xvc3)
 * - John Yamamoto (JMY40)
 * - Joseph Sheraden-Urrutia (jas759)
 * - Luis Herrera (lah136)
 */
package Project3;

/**
 * This is the BaseCharacter class, which serves as the  super class for all character objects in the project.
 */

public abstract class BaseCharacter {
    private Object characterModel; 
    public int hitPoints; 
    public String armorType; 

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
     * This is an abstract method that must be implemented by subclasses.
     * It returns the class type of the character.
     * @return The class type of the character.
     */
    public abstract String getClassType();
}
