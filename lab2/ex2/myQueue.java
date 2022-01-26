package lab2.ex2;

public class myQueue<E> implements queueInterface<E> {
    private Node<E> front;
    private Node<E> tail;
    private int numNode;
    public myQueue(){
        this.front = null;
        this.tail = null;
        this.numNode = 0;
    }
    @Override
    public void enQueue(E item) { // push
        if(front == null){
            tail = new Node<E>(item);
            front = tail;
        }
        else{
            Node<E> newNode = new Node<E>(item);
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        numNode++;
    }

    @Override
    public E deQueue() { // nhu pop la xoa cai top
        E result = null;
        if(isEmpty()) {
            System.out.println("queue is empty"); 
            return result;
        }
        result = front.getElement();
        front = front.getNext();
        numNode--;
        return result;
    }

    @Override
    public int size() {
        return numNode;
    }

    @Override
    public boolean contains(E item) {
        Node<E> last = front;
        for(int i = 1; i < numNode; i++) {
            if(last.getElement().equals(item)) return true;
            last = last.getNext();
        }
        return false;
    }

    @Override
    public void print() {
        if (front == null) {
            System.out.println("nothing to print");
        } else {
            Node<E> tmp = front;
            System.out.print("list is:" + tmp.getElement());
            for(int i =1;i<numNode ;i++) {
                tmp = tmp.getNext();
                System.out.print("->" + tmp.getElement());
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return numNode == 0;
    }

    @Override
    public E getFront() {
        return front.getElement();
    }
}
