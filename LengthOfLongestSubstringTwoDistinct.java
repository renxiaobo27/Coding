package test;

import java.util.HashMap;
import java.util.Map;

//Longest Substring with At Most Two Distinct Characters
//Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
//
//For example, Given s = “eceba”,
//
//T is "ece" which its length is 3.
//分析
//这种类型的题都应该用两个指针解决，同时用一个map来记录字符及其出现次数。一个右指针先移动，不断更新map, 当发现map里的字符个数大于规定个数的时候，开始移动左指针，同时更新map,直到map里的字符个数等于规定个数，中间不断更新包含规定字符个数的最大长度。
//
//这道题的Follow up很直接，比如题目变为最多允许k个字符，该怎么处理？
//下面的代码直接把2改成k即可。
public class LengthOfLongestSubstringTwoDistinct {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int i = 0;
        int maxLen = 0;
        while (i < s.length()) {
            
            // 根据右指针指的当前字符更新map
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
            
            // 移动左指针，直到map中字符数量降至规定数量
            while (map.size() > 2) {
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                
                    // 注意会有重复元素，所以先减小次数，只有次数降至0，才删除元素
                    map.put(leftChar, map.get(leftChar) - 1);                     
                    if (map.get(leftChar) == 0) { 
                        map.remove(leftChar);
                    }
                }
                left++;
            }               
            maxLen = Math.max(maxLen, i - left + 1);
            i++;
        }
        return maxLen;
    }
}
