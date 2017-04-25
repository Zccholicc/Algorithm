import java.util.Iterator;
public class LinkedQueue<T> extends Iterable<T>{
	private Node first;
	private Node last;
	private int N;
	private class Node{
		Node next;
	    T  item;
	}
    public int getSize(){
	    return N;
	}
    public boolean isEmpty(){
    	return N==0;
    }
	public void enqueue(T t){
		Node oldlast=last;
		last=new Node();
		last.item=t;
		last.next=null;
	    if(isEmpty()){
	      first=last;
	    }
	    else{
	      oldlast.next=last;
	    }
	    N++;
	 }
	 public T dequeue(){
		 T item=first.item;
		 first=first.next;
		 if(isEmpty()){
			 last.next=null;
		 }
		 N--;
		 return item;
	 }
	 public Iterator<T> iterator(){
		 return new ListIterator();
	 }
	 private class ListIterator  Iterator<T>{
		private Node a=first;
		public boolean hasNext() {
			return a.next==null;
		}
		public T next() {
			T item=a.item;
			a=a.next;
			return item;
		}
	 }

	public static void main(String[] args) {

	}

}
