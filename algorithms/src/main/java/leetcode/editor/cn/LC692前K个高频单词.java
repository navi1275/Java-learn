package leetcode.editor.cn;
 
//给一非空的单词列表，返回前 k 个出现次数最多的单词。 
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 
//
// 示例 1： 
//
// 
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
// = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
// 输入的单词均由小写字母组成。 
// 
//
// 
//
// 扩展练习： 
//
// 
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
// 
// Related Topics 堆 字典树 哈希表 
// 👍 247 👎 0

import java.util.*;

/**
 * LC692前K个高频单词
 * 2021-05-19 21:31:59
 */
public class LC692前K个高频单词{
    public static void main(String[] args) {
//          Solution solution = new LC692前K个高频单词().new Solution();
            
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        class WordData{
            public String word;
            public Integer count;

            public WordData(String word, Integer count) {
                this.word = word;
                this.count = count;
            }
        }
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<WordData> pq = new PriorityQueue<WordData>((d1, d2) -> {
            return d2.count.equals(d1.count) ? d1.word.compareTo(d2.word) : d2.count - d1.count;
        });
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            if(map.containsKey(words[i])) {
                Integer count = map.get(words[i]);
                map.put(words[i], ++count);
            }else{
                map.put(words[i], 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            WordData wordData = new WordData(key, value);
            pq.add(wordData);
        }
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if(!pq.isEmpty()) {
                ret.add(pq.poll().word);
            }
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}