import java.util.*; 

public class SortingAlgorithms{

	public static void Insertion_Sort(int [] A){
		
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

	public static void main(String [] args){
		int [] A = {5,2,4,6,1,3}; 
		Insertion_Sort(A);
		System.out.print(Arrays.toString(A)); 	
	
	}
}
