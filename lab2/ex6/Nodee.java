package lab2.ex6;

public class Nodee <E> {
    private E element;
    private Nodee<E> next;
    public Nodee(E element){
        this(element,null);
    }
    public Nodee(E element,Nodee <E> next) {
        this.element = element;
        this.next = next;
    }
    public E getElement() {
        return element;
    }
    public Nodee <E> getNext() {
        return next;
    }
    public void setNext(Nodee<E> next) {
        this.next = next;
    }
}
