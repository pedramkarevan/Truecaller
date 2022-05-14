package truecaller.solution;






import truecaller.confige.Configuration;
import truecaller.confige.IConfiguration;
import truecaller.confige.IPrefixReader;
import truecaller.confige.PrefixReader;

import java.util.List;
import java.util.Properties;

/**
 *This class configures appropriate strategy objects(like useing trie for finding the longest prefix or using a list),
 * that can be used by clients.
 */
public class Context {
    private IPrefixReader iPrefixReader;
    private ILongestPrefix iLongestPrefix;
    private IConfiguration iConfiguration;


    public String findLongestPrefixFromFile(String parameter) throws Exception {
        List<String> prefixes = readPrefixFromFileByParamFilter(parameter);
        iLongestPrefix = new LongestPrefixByTrie();
        return iLongestPrefix.findLongestPrefixByTrie(parameter, prefixes);
    }

    public String findLongestPrefixFromList(String parameter, List<String> prefixes) throws Exception {
        iLongestPrefix = new LongestPrefixByTrie();
        return iLongestPrefix.findLongestPrefixByTrie(parameter, prefixes);
    }

    /**
     * Configure services and getting prefixes from File by filter
     * @param parameter
     * @return
     */
    private List<String> readPrefixFromFileByParamFilter(String parameter) throws Exception {
        iPrefixReader =  new PrefixReader();
        iConfiguration = new Configuration();
        Properties properties = new Properties();
        Properties property = iConfiguration.propertyConfig(properties);
        List<String> prefixes = iPrefixReader.getPrefixesFromFileByFirstCharFilter(property.getProperty("test.file"), parameter);
        return prefixes;
    }


}



