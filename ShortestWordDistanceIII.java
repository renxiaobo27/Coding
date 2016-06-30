

public class ShortestWordDistanceIII {

	 public int shortestWordDistance(String[] words, String word1, String word2) {
		 
		 int turn = 0;
		 int incr = 0;
		 if(word1.equals(word2))
			 incr = 1;
		 
		 int dist = Integer.MAX_VALUE;
		 int index1 = -1;
		 int index2 = -1;
		 
		 for(int i=0;i<words.length;i++)
		 {
			 if(words[i].equals(word1) && turn==0)
			 {
				 index1 = i;
				 if(index2!=-1)
					 dist = Math.min(dist, index1-index2);
				 turn += incr;
			 }
			 else if(words[i].equals(word2))
			 {
				 index2 = i;
				 if(index1!=-1)
					 dist = Math.min(dist, index2-index1);
				 turn +=incr;
			 }
		 }
		 
		 return dist;
	 }
}
