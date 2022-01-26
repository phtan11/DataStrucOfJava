package lab2.ex4;

public interface listInterface <E> {
    public void push(E item);

    public E pop();

    public int size();

    public boolean contains(E item);

    public void print();

    public boolean isEmpty();

    public E getPeek();
}
