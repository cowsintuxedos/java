
public class ListFun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(2);
		//list.add(3);
		list.add(4);
		list.add(3);
		list.add(6);
		list.add(9);
		list.add(1);
		list.add(5);
		list.add(3);
		list.print();
		System.out.println(" List size is " + list.size());
		
		list.remove(4);
		list.print();
		
		list.remove(5);
		list.print();
		
		list.remove(3);
		list.print();
		
		System.out.println(" List size is " + list.size());
	}

}
