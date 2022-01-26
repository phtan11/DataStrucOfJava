public class IntLinkedList implements ListInterface {
    private Node head;
    public IntLinkedList(){
        this.head = null;
    }
    @Override
    public Node getHead() {
        if(head == null) return null;
        return head;
    }

    @Override
    public void addFirst(int data) {
        Node n = new Node(data,head);
        head = n;
    }

    @Override
    public int countElementSmallerThanKey(int key) {
        int count=0;
        if(head == null) return 0;
        else{
            Node curr = head;
            while(curr != null){
                if(curr.getData() < key){
                    count++;
                }
                curr = curr.getNext();
            }
        }
        return count;
    }
}
