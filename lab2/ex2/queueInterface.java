package lab2.ex2;

public interface queueInterface <E> {
    public void enQueue(E item);
    public E deQueue();
    public int size();
    public boolean contains(E item);
    public void print();
    public boolean isEmpty();
    public E getFront();
}
