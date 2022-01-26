package lab2.ex1;
public class myStack <E> implements listInterface <E> {
    private Node<E> head;
    private int numNode;
    public myStack(){
        head = null;
        numNode = 0;
    }
    @Override
    public boolean isEmpty(){
        return numNode == 0;
    }
    @Override
    public int size(){
        return numNode;
    }
    public E getFirst(){
        if(head==null) System.out.println("head == null/");
        else return head.getElement();
        return null;
    }
    @Override
    public boolean contains(E item){
        Node<E> last = head;
        while(last.getNext() != null){
            if(last.getElement() == item){
                return true;
            }
            last = last.getNext();
        }
        return false;
    }
    @Override
    public void addFirst(E e) {
        head = new Node<E>(e, head);
        numNode++;
    }
    @Override
    public E removeFirst(){
        Node<E> tmp = head;
        if(head == null){
            System.out.println("head == null");
        }
        else{
            head =head.getNext();
            numNode--;
            return tmp.getElement();
        }
        return null;
    }
    @Override
    public void print(){
		Node <E> ln = head;
		System.out.print("List is: " + ln.getElement());
		for (int i=1; i < numNode; i++) {
			ln = ln.getNext();
			System.out.print(", " + ln.getElement());
		}
		System.out.println(".");
	}
}
