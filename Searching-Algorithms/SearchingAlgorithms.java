public class SearchingAlgorithms{
	
	/*
	 * for i = 0 to A.length
	 * 	if A[i] = v 
	 * 		return i
	 *return -1 
	 *
	 */

	public static int linearSearch(int [] A, int v){
		for(int i = 0; i < A.length; i++){
			if(A[i] == v){
				return i;
			}
		}
		return -1; 
	}
	public static void main(String [] args){
		int [] A = {31,41,59,26,41,58};
		System.out.println("Should return -1: " + linearSearch(A, 1));
		System.out.println("Should return 1: " + linearSearch(A, 41));
	}
}
