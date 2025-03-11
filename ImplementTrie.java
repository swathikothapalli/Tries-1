// Time Complexity : Written for each method below.
// Space Complexity : O(n*L) n length of dictionary and L average length of the word.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Trie {
    Trie[] children;
    boolean EOW;

    public Trie() {
        children = new Trie[26];
        EOW = false;
    }
    
    //Time Complexity : O(L) L is the length of the word and since we are storing in array fetching and storing is O(1).
    public void insert(String word) {
        Trie root = this;
        for(int i=0; i<word.length(); i++)
        {
            int idx = word.charAt(i) - 'a';
            if(root.children[idx] == null)
                root.children[idx] = new Trie();
            root = root.children[idx];
        }
        root.EOW = true;
    }
    
     //Time Complexity : O(L) L is the length of the word.
    public boolean search(String word) {
        Trie root = this;
        for(int i=0; i<word.length(); i++)
        {
            int idx = word.charAt(i) - 'a';
            if(root.children[idx] == null) return false;
            root = root.children[idx];
        }
        return root.EOW;
    }
    //Time Complexity : O(L) L is the length of the prefix.
    public boolean startsWith(String prefix) {
        Trie root = this;
        for(int i=0; i<prefix.length(); i++)
        {
            int idx = prefix.charAt(i) - 'a';
            if(root.children[idx] == null) return false;
            root = root.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */