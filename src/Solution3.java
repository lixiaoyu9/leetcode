import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
public class Solution3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("wkeksw"));
        System.out.println(lengthOfLongestSubstring1("pwwkew"));
        System.out.println(lengthOfLongestSubstring1("wkekswqwaaaa"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int rk = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rk < s.length() && !set.contains(s.charAt(rk))) {
                set.add(s.charAt(rk));
                rk++;
            }
            ans = Math.max(ans, rk - i);
        }
        return ans;
    }

    //wkekswqwaaaa
    // 更好理解
    public static int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                // start右移
                start = Math.max(map.get(s.charAt(end)) + 1, start);
            }
            map.put(s.charAt(end), end);
            ans = Math.max(end - start + 1, ans);
        }
        return ans;
    }
}
