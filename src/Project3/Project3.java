/** 
 * Template Author: Kayla Wesley
 * TODO - Add group authors and their NetIDs.
 * Ray Rojas xvc3
 * John Yamamoto JMY40
 * Joseph Sheraden-Urrutia jas759
 * Luis Herrera lah136
 * 
 * 
 */
package Project3;

import java.util.ArrayList;
// Imported a the correct missing libraries
import java.util.UUID;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
//Do not modify these library
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;  
import org.w3c.dom.Element; 

/**
 * Project 1: noSQL Game User Manager
 * 1. In this project you will manage a noSQL database.
 * 2. The data is stored in a XML file.
 * 
 * TODO 
 * 1. Replace all TODO sections with the correct data
 * 2. Set up the input parameters in Eclipse for testing.
 * 3. Finish the PlayerData class to manage the XML data.
 * 4. Add good comments for each TODO section you fill
 * 5. Add a ReadMe file with the data specified in Project3's requirements.
 */
public class Project3 {
    /**
     * TODO - populate all TODOs in this method
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        //TODO - the args should be populated with the field data for a new PlayerData object.
        
    	//TODO - Finish the file path names
    	try {
    		    
            // Check for the missing XML and XSD files
            File xmlFile = new File("src/project3/data.xml");
            File xsdFile = new File("src/project3/data.xsd");
                
            if (!xmlFile.exists() || !xsdFile.exists()) {
                	
                throw new FileNotFoundException("XML or XSD file is missing");
            }
            
            //TODO - Create a ArrayList of PlayerData called "playerList"
            // New  playerlist was added.
            ArrayList<PlayerData> playerList = new ArrayList<PlayerData>(); 
            
            //XML parsing
            Document parsedXML = readXML(xmlFile, xsdFile);
            
            //Accessing XML player data via nodeList
            Element root = parsedXML.getDocumentElement();
            NodeList nodeList = parsedXML.getElementsByTagName("Player");
            
            //Store player's data in playerList.
            playerList = populatePlayerList(nodeList);
            
            //TODO - Call constructPlayerFromInput() to create a PlayerData object from the input info.         
            // called constructPlayerFromInput()
            PlayerData newPlayer = constructPlayerFromInput(args);
            playerList.add(newPlayer);
            
            //TODO - Call addToXML() to add the new player to the Result.xml document.
            //addToXML() adds new player to Result.xml.
            addToXML(newPlayer, parsedXML);
            
            DOMSource src = new DOMSource(parsedXML);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult("src/Project3/Result.xml");
            transformer.transform(src, result);
            
         // Creates an instance of GUI
        	GraphicalUserInterface gui = new GraphicalUserInterface(playerList);

         // Make the GUI visible
            gui.setVisible(true);
            
            MagicCharacter mage = new MagicCharacter();
        	System.out.println("Mage hitpoints = " + mage.hitPoints);
        	System.out.println("Fireball hit! " + mage.getFireballScroll().calculateDamage(20));
        	mage.getFireballScroll().graphicEffect();
            
    	} 
    	catch (FileNotFoundException e) {
    		
            System.out.println("Error: " + e.getMessage());
            //Closes program if there is an issue
            System.exit(1);
            
        } 
    	catch (Exception e) {
            e.printStackTrace();
        }  
    	

        
    }
    
    /**
     * TODO - Populate all of the TODOs in this method
     * @param nodeList The list of nodes to be processed.
     * @return The result of processing the nodeList.
     */
    public static ArrayList<PlayerData> populatePlayerList(NodeList nodeList) {
        //TODO - create new PlayerData ArrayList
        ArrayList<PlayerData> playerList = new ArrayList<PlayerData>();
        
        //Check for empty NodeList
        try {
        	
        	if (nodeList.getLength() == 0) {
        		throw new NullPointerException("Empty NodeList");
        	}
        	
        	//loop through the list of nodes
        	for(int i = 0; i < nodeList.getLength(); i++) {
        		//1. Get node
        		Node node = nodeList.item(i);
            
        		//2. If node is the correct type, extract the player data.
        		if(node.getNodeType() == Node.ELEMENT_NODE) { 
                
        			//3. playerElement is created from node.
        			Element playerElement = (Element) node;
                
        			//4. Construct a PlayerData object from the XML player data.
        			PlayerData player = constructPlayerFromElement(playerElement);
                
        			//TODO - Add player to the playerList
        			//player added to list
        			playerList.add(player);
        		}
        	}
        
        } 
        catch (NullPointerException e) {
        	System.out.println("Error: " + e.getMessage());
        }
         return playerList;
    }
    
    /**
     * 
     * @param player The XML Element representing the player data.
     * @return A PlayerData object constructed from the provided Element.
     */
    public static PlayerData constructPlayerFromElement(Element player) {
        
    	//Check for bad types in input data
    	try {
    		//TODO - Finish creating the field variables for the player
    		UUID guid = UUID.fromString(player.getElementsByTagName("guid").item(0).getTextContent());
    		//{Your code here}
    		Boolean isActive = Boolean.parseBoolean(player.getElementsByTagName("isActive").item(0).getTextContent());
    		String firstName = player.getElementsByTagName("firstName").item(0).getTextContent();
    		String lastName = player.getElementsByTagName("lastName").item(0).getTextContent();
    		String email = player.getElementsByTagName("email").item(0).getTextContent();
    		int rank = Integer.parseInt(player.getElementsByTagName("rank").item(0).getTextContent());
    		int winRate = Integer.parseInt(player.getElementsByTagName("winRate").item(0).getTextContent());
    		//End of edited code here
    		LocalDateTime registered = LocalDateTime.parse(player.getElementsByTagName("registered").item(0).getTextContent());
    		LocalDateTime lastPlayed = LocalDateTime.parse(player.getElementsByTagName("lastPlayed").item(0).getTextContent());

    		//TODO - Create a temporary PlayerData variable "newPlayer" to assign the Element data to.
    		PlayerData newPlayer = new PlayerData(guid, isActive, firstName, lastName, email, rank, winRate, registered, lastPlayed);
        
    		return newPlayer;
    		
    	} 
    	catch (IllegalArgumentException e) {
    		System.out.println("Error: " + e.getMessage());
    	} 
    	catch (Exception e) {
    		System.out.println("Error: " + e.getMessage());
    	}
        return null;
    }
    
