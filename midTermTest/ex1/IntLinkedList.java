package ex1;

public class IntLinkedList implements ListInterface {
    private Node head;
    public IntLinkedList(){
        head=null;
    }
    @Override
    public Node getHead(){
        if(head == null){
            return null;
        }
        return head;
    }
    @Override
    public void addFirst(int data){
        Node n= new Node(data,head);
        head = n;
    }
    @Override
    public void addLast(int data){
        if(head == null){
            Node n = new Node(data,null);
            head = n;
        }
        else{
            Node last = head;
            while(last.getNext() != null){
                last = last.getNext();
            }
            Node n =new Node(data,last.getNext());
            last.setNext(n);
        }
    }
    @Override
    public boolean addAfterFirstKey(int data,int key){
       boolean check= false;
        Node last = head;
        while(last != null){
            if(last.getData() == key){
                check = true;
                break;
            }
            last = last.getNext();
        }
        last=head;
        if(check==false){
            System.out.println("false");
            return false;
        }
        else{
            while(last !=null){
                if(last.getData() == key){
                    Node n = new Node(data,last.getNext());
                    last.setNext(n);
                }
                last = last.getNext();
            }
        }
        return true;
    }
    @Override
    public int sumOdd(){
        int sum=0;
        Node cur  =head;
        while(cur !=null){
            if(cur.getData()%2!=0){
                sum+=cur.getData();
            }
            cur = cur.getNext();
        }
        return sum;
    }
    @Override
    public void print(){
        Node last = head;
        if(head == null) System.out.println("nothing to show you");
        else{
            while(last != null){
                System.out.print(last.getData() +"->");
                last = last.getNext();
            }
            System.out.println();
        }
    }
}
