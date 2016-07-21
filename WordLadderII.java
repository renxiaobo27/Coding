import java.util.*;
public class WordLadderII {

	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        List<List<String>> re = new ArrayList<List<String>>();
        getDist(beginWord,endWord,wordList,map);
        
        dfs(map,beginWord,endWord,new ArrayList<String>(),re);
        
        return re;
    }
    
    public void dfs(HashMap<String,Integer> map,String end,String begin,ArrayList<String> tmp, List<List<String>> re)
    {
        if(end.equals(begin))
        {
            List<String> l = new ArrayList<String>(tmp);
            l.add(end);
            Collections.reverse(l);
            re.add(l);
            return;
        }
        tmp.add(begin);
        for(int i=0;i<begin.length();i++)
        {
            char[] strchars = begin.toCharArray();
            for(char c='a';c<='z';c++)
            {
                strchars[i] = c;
                String newStr = new String(strchars);
                if(map.containsKey(newStr) && map.get(begin)-map.get(newStr)==1)
                {
                    
                    dfs(map,end,newStr,tmp,re);
                }
                
            }
        }
        tmp.remove(tmp.size()-1);
    }
    public void getDist(String beginWord, String endWord, Set<String> wordList,HashMap<String,Integer> map)
    {
        map.put(beginWord,1);
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        
        while(!q.isEmpty())
        {
            String cur = q.poll();
            for(int i=0;i<cur.length();i++)
            {
                char[]strs = cur.toCharArray();
                for(char c='a';c<='z';c++)
                {
                    strs[i] = c;
                    
                    String newStr = new String(strs);
                    if(newStr.equals(endWord))
                    {
                        map.put(newStr,map.get(cur)+1);
                        return;
                    }
                    if(wordList.contains(newStr)&&!map.containsKey(newStr))
                    {
                        map.put(newStr,map.get(cur)+1);
                        q.add(newStr);
                    }
                    
                }
            }
        }
    }
    
    public static void main(String[]strs)
    {
    	WordLadderII w = new WordLadderII();
    	Set<String> set = new HashSet<String>();
    	set.add("a");
    	set.add("b");
    	set.add("c");
    	
    	w.findLadders("a", "c", set);
    }
}
