package truecaller.service;

import java.util.HashMap;
import java.util.Map;



/**
 * A class to store a Trie node
 *  endOfString sets when the node is a leaf node
 */
public class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfString;

    public TrieNode() {
        this.children = new HashMap<>();
        this.endOfString = false;
    }
}