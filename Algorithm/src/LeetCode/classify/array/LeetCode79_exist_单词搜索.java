package LeetCode.classify.array;

/**
 * @Author: HongbinW
 * @Date: 2019/9/26 22:31
 * @Version 1.0
 * @Description: https://leetcode-cn.com/problems/word-search/
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */

/**
 * 思路，回溯法，退回去的时候要把之间visite的地方置为false
 */
public class LeetCode79_exist_单词搜索 {
    // 80.6% 97.3%
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0){
            return false;
        }
        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board[0].length; j ++){
                if (board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if(process(board,visited,word,0,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean process(char[][] board, boolean[][] visited, String word, int start, int i, int j){
        if (start == word.length()){
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]){
            return false;
        }
        if (word.charAt(start) == board[i][j]) {
            visited[i][j] = true;
            if(process(board, visited, word, start + 1, i + 1, j) ||
                    process(board, visited, word, start + 1, i - 1, j) ||
                    process(board, visited, word, start + 1, i, j + 1) ||
                    process(board, visited, word, start + 1, i, j - 1)){
                return true;
            }else{
                visited[i][j] = false;
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode79_exist_单词搜索().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
    }
}
