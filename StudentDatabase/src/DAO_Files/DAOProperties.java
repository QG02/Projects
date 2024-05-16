package DAO_Files;

import java.io.*;
import java.util.Properties;

public class DAOProperties {

    //Creating a properties class object and loaded the dao.properties file as a String
    private static final String PROPERTIES_FILE = "dao.properties";
    private static final Properties PROPERTIES = new Properties();
    private final String prefix;

    //Pass the properties file to the properties object using and input stream
    static{
        try{
            // Get the input stream for the properties file
            InputStream file = DAOProperties.class.getResourceAsStream(PROPERTIES_FILE);
            //Load properties from the input stream
            PROPERTIES.load(file);
        }catch (IOException e){
            throw new DAOException(e.getMessage());
        }
    }

    //Constructor to set the prefix
    public DAOProperties(String prefix){
        this.prefix=prefix;
    }

    //Method to retrieve a property value throught a key & a prefix
    public String getProperty(String key){
        //Construct the full key
        String fullKey = prefix + "." + key;
        //Get the loaded properties
        String property = PROPERTIES.getProperty(fullKey);

        if(property == null || property.trim().isEmpty()){
            property = null;
        }
        return property;
    }
}
