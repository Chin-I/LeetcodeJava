/**
 * Created by Gene on 7/31/17.
 */
public class LeetCode_208_ImplementTrie_PrefixTree {
    class TrieNode {

        TrieNode[] children = new TrieNode[26];
        boolean isLeaf;
        // Constructor
        public TrieNode() {
        }
    }

    public class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            insert(word.toCharArray(), 0, root);
        }
        //(..)
        public void insert(char[] word, int i, TrieNode node) {
            if (i == word.length) {
                node.isLeaf = true;
                return;
            }

            char c = word[i];
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            insert(word, i + 1, node.children[c - 'a']);
        }
        //////////
        // Returns if the word is in the trie.
        public boolean search(String word) {
            return search(word.toCharArray(), 0, root);
        }
        //(..)
        public boolean search(char[] word, int i, TrieNode node) {

            if (i == word.length) {
                return node.isLeaf;
            }

            char c = word[i];

            return node.children[c - 'a'] != null && search(word, i + 1, node.children[c - 'a']);
        }
        ////////
        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            return startsWith(prefix.toCharArray(), 0, root);
        }
        //(..)
        public boolean startsWith(char[] word, int i, TrieNode node) {

            if (i == word.length) {
                return true;
            }

            char c = word[i];
            return node.children[c - 'a'] != null && startsWith(word, i + 1, node.children[c - 'a']);
        }
    }

/*
//Keen-1 28%
class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}
public class Trie {
    // Initialize your data structure here.
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for (char ch:word.toCharArray()){
            if (cur.children[ch - 'a'] == null){
                cur.children[ch - 'a'] = new TrieNode(ch);
            }
            cur = cur.children[ch - 'a'];
        }
        cur.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}
*/

/*
//Solution 6%
class TrieNode {
    // R links to node children
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    // search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
           char curLetter = word.charAt(i);
           if (node.containsKey(curLetter)) {
               node = node.get(curLetter);
           } else {
               return null;
           }
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
       TrieNode node = searchPrefix(word);
       return node != null && node.isEnd();
    }
/////////////
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
*/


/*
//Keen 2 helper
class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {};
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}
public class Trie {
    // Initialize your data structure here.
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for (char ch:word.toCharArray()){
            if (cur.children[ch - 'a'] == null){
                cur.children[ch - 'a'] = new TrieNode(ch);
            }
            cur = cur.children[ch - 'a'];
        }
        cur.isWord = true;
    }

//     // Returns if the word is in the trie.
//     public boolean search(String word) {
//         TrieNode ws = root;
//         for(int i = 0; i < word.length(); i++){
//             char c = word.charAt(i);
//             if(ws.children[c - 'a'] == null) return false;
//             ws = ws.children[c - 'a'];
//         }
//         return ws.isWord;
//     }

////////////////////
// Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = match(root, word.toCharArray(),0);
        return node != null && node.isWord; //isWord
    }
// Returns if there is any word in the trie that starts with the given prefix.
//     public boolean startsWith(String prefix) {
//         TrieNode ws = root;
//         for(int i = 0; i < prefix.length(); i++){
//             char c = prefix.charAt(i);
//             if(ws.children[c - 'a'] == null) {
//                 return false;
//              }
//             ws = ws.children[c - 'a'];
//         }
//         return true;
//     }

// Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return match(root, prefix.toCharArray(),0) != null;
    }

    //(..) helper
    private TrieNode match(TrieNode node,char[] word,int depth){
        if (node == null || depth == word.length){
            return node;
        }
        return match(node.children[word[depth]-'a'],word,depth++);//(..)
    }
}

*/

///////////////////////

// public class Trie {

//     // Initialize your data structure here.
//     public Trie() {

//     }

//     // Inserts a word into the trie.
//     public void insert(String word) {

//     }

//     // Returns if the word is in the trie.
//     public boolean search(String word) {

//     }

//     // Returns if there is any word in the trie that starts with the given prefix.
//     public boolean startsWith(String prefix) {

//     }
// }



/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
