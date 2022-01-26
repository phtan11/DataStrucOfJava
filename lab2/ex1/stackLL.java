package lab2.ex1;

public class stackLL<E> implements stackInterface<E>{
    private myStack<E> list;
    public stackLL() {
        list = new myStack<E>();
    }
    public boolean empty() {
        return list.isEmpty();
    }
    @Override
    public void push(E item) { // them ptu vaos
        list.addFirst(item);        
    }
    @Override
    public E getPeek() {
        return list.getFirst();
    }
    @Override
    public E pop() { // xoa ptu
        E obj = getPeek();
        list.removeFirst();
        return obj;
    }
    @Override
    public int size() {
        return list.size();
    }
    @Override
    public boolean contains(E item) {
        return list.contains(item);
    }
    @Override
    public void print() {
        list.print();
    }   
}
