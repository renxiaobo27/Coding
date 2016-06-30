//Given an unsorted array of integers, find the length of longest increasing subsequence.
//
//For example,
//Given [10, 9, 2, 5, 3, 7, 101, 18],
//The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
//
//Your algorithm should run in O(n2) complexity.
//
//Follow up: Could you improve it to O(n log n) time complexity?
		
//!! TO DO nlogn	
public class DP_LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int[]dp = new int[nums.length];
        int local = 1;
        int max = 1;
        
        for(int i=0;i<nums.length;i++)
        {
            local = 1;
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    local = Math.max(local,dp[j]+1);
                }
            }
            
            dp[i] = Math.max(dp[i],local);
            max = Math.max(dp[i],max);
        }
        
        return max;
    }
}

//C++
//class Solution {
//public:
//    int lengthOfLIS(vector<int>& nums) {
//        vector<int> dp(nums.size(), 1);
//        int res = 0;
//        for (int i = 0; i < nums.size(); ++i) {
//            for (int j = 0; j < i; ++j) {
//                if (nums[i] >= nums[j]) {
//                    dp[i] = max(dp[i], dp[j] + 1);
//                }
//            }
//            res = max(res, dp[i]);
//        }
//        return res;
//    }
//};



//我们来看一种思路更清晰的二分查找法，跟上面那种方法很类似，思路是先建立一个空的dp数组，然后开始遍历原数组，对于每一个遍历到的数字，我们用二分查找法在dp数组找第一个不小于它的数字，如果这个数字不存在，那么直接在dp数组后面加上遍历到的数字，如果存在，则将这个数字更新为当前遍历到的数字，最后返回dp数字的长度即可，注意的是，跟上面的方法一样，特别注意的是dp数组的值可能不是一个真实的LIS。参见代码如下：
//
//
//
//解法三：
//
//复制代码
//class Solution {
//public:
//    int lengthOfLIS(vector<int>& nums) {
//        vector<int> dp;
//        for (int i = 0; i < nums.size(); ++i) {
//            int left = 0, right = dp.size();
//            while (left < right) {
//                int mid = left + (right - left) / 2;
//                if (dp[mid] < nums[i]) left = mid + 1;
//                else right = mid;
//            }
//            if (right >= dp.size()) dp.push_back(nums[i]);
//            else dp[right] = nums[i];
//        }
//        return dp.size();
//    }
//};
//复制代码
// 
//
//下面我们来看两种比较tricky的解法，利用到了C++中STL的lower_bound函数，
//lower_bound返回数组中第一个不小于指定值的元素，跟上面的算法类似，
//我们还需要一个一维数组v，然后对于遍历到的nums中每一个元素，找其lower_bound，
//如果没有lower_bound，说明新元素比一维数组的尾元素还要大，直接添加到数组v中，跟解法二的思路相同了。
//如果有lower_bound，说明新元素不是最大的，将其lower_bound替换为新元素，
//这个过程跟算法二的二分查找法的部分实现相同功能，最后也是返回数组v的长度，注意数组v也不一定是真实的LIS，参见代码如下：
//
// 
//
//解法四：
//
//复制代码
//class Solution {
//public:
//    int lengthOfLIS(vector<int>& nums) {
//        vector<int> v;
//        for (auto a : nums) {
//            auto it = lower_bound(v.begin(), v.end(), a);
//            if (it == v.end()) v.push_back(a);
//            else *it = a;
//        }
//　　　　　 　return v.size();
//    }
//};
//复制代码
