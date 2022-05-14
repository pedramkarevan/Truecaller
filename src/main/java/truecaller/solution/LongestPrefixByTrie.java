package truecaller.solution;

import truecaller.service.TrieService;
import java.util.List;

/**
 * Concrete implementation using Trie data structure
 */
public class LongestPrefixByTrie implements ILongestPrefix{
    @Override
    public String findLongestPrefixByTrie(String parameter, List<String> prefixes) throws Exception {
        TrieService trieService = new TrieService();
        return trieService.findLongestPrefix(trieService.insertMatching(prefixes, parameter));
    }
}
