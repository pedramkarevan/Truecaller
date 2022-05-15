package truecaller.confige;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class PrefixReader implements IPrefixReader {
    /**
     * The first step of the pre-processing of reading prefixes from a file
     * and extracting the elements which are matched at least with the first
     * character of the input parameter
     *
     * @param fileName
     * @param parameter
     * @return
     */

    @Override
    public List<String> getPrefixesFromFileByFirstCharFilter(String fileName, String parameter) throws Exception {
        List<String> filteredPrefixes = null;
        if (!parameter.isEmpty() || parameter != "") {
            ConcurrentHashMap<String, Integer> prefixesMap = new ConcurrentHashMap<>();
            Path filePath = Paths.get(fileName);
            Files.readAllLines(filePath)
                    .parallelStream()                                                 /** Start streaming the lines */
                    .map(line -> line.split("\\R+"))                            /** Split line into individual words */
                    .flatMap(Arrays::stream)                                          /** Convert stream of String[] to stream of String */
                    .parallel()                                                       /** Convert to parallel */
                    .filter(w -> w.startsWith(String.valueOf(parameter.charAt(0))))   /** Filter first char matching */
                    //  .map(String::toLowerCase)                                     /** Convert to lower case */
                    .forEach(word -> {                                                /** Use an AtomicAdder */
                        if (!prefixesMap.containsKey(word))                           /** If a hashmap entry for the word doesn't exist */
                            prefixesMap.put(word, word.length());
                    });
            HashMap<String, Integer> map = new HashMap<String, Integer>(prefixesMap);
            filteredPrefixes = new ArrayList<String>(map.keySet());
            return filteredPrefixes;
        }

        throw new IllegalArgumentException("input String is empty!");
    }
}