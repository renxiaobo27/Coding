//Given an array of strings, group anagrams together.
//
//For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
//Return:
//
//[
//  ["ate", "eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//		

//map.values
public class GroupAnagrams {

	 public List<List<String>> groupAnagrams(String[] strs) {
	        List<List<String>> re = new ArrayList<List<String>>();
	        if(strs==null || strs.length==0)
	            return re;
	        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
	        
	        for(int i=0;i<strs.length;i++)
	        {
	            String str = strs[i];
	            char [] charArray = str.toCharArray();
	            Arrays.sort(charArray);
	            String newStr = new String(charArray);
	            
	            if(map.containsKey(newStr))
	            {
	                map.get(newStr).add(str);
	            }
	            else
	            {
	                ArrayList<String> tmp = new ArrayList<String>();
	                tmp.add(str);
	                map.put(newStr,tmp);
	            }
	        }
	        
	        for(ArrayList<String> t:map.values())
	        {
	            Collections.sort(t);
	            re.add(t);
	        }
	        return re;
	    }
}
