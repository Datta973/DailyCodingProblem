/*

Problem statement :

Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.
For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.

*/

import java.util.ArrayList;

public class Day_11_AutoComplete{
    public static void main(String[] args){
        System.out.println(solve("de", new String[]{"dog", "deer", "deal"}));
    }
    
    // Time O(26 ^ N) : when N is the length of the largest string in list
    private static ArrayList<String> solve(String prefix, String[] list){
        ArrayList<String> ans = new ArrayList<>();
        TrieNode root = new TrieNode();
        
        for(String s : list)
            insert(s, root);
        
        for(char ch : prefix.toCharArray()){
            if(root == null)
                return ans;
            
            root = root.children[ch-'a'];
        }
        
        search(prefix, root, ans);
        
        return ans;
    }
    
    
    private static void search(String prefix, TrieNode root, ArrayList<String> ans){
        if(root == null)
            return;
        
        if(root.end)
            ans.add(prefix);
        
        for(int i=0;i<26;i++)
            search(prefix + (char)('a' + i), root.children[i], ans);
    }
    
    // Time O(n) : n is length of s
    private static void insert(String s, TrieNode root){
        for(char ch : s.toCharArray()){
            if(root.children[ch-'a'] == null)
                root.children[ch-'a'] = new TrieNode();
            
            root = root.children[ch-'a'];
        }
        
        root.end = true;
    }
    
    static class TrieNode{
        boolean end = false;
        TrieNode[] children = new TrieNode[26];
    }
}