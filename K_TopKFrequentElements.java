//Given a non-empty array of integers, return the k most frequent elements.
//
//For example,
//Given [1,1,1,2,2,3] and k = 2, return [1,2].
		
public class K_TopKFrequentElements {

	public class Node
	{
		public int val;
		public int ct;
		public Node(int val,int ct)
		{
			this.val = val;
			this.ct = ct;
		}
	}

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> re = new ArrayList<Integer>();
        if(nums==null || nums.length==0)
            return re;
        
        HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i],map.get(nums[i])+1);
            }
            else
            {
                map.put(nums[i],1);
            }
        }
        Node [] nodes = new Node[map.size()];
        int j=0;
        for(int key:map.keySet())//!!!!!
        {
            nodes[j++] = new Node(key,map.get(key));
        }
        
        PriorityQueue<Node> q = new PriorityQueue<Node>(nodes.length,new Comparator<Node>(){
                public int compare(Node n1,Node n2)
                {
                    return n2.ct - n1.ct;
                }
            });
        for(int i=0;i<nodes.length;i++)
        {
            q.offer(nodes[i]);
        }
        
        for(int i=0;i<k;i++)
        {
            re.add(q.poll().val);
        }
        
        return re;
        
    }
}
