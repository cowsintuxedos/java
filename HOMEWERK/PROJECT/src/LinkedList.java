
public class LinkedList {
	ListNode first;
	
	public LinkedList() {
		
	}
	
	public void add(int number) {
		if (first== null) {
			first = new ListNode(number);
			first.setValue(number);
		}
		else {
			ListNode temp = first;
			while (temp.getNext() != null) {
				temp = temp.getNext();
				
			}
			temp.setNext(new ListNode(number));
		}
		
	}
	
	public void removeNth(int index) {
		int position = 0;
		ListNode temp = first;
		
		while (position < index - 1) {
			position ++ ;
			temp = temp.getNext();
		}
		
		if (position == index) {
			temp.setNext(temp.getNext().getNext());
		}
		
	}
	
	public void removeFirst() {
		{
			first=first.getNext();
		}
	}
	
	public void removeLast() {
		
	}
	
	public void remove(int number) {
		if (first.getValue()==number ){
			first=first.getNext();
		}
		
			ListNode a = first;
			ListNode b = first.getNext();
			while (b!= null) {
			if (b.getValue() == number) {
				a.setNext(b.getNext());
				b=b.getNext();
			}
			if (b != null){
			b = b.getNext();
			}
			a = a.getNext();
			
		}
		
	}
	
	public void print() {
		ListNode temp = first;
		System.out.print('[');
		while (temp != null) {
			System.out.print(temp.getValue());
			temp = temp.getNext();	
		}
		System.out.print(']');
		//System.out.print(first.getValue());
		//print out a node
		//ask for the next value
		//repeat
	}
	
	public int size() {
		int size=0;
		ListNode check = first;
		while (check != null) {
			size ++ ;
			check = check.getNext();
		}
		return size;
	}
}
