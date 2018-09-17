import java.util.*; 

public class SortingAlgorithms{

	/*
	 * Pseudo-Code (increasing and decreasing order): 
	 * for i = 2 to A.length 
	 * 	key = A[i]
	 * 	j = i - 1
	 * 	while j >= 0 and A[j] > key
	 * 		A[j+1] = A[j]
	 * 		j = j - 1
	 * 	A[j+1] = key 
	 *
	 */

	public static void Insertion_Sort_Increasing(int [] A){
		
		for(int i = 1; i < A.length; i++){
			int key = A[i];
			int j = i - 1; 
			while(j >= 0 && A[j] > key){
				A[j+1] = A[j];
				j -= 1; 
			}
			A[j+1] = key; 
		} 
	} 
	 public static void Insertion_Sort_Decreasing(int [] A){

                for(int i = 1; i < A.length; i++){
                        int key = A[i];
                        int j = i - 1;
                        while(j >= 0 && A[j] < key){
                                A[j+1] = A[j];
                                j -= 1;
                        }
                        A[j+1] = key;
                }
        }


	//Run the algorithms!!
	public static void main(String [] args){
		int [] A = {5,2,4,6,1,3}; 
		
		Insertion_Sort_Increasing(A);
		
		System.out.println("Increasing order: " + Arrays.toString(A)); 
		
		Insertion_Sort_Decreasing(A);
                
		System.out.println("Decreasing order: "+ Arrays.toString(A));
	}
}
