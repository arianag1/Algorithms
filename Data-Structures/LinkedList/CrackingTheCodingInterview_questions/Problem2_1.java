/*
Remove Dups:Write code to remove duplicates from an 
			unsorted linked list 
*/ 

public class Problem2_1
{

	public static void main(String [] args)
	{
		LinkedList list = new LinkedList();

		list.prepend(3);
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(6);
		list.appendToTail(3);
		list.appendToTail(5);
		list.appendToTail(3);
		
		System.out.println(list.toString()); 
		System.out.println("Size: " + list.size()); 
		System.out.print("\n"); 
		list.deleteDuplicates(3);

		System.out.println(list.toString()); 
		System.out.println("Size: " + list.size()); 
	}
}


