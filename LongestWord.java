// Time Complexity : O(n*L) n length of dictionary and L average length of the word.
// Space Complexity : O(n*L) n length of dictionary and L average length of the word.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/* Approach
 * 1) First I constructed a trie with the dictionary.
 * 2) for finding the longest word that can be constructed letter by letter,
 * 3) I performed dfs on each charcater from the trie root only when its end of word is true using backtracking, otherwise just continued.
 * 4) maintained the result string and maxlen and root as the global variables to update at each dfs call is anything changes.
 * 5) trie make sure that we traverse the words in lexographic order.
 */
class trie
{
    trie[] children;
    boolean EOW;

    trie()
    {
        children = new trie[26];
        EOW = false;
    }

    void insert(String word)
    {
        trie root = this;
        for(int i=0; i<word.length(); i++)
        {
            int idx = word.charAt(i) - 'a';
            if(root.children[idx] == null)
                root.children[idx] = new trie();
            root = root.children[idx];
        }
        root.EOW = true;
    }
    
}
class Solution {
    StringBuilder resString = new StringBuilder();
    int MaxLen = 0;
    trie root = new trie();

    private void dfs(trie droot, StringBuilder path)
    {
        
        if(MaxLen < path.length())
        {
            MaxLen = path.length();
            resString.setLength(0);
            resString.append(path.toString());
        }
       
        for(int i=0; i<26; i++)
        {
            if(droot.children[i] == null) continue;

            char c = (char) ('a' + i);
            if(droot.children[i].EOW)
            {
                path.append(c);
                dfs(droot.children[i], path);
                path.setLength(path.length()-1);
            }
        }
    }
    public String longestWord(String[] words) {
        
        for(int i=0; i<words.length; i++)
            root.insert(words[i]);

        dfs(root, new StringBuilder());
        return resString.toString();
        
    }
}