    /**
     * TODO - Populate all of the TODOs in this method.
     * Each input is in a try catch method to make sure its valid.  
     * @param input The input string array containing player data.
     * @return A PlayerData object constructed from the input data.
     */
    public static PlayerData constructPlayerFromInput(String[] input) {
        UUID guid = null;
        boolean isActive = false;
        String firstName = null;
        String lastName = null;
        String email = null;
        int rank = 0;
        int winRate = 0;
        LocalDateTime registered = null;
        LocalDateTime lastPlayed = null;

        try {
            // Check for the correct number of arguments
            if (input.length != 9) {
                throw new IllegalArgumentException("Invalid number of arguments. Expected 9, but got " + input.length);
            }

            // Check for valid UUID format
            guid = UUID.fromString(input[0]);
            
            // Check for valid boolean 
            // Convert to lower case for case-insensitive checking
            String booleanInput = input[1].toLowerCase();  

            if ("true".equals(booleanInput)) {
                isActive = true;
            } 
            else if ("false".equals(booleanInput)) {
                isActive = false;
            } 
            else {
                throw new IllegalArgumentException("Invalid boolean format: " + input[1]);
            }

            // Parsing the other fields
            firstName = input[2];
            lastName = input[3];
            email = input[4];
            
            // Check for valid integer
            rank = Integer.parseInt(input[5]);
            winRate = Integer.parseInt(input[6]);

            // Check for valid localDateTime
            registered = LocalDateTime.parse(input[7]);
            lastPlayed = LocalDateTime.parse(input[8]);

        } 
        catch (IllegalArgumentException | DateTimeParseException e) {
        	System.err.println("Error: " + e.getMessage());
        	// Terminate the program 
            System.exit(1); 
            
        }

        // Temporary PlayerData variable "newPlayer" created.
        PlayerData newPlayer = new PlayerData(guid, isActive, firstName, lastName, email, rank, winRate, registered, lastPlayed);

        return newPlayer;
    }

    
    /**
     * Do not change this method!
     * @param player The PlayerData object to be added to the XML.
     * @param parsedXML The XML document to which the player data is added.
     */
    public static void addToXML(PlayerData player, Document parsedXML) {
        Element root = parsedXML.getDocumentElement();
        Element newPlayer = parsedXML.createElement("Player");
        
        Element guid = parsedXML.createElement("guid");
        guid.appendChild(parsedXML.createTextNode(player.getGUID().toString()));
        Element isActive = parsedXML.createElement("isActive");
        isActive.appendChild(parsedXML.createTextNode(player.getIsActive() == true ? "true" : "false"));
        Element firstName = parsedXML.createElement("firstName");
        firstName.appendChild(parsedXML.createTextNode(player.getFirstName().toString()));
        Element lastName = parsedXML.createElement("lastName");
        lastName.appendChild(parsedXML.createTextNode(player.getLastName().toString()));
        Element email = parsedXML.createElement("email");
        email.appendChild(parsedXML.createTextNode(player.getEmail().toString()));
        Element rank = parsedXML.createElement("rank");
        rank.appendChild(parsedXML.createTextNode("" + player.getRank()));
        Element winRate = parsedXML.createElement("winRate");
        winRate.appendChild(parsedXML.createTextNode("" + player.getWinRate()));
        Element registered = parsedXML.createElement("registered");
        registered.appendChild(parsedXML.createTextNode(player.getRegistered().toString()));
        Element lastPlayed = parsedXML.createElement("LastPlayed");
        lastPlayed.appendChild(parsedXML.createTextNode(player.getLastPlayed().toString()));
        
        newPlayer.appendChild(guid);
        newPlayer.appendChild(isActive);
        newPlayer.appendChild(firstName);
        newPlayer.appendChild(lastName);
        newPlayer.appendChild(email);
        newPlayer.appendChild(rank);
        newPlayer.appendChild(winRate);
        newPlayer.appendChild(registered);
        newPlayer.appendChild(lastPlayed);
        
        //Do not change this.
        root.appendChild(newPlayer);

    }
    
    /**
     * Do not modify this method!
     * @param xmlFile The XML file to be read and validated.
     * @param xsdFile The XML Schema Definition (XSD) file used for validation.
     * @return A Document object representing the parsed and validated XML.
     * @throws ParserConfigurationException if there is a configuration issue with the XML parser.
     * @throws SAXException if there is an error in parsing or validation of the XML document.
     * @throws IOException if there is an error reading the XML or XSD file.
     */
    public static Document readXML(File xmlFile, File xsdFile) throws ParserConfigurationException, SAXException, IOException{

        //Setting up Factory and Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Schema schema = null;
        
        //Parsing xml document
        Document parsedXML = builder.parse(xmlFile);
        parsedXML.getDocumentElement().normalize();
        
        //Setting up schema
        String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory schemaFactory = SchemaFactory.newInstance(lang);
        schema = schemaFactory.newSchema(xsdFile);
        
        //Validating schema
        Validator validator = schema.newValidator();
        validator.validate(new DOMSource(parsedXML));
        
        return parsedXML;
    }
    
}