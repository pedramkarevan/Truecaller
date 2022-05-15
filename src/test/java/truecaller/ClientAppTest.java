package truecaller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import truecaller.solution.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class ClientAppTest {

    private Context context;
    private List<String> listOfPrefix;

    @BeforeEach
    void init() {
        listOfPrefix = new ArrayList<>(Arrays.asList("true","True", "trueCaller", "truecaller", "truecallerrrrrr", "truecalle","Ped ram"));
        context = new Context();

    }


    @Test
    @DisplayName("MainByFileFunctionality")
    void mainByFile() throws Exception {
       String lp =context.findLongestPrefixFromFile("WQvILBw0h");
       assertEquals(lp,"WQvILBw0h");
    }

    @Test
    @DisplayName("MainByListFunctionality")
    void mainByList() throws Exception {


       // String lp =context.findLongestPrefixFromList("truecaller1",list);
        String lp =context.findLongestPrefixFromList("truecaller1",listOfPrefix);
        assertEquals(lp,"truecaller");
    }

    @Test
    @DisplayName("mainWithMatchingNotFind")
    void mainWithMatchingNotFind() throws Exception {
        Context context = new Context();
        String lp =context.findLongestPrefixFromFile("$QvILBw0h");
        assertEquals(lp,"");
    }

    @Test
    @DisplayName("mainWithFileByNullInputParameter")
    void mainWithFileByNullInputParameter() throws Exception {
        Context context = new Context();
        IllegalArgumentException thrown=assertThrows(
                IllegalArgumentException.class,
                () -> context.findLongestPrefixFromFile("")
        );
    }

    @Test
    @DisplayName("MainWithListByNullInputParameter")
    void mainWithListByNullInputParameter() throws Exception {
        String lp =context.findLongestPrefixFromList("",listOfPrefix);
        assertEquals(lp,"");
    }

    @Test
    @DisplayName("MainWithListBySpace")
    void mainWithListBySpace() throws Exception {
        String lp =context.findLongestPrefixFromList("Ped ra",listOfPrefix);
        assertEquals(lp,"Ped ra");
    }
}