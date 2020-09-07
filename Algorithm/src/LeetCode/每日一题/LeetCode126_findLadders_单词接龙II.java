package LeetCode.每日一题;

import java.util.*;

/**
 * Description
 * Author  HongbinW
 * Date 2020/6/7
 */
public class LeetCode126_findLadders_单词接龙II {
    public static void main(String[] args) {
        String beginWord = "a";
        String endWord = "c";
        String[] words = new String[]{"a","b","c"};
        List<String> wordList = new ArrayList<>();
        for (String str : words){
            wordList.add(str);
        }
        new LeetCode126_findLadders_单词接龙II().findLadders(beginWord,endWord,wordList);
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> wordConnect = new HashMap<>();
        for (int i = 0; i < wordList.size() - 1; i ++){
            List<String> list = new ArrayList<>();
            if (wordConnect.containsKey(wordList.get(i))){
                list = wordConnect.get(wordList.get(i));
            }
            char[] chs1 = wordList.get(i).toCharArray();
            for (int j = i + 1; j < wordList.size(); j ++){
                char[] chs2 = wordList.get(j).toCharArray();
                int diff = 1;
                int index = 0;
                while (index < chs1.length){
                    if (chs1[index] == chs2[index]){
                        index ++;
                    }else if (diff > 0){
                        index ++;
                        diff --;
                    }else{
                        break;
                    }
                }
                if (index == chs1.length){
                    list.add(wordList.get(j));
                    if (wordConnect.containsKey(wordList.get(j))){
                        wordConnect.get(wordList.get(j)).add(wordList.get(i));
                    }else{
                        List<String> t = new ArrayList<>();
                        t.add(wordList.get(i));
                        wordConnect.put(wordList.get(j),t);
                    }
                }
            }
            wordConnect.put(wordList.get(i),list);
        }
        if (!wordConnect.containsKey(beginWord)){
            char[] chs1 = beginWord.toCharArray();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < wordList.size(); i ++){
                char[] chs2 = wordList.get(i).toCharArray();
                int diff = 1;
                int index = 0;
                while (index < chs1.length){
                    if (chs1[index] == chs2[index]){
                        index ++;
                    }else if (diff > 0){
                        index ++;
                        diff --;
                    }else{
                        break;
                    }
                }
                if (index == chs1.length){
                    list.add(wordList.get(i));
                    if (wordConnect.containsKey(wordList.get(i))){
                        wordConnect.get(wordList.get(i)).add(wordList.get(i));
                    }else{
                        List<String> t = new ArrayList<>();
                        t.add(wordList.get(i));
                        wordConnect.put(wordList.get(i),t);
                    }
                }
            }
                wordConnect.put(beginWord,list);
            }

        if (!wordConnect.containsKey(endWord)){
            return res;
        }
        List<String> x = new ArrayList<>();
        x.add(beginWord);
        process(res,wordConnect,beginWord,endWord,x);
        for (int i = 0; i < res.size();){
            if (res.get(i).size() != minSize){
                res.remove(i);
            }else{
                i ++;
            }
        }
        return res;
    }
    int minSize = Integer.MAX_VALUE;
    public void process(List<List<String>> res, HashMap<String,List<String>> wordConnect,
                        String beginWord, String endWord,List<String> list){
        List<String> curList = wordConnect.get(beginWord);
        for (int i = 0; i < curList.size(); i ++){
            String tmp = curList.get(i);
            if (wordConnect.containsKey(tmp)){
                list.add(tmp);
                if (tmp.equals(endWord)){
                    res.add(new ArrayList<>(list));
                    minSize = Math.min(minSize,list.size());
                }
                wordConnect.remove(beginWord);
                process(res,wordConnect,tmp,endWord,list);
                wordConnect.put(beginWord,curList);
                list.remove(tmp);
            }
        }
    }
    class MyComparator implements Comparator<List<String>>{
        @Override
        public int compare(List<String> o1, List<String> o2) {
            return o1.size() - o2.size();
        }
    }
}

// [["hit","hot","dot","dog","log","cog"],["hit","hot","dot","dog","cog"],["hit","hot","dot","lot","log","dog","cog"],["hit","hot","dot","lot","log","cog"],["hit","hot","lot","dot","dog","log","cog"],["hit","hot","lot","dot","dog","cog"],["hit","hot","lot","log","dog","cog"],["hit","hot","lot","log","cog"]]
