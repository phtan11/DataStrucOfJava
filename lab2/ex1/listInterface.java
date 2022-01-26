package lab2.ex1;

public interface listInterface <E> {
    public boolean isEmpty();
	public int     size();
    public E       getFirst(); 
    public boolean contains(E item);
	public void    addFirst(E item);
    public E       removeFirst();  
	public void    print();
}
