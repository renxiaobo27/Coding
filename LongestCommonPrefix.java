//Write a function to find the longest common prefix string amongst an array of strings.
//
//start from the first char, compare it with all string, and then the second char

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0)
            return "";
        String str0 = strs[0];
        
       
        for(int i=0;i<str0.length();i++)
        {
            for(int j=1;j<strs.length;j++)
            {
                String str = strs[j];
                if(i>=str.length() || str0.charAt(i)!=str.charAt(i))
                    return str.substring(0,i);
            }
        }
        return str0;
    }
}


//C++
//class Solution {
//public:
//    string longestCommonPrefix(vector<string> &strs) {
//        string comPrefix;
//        if(strs.empty()) return comPrefix;
//        for(int i=0; i<strs[0].size(); i++) {
//            for(int j=1; j<strs.size(); j++) {
//                if(i>=strs[j].size() || strs[j][i]!=strs[0][i])
//                    return comPrefix;
//            }
//            comPrefix.push_back(strs[0][i]);
//        }
//        return comPrefix;
//    }
//};
