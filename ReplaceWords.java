// Time Complexity : O(d + s) d for constructing the trie with dictionary and s for sentence as we are checking each character.
// Space Complexity : O(n*L) n length of dictionary and L average length of the word.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
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

    String getSmallPrefix(String s)
    {
        trie root = this;
        StringBuilder res = new StringBuilder();
        for(int i=0; i<s.length(); i++)
        {
            int idx = s.charAt(i) - 'a';
            res.append(s.charAt(i));
            if(root.children[idx] == null)
                return s;
           
            root = root.children[idx];
            if(root.EOW)
                return res.toString();
        }
        return res.toString();
    }
}
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        trie root = new trie();
        for(int i=0; i<dictionary.size(); i++)
            root.insert(dictionary.get(i));
        StringBuilder result = new StringBuilder();
        int start = 0;
        int end = 0;
        while(end<sentence.length())
        {
            while(end<sentence.length() && sentence.charAt(end) != ' ')
                end++;
            result.append(root.getSmallPrefix(sentence.substring(start, end)) + " ");
            start = end + 1;
            end = start;
        }
        return result.substring(0, result.length()-1);
    }
}