package truecaller.service;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class TrieServiceTest {

    public static final String INPUT_PARAMETER = "truecaller1";
    private TrieService trieService;
    private List<String> listOfPrefix,listOfWordsInTrie;
    private StringBuilder lcp ;

    @BeforeEach
    void init() {

        listOfPrefix = new ArrayList<>(Arrays.asList("t","20P", "True", "trueC", "truecaller", "pruecallerrrrrr", "truec1ll"));
        trieService = new TrieService();
        lcp = new StringBuilder("");
        listOfWordsInTrie = new ArrayList<>();
    }


    @Test
    @DisplayName("InsertedMatchingPrefixInTrie")
    void insertedMatchingPrefixInTrie() {

        TrieNode trieNode = trieService.insertMatching(listOfPrefix, INPUT_PARAMETER);
        TrieNode curr = trieNode;
        while (curr.children.size() == 1) {
            for (Map.Entry<Character, TrieNode> entry : curr.children.entrySet()) {
                lcp.append(entry.getKey());
                curr = entry.getValue();
                if (curr.endOfString == true) {
                    listOfWordsInTrie.add(lcp.toString());
                }
            }

        }

       assertEquals(listOfWordsInTrie,new ArrayList<>(Arrays.asList("t","true","truec","truecaller")));
    }

    @Test
    @DisplayName("InsertedMatchingPrefixInTrie")
    void longestInsertedMatchingPrefixInTrie() {
        TrieNode trieNode = trieService.insertMatching(listOfPrefix, INPUT_PARAMETER);
        TrieNode curr = trieNode;
        trieService.findLongestPrefixInTrie( lcp,  curr);
        assertEquals(lcp.toString(),"truecaller");
    }
}