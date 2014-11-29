/*
    Prototype code for SER SPORTS Project
    XML Code adapted from http://www.javacodegeeks.com/2013/05/parsing-xml-using-dom-sax-and-stax-parser-in-java.html
    API for http://www.sportsdatallc.com/
*/

import javax.xml.parsers.*;
import java.net.*;
import java.io.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.*;

class SerSportsApi
{
    private static final String apiKey = "enwf769pmzvpjr57jurvexqz";
    private static final String apiUrl = "https://api.sportsdatallc.org/mlb-t4/seasontd/players/2013.xml?api_key=";
    
    public static void main(String[] args) throws Exception
    {
        // Get the DOM Builder Factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        //Get the DOM Builder
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        //Load and Parse the XML document
        //document contains the complete XML as a Tree.
        URL url = new URL(apiUrl + apiKey);
        Document document = builder.parse(url.openStream());
        
        // Create list of players
        List<PlayerStats> playerList = new ArrayList<>();
        
        //Iterating through the nodes and extracting the data.
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            //We have encountered an <employee> tag.
            Node node = nodeList.item(i);
            if (node instanceof Element)
            {
                // Create the Player
                PlayerStats player = new PlayerStats(node);
                
                // Print out the player names.
                System.out.println(player.toString());
                
                // Add the Player to the list
                playerList.add(player);
            }
        }
    }
}