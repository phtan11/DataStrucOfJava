package lab2.ex1;

public interface stackInterface <E> {
    public void push(E item);
    public E pop();
    public int size();
    public boolean contains(E item);
    public void print();
    public boolean empty();
    public E getPeek();
}