package truecaller;

import truecaller.solution.Context;

import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientApp {
    public static final String PARAMETER = "XfhdWee";

    public static Logger logger = Logger.getLogger(ClientApp.class.getName());


    public static void main(String[] args) {

        try {
            long start = Instant.now().toEpochMilli();

            Context l = new Context();
            System.out.println("The longest prefix of " + PARAMETER + " is " + l.findLongestPrefixFromFile(PARAMETER));

          /*  List<String > listOfPrefix = new ArrayList<String>(Arrays.asList("true","True", "trueCaller", "truecaller", "truecallerrrrrr", "truecalle","Ped ram"));
            System.out.println("The longest prefix of "+PARAMETER+" is "+l.findLongestPrefixFromList(PARAMETER,listOfPrefix));*/

            long end = Instant.now().toEpochMilli();
            System.out.println(String.format("\tCompleted in %d milliseconds", (end - start)));

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }

    }
}
