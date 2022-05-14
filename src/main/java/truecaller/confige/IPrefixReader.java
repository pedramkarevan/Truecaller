package truecaller.confige;


import java.util.List;

/**
 * We can extend the functionality of reading file with defining another methods without needing any changes
 */
public interface IPrefixReader {
    public List<String> getPrefixesFromFileByFirstCharFilter(String fileName, String parameter) throws Exception;
}
