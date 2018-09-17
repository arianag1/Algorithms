public class Problem2_5
{

	public static void main(String [] args)
	{
		/*	
		* Problem 2.5 part 1
		*
		*/
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList twoLists = new LinkedList();

		list1.prepend(7);
		list1.appendToTail(1);
		list1.appendToTail(6);

		list2.prepend(5);
		list2.appendToTail(9);
		list2.appendToTail(2);

		String result = twoLists.sumList(list1, list2,true).toString();
		System.out.println(result); 

		/*	
		* Problem 2.5 part 2 (when lists are not in reverse)
		*
		*/

		 list1 = new LinkedList();
		 list2 = new LinkedList();

		list1.prepend(6);
		list1.appendToTail(1);
		list1.appendToTail(7);

		list2.prepend(2);
		list2.appendToTail(9);
		list2.appendToTail(5);

		result = twoLists.sumList(list1, list2,false).toString();
		System.out.println(result); 
	}
}