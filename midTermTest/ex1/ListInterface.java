package ex1;

public interface ListInterface {
    public Node getHead();
    public void addFirst(int data);
    public void addLast(int data);
    public boolean addAfterFirstKey(int data,int key);
    public int sumOdd();
    public void print();
}
