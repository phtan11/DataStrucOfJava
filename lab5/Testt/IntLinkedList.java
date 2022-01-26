package Testt;

public class IntLinkedList implements ListInterface {
    private Node head;
    public IntLinkedList(){
        head = null;
    }
    @Override
    public Node getHead() {
        if(head == null){
            System.out.println("nothing to show");
        }
        return head;
    }
    @Override
    public void addFirst(int data) {
        Node naa = new Node(data,head);
        head=naa;
        
    }
    @Override
    public boolean addAfterFirstKey(int data, int key) {
        boolean check =false;
        Node curr = head;
        while(curr != null){
            if(curr.getData() == key){
                check=true;
                break;
            }
            curr = curr.getNext();
        }
        curr =head;
        if(check){
            while(curr!=null){
                if(curr.getData() == key){
                    Node n = new Node(data,curr.getNext());
                    curr.setNext(n);
                }
                curr = curr.getNext();
            }
            return true;
        }
        else return false;
    }    
    public void printla(){
        Node n = head;
        while(n != null){
            System.out.print(n.getData()+"->");
            n = n.getNext();
        }
    }
}
