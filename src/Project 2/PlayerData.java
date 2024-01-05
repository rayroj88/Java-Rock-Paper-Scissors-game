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
import java.util.UUID;
import java.time.LocalDateTime;

/**
 * Represents player data.
 */

public class PlayerData {
   // Added the missing variables.
   private UUID guid;
   private boolean isActive; 
   private String firstName;        
   private String lastName;
   private String email;
   private int rank;
   private int winRate;
   private LocalDateTime registered;
   private LocalDateTime lastPlayed;
   
   /**
   * PlayerData class contructor.
   * @param guid The unique identifier for the player.
   * @param isActive Indicates if the player is active or not.
   * @param firstName The first name of the player.
   * @param lastName The last name of the player.
   * @param email The email address of the player.
   * @param rank The player's rank or level.
   * @param winRate The player's win rate.
   * @param registered The date and time when the player registered.
   * @param lastPlayed The date and time when the player last played a game.
   */
   public PlayerData(UUID guid, boolean isActive, String firstName,
           String lastName, String email, int rank, int winRate,
           LocalDateTime registered, LocalDateTime lastPlayed) {
       this.guid = guid;
       this.isActive = isActive;
       //Added missing variables
       this.firstName = firstName;
       this.lastName = lastName;
       this.email = email;
       this.rank = rank;
       this.winRate = winRate;
       this.registered = registered;
       this.lastPlayed = lastPlayed;
   }
   
   //Added missing getter method for each field

   
   /**
    * Gets the unique identifier for the player.
    * @return The player's unique identifier (GUID).
    */
   public UUID getGUID() {
       return guid;
   }

   /**
    * Checks if the player is active.
    * @return `true` if the player is active, `false` if the player is inactive.
    */
   public boolean getIsActive() {
       return isActive;
   }

   /**
    * Gets the first name of the player.
    * @return The first name of the player.
    */
   public String getFirstName() {
       return firstName;
   }

   /**
    * Gets the last name of the player.
    * @return The last name of the player.
    */
   public String getLastName() {
       return lastName;
   }

   /**
    * Gets the email address of the player.
    * @return The email address of the player.
    */
   public String getEmail() {
       return email;
   }

   /**
    * Gets the rank or level of the player.
    * @return The player's rank or level.
    */
   public int getRank() {
       return rank;
   }

   /**
    * Gets the win rate of the player.
    * @return The player's win rate.
    */
   public int getWinRate() {
       return winRate;
   }

   /**
    * Gets the date and time when the player registered.
    * @return The date and time of registration.
    */
   public LocalDateTime getRegistered() {
       return registered;
   }

   /**
    * Gets the date and time when the player last played a game.
    * @return The date and time of the last game played.
    */
   public LocalDateTime getLastPlayed() {
       return lastPlayed;
   }

}
