public class Problem2_2
{
	public static void main(String [] args)
	{

		LinkedList list = new LinkedList();
		
		list.prepend(9);
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(6);
		list.appendToTail(3);
		list.appendToTail(5);
		list.appendToTail(7);
		
		System.out.println(list.toString()); 
		System.out.println("Size: " + list.size()); 
		System.out.print("\n"); 
		
		System.out.println(list.findKthElement(4)); 

		System.out.println(list.toString()); 
	}
}