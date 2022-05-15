package truecaller.confige;

import truecaller.ClientApp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Concrete implementation of configuration interface
 * for reading properties like address of prefixes file
 */

public class Configuration implements IConfiguration {

    public static Logger logger = Logger.getLogger(ClientApp.class.getName());


    @Override
    public Properties propertyConfig(Properties properties) {
        InputStream inputStream = ClientApp.class.getClassLoader().getResourceAsStream("application.properties");
        if (inputStream != null) {
            try {
                properties.load(inputStream);
                return properties;
            } catch (IOException e) {
                logger.info(e.getMessage());
            }

        }
        return properties;
    }
}