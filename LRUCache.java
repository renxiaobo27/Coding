import java.util.HashMap;

//Design and implement a data structure for 
//Least Recently Used (LRU) cache. It should support the following operations: get and set.
//
//get(key) - Get the value (will always be positive) of the key 
//if the key exists in the cache, otherwise return -1.
//set(key, value) - Set or insert the value if 
//the key is not already present. When the cache 
//reached its capacity, it should invalidate the 
//least recently used item before inserting a new item.
//

class Node
{
    public int key;
    public int val;
    public Node next;
    public Node prev;
    
    public Node(int key,int val)
    {
        this.key = key;
        this.val = val;
        
        
    }
    
}

public class LRUCache {

	 public HashMap<Integer,Node> map = new HashMap<Integer,Node>();
	    public int size;
	    public Node head;
	    public Node tail;
	    
	    public LRUCache(int capacity) {
	        this.size = capacity;
	        head = new Node(-1,-1);
	        tail = new Node(-1,-1);
	        head.next = tail;
	        tail.prev = head;
	        
	    }
	    
	    public int get(int key) {
	        if(map.containsKey(key))
	        {
	            Node t = map.get(key);
	            moveToHead(t);
	            return t.val;
	        }
	        return -1;
	       
	    }
	    
	    public void moveToHead(Node t)
	    {
	        t.prev.next = t.next;
	        t.next.prev = t.prev;
	        
	        attchToHead(t);
	    }
	    
	    public void attchToHead(Node t)
	    {
	        t.next = head.next;
	        t.next.prev = t;//carful here
	        head.next = t;
	        t.prev = head;
	    }
	    
	    public void set(int key, int value) {
	        
	        
	        if(map.containsKey(key))
	        {
	            Node t = map.get(key);
	            t.val = value;
	            map.put(key,t);
	            moveToHead(t);
	        }
	        else
	        {
	            Node t = new Node(key,value);
	            map.put(key,t);
	            attchToHead(t);
	            //size++;
	        }
	        if(map.size()>size)
	        {
	            remove();
	            //size--;
	        }
	        
	    }	    
	    public void remove()
	    {
	        Node lastNode = tail.prev;
	        tail.prev = lastNode.prev;
	        lastNode.prev.next = tail;
	        map.remove(lastNode.key);
	    }
}
