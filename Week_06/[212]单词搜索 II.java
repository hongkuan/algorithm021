//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 回溯算法 
// 👍 310 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static class TrieNode {
        private Map<Character, TrieNode> children;
        private String word;
        private TrieNode(){
            this.children = new HashMap<>();
            this.word = null;
        }

        private boolean containKey(char ch){
            return children.containsKey(ch);
        }

        private void put(char ch, TrieNode node){
            children.put(ch, node);
        }

        private TrieNode get(char ch){
            return children.get(ch);
        }

        private void setWord(String word){
            this.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (null == board || board.length== 0 || board[0] == null || board[0].length == 0 || null == words || words.length == 0) return res;
        TrieNode trie = buildTrie(words);
        for (int i =0 ; i < board.length ; i++){
            for (int j =0 ; j< board[i].length; j++){
                if (trie.children.containsKey(board[i][j]))
                    dfs(board, i,j, trie,res);
            }
        }
        return res;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode trie = new TrieNode();
        for (String word : words){
            trieNodePut(trie, word);
        }
        return trie;
    }

    private void trieNodePut(TrieNode node, String word){
        for (char ch : word.toCharArray()){
            if (!(node.containKey(ch))) node.put(ch, new TrieNode());
            node = node.get(ch);
        }
        node.word = word;
    }

    private void dfs(char[][] board, int i, int j, TrieNode trie, List<String> res) {
        char ch = board[i][j];
        TrieNode curNode = trie.children.get(ch);
        if (null != curNode.word) {
            res.add(curNode.word);
            curNode.word = null;
        }
        board[i][j] = '#';

        int[] rowOffset = {-1,0,1,0};
        int[] colOffset = {0,-1,0,1};
        for (int m =0 ; m< rowOffset.length; m++){
            int newRow = i+ rowOffset[m];
            int newCol = j+ colOffset[m];
            if (!(newRow>=0 && newCol >=0 && newRow < board.length && newCol< board[0].length))continue;
            char tmp = board[newRow][newCol];
            if (curNode.children.containsKey(tmp)){
                dfs(board, newRow, newCol, curNode, res);
            }
        }
        board[i][j] = ch;
        if (curNode.children.isEmpty())
            trie.children.remove(ch);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
