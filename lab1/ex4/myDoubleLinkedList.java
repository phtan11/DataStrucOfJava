package labDataStrucAndAl.lab1.ex4;
import java.util.NoSuchElementException;
public class myDoubleLinkedList {
    private DoubleNode head;
    public myDoubleLinkedList(){
        this.head = null;
    }
    public void addFirst(double data){
        DoubleNode newNode = new DoubleNode(data);
        newNode.setNext(head);
        head = newNode;
    }
    public void appends(double data){
        DoubleNode newNode = new DoubleNode(data);
        DoubleNode last = head;
        while(last.getNext() != null){
            last = last.getNext();
        }
        newNode.setNext(null);
        last.setNext(newNode);
    }
    public DoubleNode currentNode(double data){
        DoubleNode tmp = head;
        while(tmp.getNext() != null){
            if(tmp.getData()==data){
                break;
            }
            tmp = tmp.getNext();
        }
        return tmp;
    }
    public void removeList(DoubleNode curr)throws NoSuchElementException {
        if(head==null){
            throw new NoSuchElementException("o kiaaaa");
        }
        else{
            DoubleNode pre = null;
            DoubleNode last = head;
            while(last.getNext() != null){
                if(last.equals(curr)){
                    pre.setNext(last.getNext());
                }
                pre = last;
                last = last.getNext();
            }
        }
    }
    public void printt(){
        DoubleNode last = head;
        while(last != null){
            System.out.print("("+last.getData() +")"+ "->");
            last = last.getNext();
        }
        System.out.print("null");
    }
}
