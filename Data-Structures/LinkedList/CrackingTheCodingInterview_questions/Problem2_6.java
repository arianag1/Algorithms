public class Problem2_6
{
	public static void main(String [] args)
	{
		LinkedList list = new LinkedList();
		
		/*
		list.prepend(7);
		list.appendToTail(1);
		list.appendToTail(6);
		*/ 

		list.prepend(1);
		list.appendToTail(6);
		list.appendToTail(1);

		Boolean result = list.isAPalindrome(list.head); 
		System.out.println(result); 


	}
}