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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GraphicalUserInterface extends JFrame {
	private JLabel playerNameLabel; // Displays the player's name
	private JLabel winRateLabel; // Displays the player's Win Rate
	private JLabel fireballEffectLabel; // Displays the FireballScroll effect
	private JLabel shieldEffectLabel; // Displays the ShieldDefence effect
	private JLabel luteEffectLabel;// Displays the LuteMusic effect

    /**
     * Constructs a GraphicalUserInterface from an ArrayList of players.
     * @param players The players that will participate in the game
     */
	public GraphicalUserInterface(ArrayList<PlayerData> players) {
		// Set title, size, close behavior, and layout.
		setTitle("Fireball | Shield | Lute");
        setSize(1000, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));
        
        JButton fireballButton = new JButton("Fireball");
        fireballButton.setBackground(Color.red);
        fireballButton.setVisible(false);
        
        JButton shieldButton = new JButton("Shield");
        shieldButton.setBackground(Color.blue);
        shieldButton.setVisible(false);
        
        JButton luteButton = new JButton("Lute");
        luteButton.setBackground(Color.yellow);
        luteButton.setVisible(false);
        
        
        // Creates a new List for active Players.
        ArrayList<PlayerData> activePlayerNames = new ArrayList<>();

        //Pull active players into a new ArrayList
        for (PlayerData player : players) {
        	if (player.getIsActive() == true) {
        		activePlayerNames.add(player);
        	}
        }
        
        // Create the combobox with active players.
        JComboBox<String> playerDropdown = new JComboBox<>();
        add(new JLabel("Select a Player:"));
        add(playerDropdown);

        // Populate the combo box with player names.
        for (PlayerData player : activePlayerNames) {
            playerDropdown.addItem(player.getFirstName()); 
        }

        // Define the player name and win rate labels.
        playerNameLabel = new JLabel();
        winRateLabel = new JLabel();
        
        // Add the labels to the graphical user interface.
        add(playerNameLabel);
        add(winRateLabel);

        // Add a ChangeListener to the combo box
        playerDropdown.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                // Update labels when a player is selected
            	if (playerDropdown.getSelectedItem() != null) {
        			fireballButton.setVisible(true);
        			shieldButton.setVisible(true);
        			luteButton.setVisible(true);
        		} else {
        			fireballButton.setVisible(false);
        			shieldButton.setVisible(false);
        			luteButton.setVisible(false);
        		}
            	
            	Object selectedPlayerName = playerDropdown.getSelectedItem();

                for (PlayerData selectedPlayer : activePlayerNames) {
                    if (selectedPlayer.getFirstName().equals(selectedPlayerName)) {
                        playerNameLabel.setText("Player Name: " + selectedPlayer.getFirstName());
                        winRateLabel.setText("Win Rate: " + selectedPlayer.getWinRate());
                        fireballEffectLabel.setText("");
                        shieldEffectLabel.setText("");
                        luteEffectLabel.setText("");
                    }
                }
            }
        });
        
        // Create JButtons for FireballScroll, ShieldDefense,
       
      add(fireballButton);
     
        fireballEffectLabel = new JLabel();
	    add(fireballEffectLabel);
        // Create an ActionListener for when a mage's
        // FireballScroll ability is performed.
        fireballButton.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		//Perform Fireball
        		//Generate random number between 0 and 2, add 1 because nextInt is exclusive
        		int opponentType = ThreadLocalRandom.current().nextInt(0, 3);
        		
        		//Clear old outputs
        		shieldEffectLabel.setText("");
                luteEffectLabel.setText("");
        		
        		//Index of player chosen
        		int selectedIndex = playerDropdown.getSelectedIndex();
        		
        		    if (selectedIndex >= 0 && selectedIndex < players.size()) {
        			    PlayerData selectedPlayer = players.get(selectedIndex);
        			    
        			    if (opponentType == 0) {
        				//Opponent is fighter
        				    FireballScroll fail = new FireballScroll(); // Create an instance of Fireball
        				    String fireballEffectMessage = "Opponent was a Fighter: " + fail.failureGraphic(); // Call failureGraphic method
        				    fireballEffectLabel.setText(fireballEffectMessage);
        				    
        			    } 
        			    else if (opponentType == 1) {
        				    //Opponent is bard
        				    FireballScroll fireball = new FireballScroll(); // Create an instance of Fireball
        				    String fireballEffectMessage = "Opponent was a Bard: " + fireball.graphicEffect();
        				    fireballEffectLabel.setText(fireballEffectMessage);
        				            
        			    } 
        			    else {
        				//Opponent is magic character
        				    fireballEffectLabel.setText("Opponent was a Mage: It's a draw.");	
        			    }
        		    }
        	}
        });
        
        add(luteButton);
        
        luteEffectLabel = new JLabel();
	    add(luteEffectLabel);
        // Create an ActionListener for when a Bard's
        // LuteMusic ability is performed.
	    luteButton.addActionListener(new ActionListener() {
	    	
            public void actionPerformed(ActionEvent e) {
                //Perform LuteMisic
        		//Generate random number between 0 and 2, add 1 because nextInt is exclusive
        		int opponentType = ThreadLocalRandom.current().nextInt(0, 3);
        		//Index of player chosen
        		
        		int selectedIndex = playerDropdown.getSelectedIndex();
        		
        		//Clear old outputs
        		fireballEffectLabel.setText("");
                shieldEffectLabel.setText("");
        		
        		    if (selectedIndex >= 0 && selectedIndex < players.size()) {
        			    PlayerData selectedPlayer = players.get(selectedIndex);
        			    
        			    if (opponentType == 0) {
        				//Opponent is fighter
        			    	LuteMusic lute = new LuteMusic(); // Create an instance of LuteMusic
        				    String luteEffectMessage = "Opponent was a Fighter: " + lute.graphicEffect(); // Call failureGraphic method
        				    luteEffectLabel.setText(luteEffectMessage);
        			    	
        			    } 
        			    else if (opponentType == 1) {
        				    //Opponent is bard
        			    	luteEffectLabel.setText("Opponent was a Bard: It's a draw.");
        				            
        			    } 
        			    else {
        				//Opponent is magic character
        			    	LuteMusic fail = new LuteMusic(); // Create an instance of LuteMusic
        				    String luteEffectMessage = "Opponent was a Mage: " + fail.failureGraphic(); // Call failureGraphic method
        				    luteEffectLabel.setText(luteEffectMessage);
        			    }
        		    }
            }
        });
	    
	    add(shieldButton);
	    
        shieldEffectLabel = new JLabel();
	    add(shieldEffectLabel);
        // Create an ActionListener for when a Fighter
        // ShieldDefense ability is performed. 
        shieldButton.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
        		//Generate random number between 0 and 2, add 1 because nextInt is exclusive
        		int opponentType = ThreadLocalRandom.current().nextInt(0, 3);
        		
        		//Clear old outputs
        		fireballEffectLabel.setText("");
                luteEffectLabel.setText("");
        		
        		//Index of player chosen
        		int selectedIndex = playerDropdown.getSelectedIndex();
        		
        		    if (selectedIndex >= 0 && selectedIndex < players.size()) {
        			    PlayerData selectedPlayer = players.get(selectedIndex);
        			    
        			    if (opponentType == 0) {
        				//Opponent is fighter
        			    	shieldEffectLabel.setText("Opponent was a Fighter: It's a draw.");
        			    	
        			    } 
        			    else if (opponentType == 1) {
        				    //Opponent is bard
        			    	ShieldDefense fail = new ShieldDefense(); // Create an instance of LuteMusic
        				    String shieldEffectMessage = "Opponent was a Bard: " + fail.failureGraphic(); // Call failureGraphic method
        				    shieldEffectLabel.setText(shieldEffectMessage);
        				            
        			    } 
        			    else {
        				//Opponent is magic character
        			    	ShieldDefense fail = new ShieldDefense(); // Create an instance of LuteMusic
        				    String shieldEffectMessage = "Opponent was a Mage: " + fail.graphicEffect(); // Call failureGraphic method
        				    shieldEffectLabel.setText(shieldEffectMessage);
        			    }
        		    }
            }
        });
        
        setVisible(true);
	}
}
