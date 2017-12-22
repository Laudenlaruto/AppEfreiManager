/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proprietes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author lauden
 */
public class PropertyLoader {

    private static final String PROPRIETESFILE = "properties/database.properties";

    public static Properties load() throws IOException, FileNotFoundException {
        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(PROPRIETESFILE);        
        try {

            properties.load(input);
            return properties;

        } finally {
            input.close();
        }
    }
    public static void main(String[] args) {
        
    }
}
