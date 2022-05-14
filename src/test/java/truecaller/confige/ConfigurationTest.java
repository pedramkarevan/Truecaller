package truecaller.confige;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationTest {



    @Test
    @DisplayName("getPropertySize")
    void propertyConfigSize() {
        Map<String, String> params = new HashMap<>();
        params.put("test.file" ,"sampleData.txt");
        params.put("case.sensitive" ,"false");
        IConfiguration config = new Configuration();
        Map step1 = config.propertyConfig(new Properties());
        assertTrue(params.size() == step1.size()  );
    }

    @Test
    @DisplayName("getProperty")
    void propertyConfigValue() {
        Map<String, String> param = new HashMap<>();
        param.put("test.file" ,"sampleData.txt");
        IConfiguration config = new Configuration();
        Map prop = config.propertyConfig(new Properties());
        assertEquals(prop.get("test.file").toString(),param.get("test.file"));
    }

    @Test()
    @DisplayName("getAllProperties")
    public void getAllPropertiesIOException() throws IOException{
        String expected = "{test.file=sampleData.txt, case.sensitive.enable=false}";
        assertEquals(expected,new Configuration().propertyConfig(new Properties()).toString());
    }


    }