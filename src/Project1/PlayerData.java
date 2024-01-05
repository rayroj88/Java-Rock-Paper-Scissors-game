/** 
 * Template Author: Kayla Wesley
 * TODO - Add group authors and their NetIDs.
 * Joseph Sheraden-Urrutia jas759
 */
package Project1;
import java.util.UUID;
import java.time.LocalDateTime;

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
     * @param guid
     * @param isActive
     * @param firstName
     * @param lastName
     * @param email
     * @param rank
     * @param winRate
     * @param registered
     * @param lastPlayed
     * @return
    */
    public PlayerData(UUID guid, boolean isActive, String firstName,
            String lastName, String email, int rank, int winRate,
            LocalDateTime registered, LocalDateTime lastPlayed) {
        this.guid = guid;
        this.isActive = isActive;
        //{Your code goes here}
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.rank = rank;
        this.winRate = winRate;
        this.registered = registered;
        this.lastPlayed = lastPlayed;
    }
    
    //Added missing getter method for each field

    public void setGuid(UUID guid) {
        this.guid = guid;
    } 

    public UUID getGUID() {
    	return this.guid;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
   
    public boolean getIsActive() {
    	return this.isActive;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
    	return this.firstName;
    }
   
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getLastName() {
    	return this.lastName;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
    	return this.email;
    }
   
    public void setRank(int rank) {
        this.rank = rank;
    } 

    public int getRank() {
    	return this.rank;
    }

    public void setWinRate(int winRate) {
        this.winRate = winRate;
    }

    public int getWinRate() {
    	return this.winRate;
    }
    
    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    public LocalDateTime getRegistered(){
    	return this.registered;
    }
    
    public void setLastPlayed(LocalDateTime lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    public LocalDateTime getLastPlayed(){
    	return this.lastPlayed;
    }
}

