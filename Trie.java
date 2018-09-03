class Trie {

    TrieNode root;
    
    class TrieNode    {
        
        HashMap<Character, TrieNode> mapy;
        boolean endOfWord = false;
        
        public TrieNode()   {
            
            mapy = new HashMap<Character, TrieNode>();
            boolean endOfAWord = false;
            
        }
    }
    /** Initialize your data structure here. */
    public Trie()   {
        
        root = new TrieNode();
    }
    
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        if(word == null)
            return;
        
        TrieNode it = root;
        
        for(char c: word.toCharArray())     {
            
            if(it.mapy.containsKey(c))
                it = it.mapy.get(c);
            else    {
                
                it.mapy.put(c, new TrieNode());
                it = it.mapy.get(c);
            }
        }
        
        it.endOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        if(word == null)
            return false;
        
        TrieNode it = root;
        
        for(char c: word.toCharArray()) {
            
            if(!it.mapy.containsKey(c))
                return false;
            
            it = it.mapy.get(c);
        }
        
        return it.endOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        if(prefix == null)
            return false;
        if(prefix.length() == 0)
            return root.endOfWord;
        
        TrieNode it = root;
        
        for(char c: prefix.toCharArray())   {
            
            if(!it.mapy.containsKey(c))
                return false;
            
            it = it.mapy.get(c);
        }
        
        return true;
    }
}