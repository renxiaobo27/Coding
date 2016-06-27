package relatedTopic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;


//Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
//
//Note:
//If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
//All airports are represented by three capital letters (IATA code).
//You may assume all tickets form at least one valid itinerary.
//Example 1:
//tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
//Example 2:
//tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
//Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.

public class ReconstructItinerary {

	 public LinkedList<String> re = new LinkedList<String>();
	    Map<String,PriorityQueue<String>> map = new HashMap<String,PriorityQueue<String>>();
	     
	    public List<String> findItinerary(String[][] tickets) {
	        //List<String> re = new ArrayList<INteger>();
	        if(tickets==null || tickets.length==0)
	            return re;
	       
	        
	        for(String[] ticket:tickets)
	        {
	            if(map.containsKey(ticket[0]))
	            {
	                map.get(ticket[0]).offer(ticket[1]);
	            }
	            else
	            {
	                PriorityQueue<String> tmp = new  PriorityQueue<String>();
	                tmp.offer(ticket[1]);
	                map.put(ticket[0],tmp);
	            }
	        }
	        
	        dfs("JFK");
	        return re;
	    }
	    
	    public void dfs(String s)
	    {
	        while(map.containsKey(s) && !map.get(s).isEmpty())
	        {
	            dfs(map.get(s).poll());
	        }
	        re.addFirst(s);
	    }
	
}
