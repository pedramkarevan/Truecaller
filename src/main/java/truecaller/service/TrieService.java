package truecaller.service;

import java.util.List;
import java.util.Map;

public class TrieService {

    private TrieNode root;

    public TrieService() {
        root = new TrieNode();
    }

    /**
     * Inserting matching characters, one-by-one,
     * based on input parameter characters sequence in Trie data structure.
     * The longest prefix could be ranges from the first character
     * to the last character length of input parameter and will be find by "findLongestPrefix" method
     *
     * @param words
     * @param parameter
     * @return TrieNode data structure
     */
    public TrieNode insertMatching(List<String> words, String parameter) {
        //Temporary node which hold the value of current node
        TrieNode current = root;
        current = insertMatchingPrefixInTire(words, parameter, current);
        return current;
    }

    /**
     * Iterate String character one by one
     * If there is any character matching insert it into trie
     * @param words
     * @param parameter
     * @param current
     * @return inserted matching characters
     */
    private TrieNode insertMatchingPrefixInTire(List<String> words, String parameter, TrieNode current) {
     if(!words.isEmpty()){
         for (int i = 0; i < words.size(); i++) {
             matchingAndInsert(words, parameter, current, i);
             current = root;}
     }
        return current;
    }

    /**
     * creating a node for getting the character from map
     * Scanning String chars until there is not matching,
     * then end of matching string in the trie is set and the next string is evaluated
     * @param words
     * @param parameter
     * @param current
     * @param i
     * @return
     */
    private TrieNode matchingAndInsert(List<String> words, String parameter, TrieNode current, int i) {

        for (int j = 0; j < parameter.length() && j < words.get(i).length(); j++) {
            char ch = words.get(i).charAt(j);
            TrieNode node = current.children.get(ch);

            if (ch != parameter.charAt(j))
                break;
            node = putMatching(current, ch, node);
            current = node;
        }
        current.endOfString = true;
        return current;
    }

    /**
     * The first time of char there is exist in the trie
     * @param current
     * @param ch
     * @param node
     * @return
     */
    private TrieNode putMatching(TrieNode current, char ch, TrieNode node) {
        if (node == null) {
            node = new TrieNode();
            current.children.put(ch, node);
        }
        return node;
    }


    /**
     * Traversing the Trie and find the longest common prefix
     * Looping through the Trie and finding the longest node which does not has any child
     *
     * @param trieNode
     * @return longest String prefix in trie
     */
    public String findLongestPrefix(TrieNode trieNode) {
        StringBuilder lcp = new StringBuilder();
        TrieNode curr = trieNode;
        findLongestPrefixInTrie(lcp, curr);
        return lcp.toString();
    }

    /**
     * Prefixes are inserted regarding to the character sequences of input parameter in Trie,
     * so it just need to extract the whole of children values of Trie until end to getting the longest
     * @param lcp
     * @param curr
     */
    public void findLongestPrefixInTrie(StringBuilder lcp, TrieNode curr) {
        while (curr.children.size() == 1) {
            for (Map.Entry<Character, TrieNode> entry : curr.children.entrySet()) {
                lcp.append(entry.getKey());
                // update `curr` pointer to the child node
                curr = entry.getValue();
            }
        }
    }
}