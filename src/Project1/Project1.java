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
package Project1;
// Imported a the correct missing libraries
import java.util.ArrayList;
import java.util.UUID;
import java.io.File;
import java.io.IOException;
//Do not modify these library
import java.time.LocalDateTime;
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
 * 5. Add a ReadMe file with the data specified in Project1's requirements.
 */
public class Project1 {
    /**
     * The main function loads the necessary data files, builds an
     * ArrayList using the data found in them, and writes the
     * results to an output file.
     * @param args
     */
    public static void main(String[] args) {
        //TODO - the args should be populated with the field data for a new PlayerData object.
        try {
            //TODO - Finish the file path names
            // Names where added.
            File xmlFile = new File("src/project1/data.xml");    
            File xsdFile = new File("src/project1/data.xsd");
            
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
            StreamResult result = new StreamResult("src/Project1/Result.xml");
            transformer.transform(src, result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }  
        
    }
    
    /**
     * Populates an array of PlayerData objects from an existing list of XML nodes.
     * @param nodeList
     * @return
     */
    public static ArrayList<PlayerData> populatePlayerList(NodeList nodeList) {
        //TODO - create new PlayerData ArrayList
        ArrayList<PlayerData> playerList = new ArrayList<PlayerData>();
        
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
        return playerList;
    }
    
    /**
     * Constructs a new PlayerData object from an existing Element object. 
     * @param player
     * @return
     */
    public static PlayerData constructPlayerFromElement(Element player) {
        
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
    
    /**
     * Constructs a new Player object from an input string.
     * @param input
     * @return
     */
    public static PlayerData constructPlayerFromInput(String[] input) {
        
        //TODO - Finish creating the field variables for each player
        UUID guid = UUID.fromString(input[0]);
        boolean isActive = Boolean.valueOf(input[1]);
        // Converts the args string into .
        String firstName = input[2];
        String lastName = input[3];
        String email = input[4];
        int rank = Integer.parseInt(input[5]);  
        int winRate = Integer.parseInt(input[6]);
        LocalDateTime registered = LocalDateTime.parse(input[7]);
        LocalDateTime lastPlayed = LocalDateTime.parse(input[8]);

        //Temporary PlayerData variable "newPlayer" created.
        PlayerData newPlayer = new PlayerData(guid,isActive,firstName,lastName,email,rank,winRate,registered,lastPlayed);
        
        return newPlayer;
    }
    
    /**
     * Do not change this method!
     * @param player
     * @param parsedXML
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
     * @param xmlFile
     * @param xsdFile
     * @return
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
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
