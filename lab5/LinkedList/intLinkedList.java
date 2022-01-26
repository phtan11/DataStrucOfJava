package LinkedList;

public class intLinkedList implements listInterface {
    private Node head;
    public intLinkedList(){
        head=null;
    }
    @Override
    public void addFirst(int data){
       //head = new Node(data,head);
        Node n = new Node(data);
        n.setNext(head);
        head = n;
    }
    @Override
    public boolean addLast(int data){
        Node n = new Node(data);
        Node last = head;
        while(last.getNext()!= null){
            last = last.getNext();
        }
        n.setNext(null);
        last.setNext(n);
        return true;
    }
    @Override
    public boolean removeAt(int position){
        Node current = head;
        Node pre = null;
        while(current!=null){
            if(position == current.getData()){
                pre.setNext(current.getNext());
            }
            pre = current;
            current = current.getNext();
        }
        return true;
    }
    @Override
    public int countOdd(){
        int count =0;
        Node last = head;
        while(last!= null){
            if(last.getData() % 2 != 0){
                count++;
            }
            last = last.getNext();
        }
        return count;
    }
    @Override
    public int searchKey(int key){
        Node last = head;
        while(last!=null){
            if(last.getData() == key){
                return 1;
            }
            last = last.getNext();
        }
        return -1;
    }
    @Override
    public boolean checkSorted(){
        Node curr = head;
        Node pre = null;
        while(curr.getNext()!=null){
            pre = curr;
            curr = curr.getNext();
            if(pre.getData() > curr.getData()){
                return false;
            }
        }
        return true;
    }
    @Override
    public int sumOdd(){
        int sum=0;
        Node curr = head;
        while(curr!=null){
            if(curr.getData() %2!=0){
                sum+=curr.getData();
            }
            curr = curr.getNext();
        }
        return sum;
    }
    @Override
    public void printList(){
        Node last = head;
        if(last == null){ System.out.println("nothing in list");}
        // while(last!=null){
        //     System.out.print("->" + last.getData());
        //     last = last.getNext();
        // }
        for(Node n = head;n!=null;n = n.getNext()){
            System.out.print(n.getData() + "->");
        }
        System.out.println();
    }
}
