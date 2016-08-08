
using turn to select the appearance of the same character.
if the two word not same, it would not affect the result;
if the two words same, it would tell the first and third ....
careful about the if else if structure

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
			 else if(words[i].equals(word2)) //careful the else if
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
