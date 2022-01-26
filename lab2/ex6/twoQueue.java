package lab2.ex6;

public class twoQueue<E> implements queueInterface<E> {
    private myStack<E> in; 
    private myStack<E> out;
    private int num; 
    public twoQueue(){
        this.in = new myStack<E>();
        this.out = new myStack<E>();
        this.num = 0;
    }
    @Override
    public void enQueue(E item) {
        in.push(item);
        num++;
    }

    @Override
    public E deQueue() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        E tmp = null;
        if (!out.isEmpty()) {
            tmp = out.pop();
            num--;
        }
        return tmp;
    }

    @Override
    public int size() {
        return num;
    }

    @Override
    public boolean contains(E item) {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.contains(item);
    }

    @Override
    public void print() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        out.print();
    }

    @Override
    public boolean isEmpty() {
        return num == 0;
    }

    @Override
    public E getFront() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.getPeek();
    }
}
