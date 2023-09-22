class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for(int i = 0; i < word.length(); i ++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public Trie[] getChildren() {
        return children;
    }

    public boolean getIsEnd() {
        return isEnd;
    }
}

class WordDictionary {
    private Trie node;

    public WordDictionary() {
        node = new Trie();
    }

    public void addWord(String word) {
        node.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, node);
    }

    public boolean dfs(String word, int index, Trie node) {
        if(index == word.length()) {
            return node.getIsEnd();
        }
        char ch = word.charAt(index);
        if(Character.isLetter(ch)) {
            int childIndex = ch - 'a';
            if(node.getChildren()[childIndex] != null && dfs(word, index + 1, node.getChildren()[childIndex])) {
                return true;
            }
        } else {
            for(int i = 0; i < 26; i ++) {
                if(node.getChildren()[i] != null && dfs(word, index + 1, node.getChildren()[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
