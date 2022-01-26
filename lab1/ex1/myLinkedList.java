package labDataStrucAndAl.lab1.ex1;
import java.util.NoSuchElementException;
public class myLinkedList <E> implements ListInterface <E> {
    private Node <E> head;
    private int numNode;
    public myLinkedList(){
        head = null;
        numNode = 0;
    }
    @Override
    public void addFirst(E item){
        Node <E> r = new Node<E>(item);
        r.setNext(head);
        head = r;
        numNode++;
    }
    @Override
    public void addAfter(Node <E> curr,E item){
        if(curr == null){
            addFirst(item);
        }
        Node <E> s = new Node<E>(item);
        s.setNext(curr.getNext());
        curr.setNext(s);
        numNode++;
    }
    @Override
    public void addLast(E item){
        Node <E> r = new Node<E>(item);
        Node <E> last = head;
        while(last.getNext()!=null){
            last = last.getNext();
        }
        r.setNext(null);
        last.setNext(r);
        numNode++;
    }

    @Override
    public E removeFirst() throws NoSuchElementException{
        if(head==null){
            throw new NoSuchElementException("cant remove element form an empty list");
        }
        else{
            Node <E> tmp = head;
            head =head.getNext();
            numNode--;
            return tmp.getData();
        }
    }
    @Override
    public E removeLast() throws NoSuchElementException{
        if(head==null){
            throw new NoSuchElementException("cant remove element from an empty list");
        }
        else{
            Node <E> tmp = head;
            Node <E> pre = null;
            while(tmp.getNext()!=null){
                pre = tmp;
                tmp=tmp.getNext();
            }
            pre.setNext(tmp.getNext());
            tmp.setNext(null);
            numNode--;
            return tmp.getData();
        }
    }
    @Override
    public void print(){
        Node <E> last =head;
        while(last != null){
            System.out.print(last.getData() +"->");
            last= last.getNext();
        }
        System.out.print("null");
    }
    @Override
    public boolean isEmpty(){
        if(numNode ==0) return false;
        return true;
    }
    @Override
    public E getFirst() throws NoSuchElementException{
        if(head == null){
            throw new NoSuchElementException("Can't get element from an empty list");
        }
        else{
            return head.getData();
        }
    }  
    @Override
    public Node<E> getHead(){
        return head;
    }
    @Override
    public int size(){
        return numNode;
    }
    @Override
    public boolean contains(E item){
        Node<E> tmp = head;
        while(tmp != null){
        if(tmp.getData().equals(item))
            return true;
            tmp = tmp.getNext();
        }
        return false;
    }
}
