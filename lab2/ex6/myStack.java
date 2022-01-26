package lab2.ex6;

import java.util.ArrayList;

public class myStack <E> implements listInterface <E> {
    private Nodee<E> top;
    private int numNode;
    public myStack(){
        top = null;
        numNode = 0;
    }
    @Override
    public void push(E item) {
        top = new Nodee<E>(item, top);
        numNode++;
    }

    @Override
    public E pop() {
        E result = null;
        if (isEmpty()) {
            System.out.print("Stack is empty");
            return result;
        } else {
            result = top.getElement();
            this.top = top.getNext();
            numNode--;
        }
        return result;
    }

    @Override
    public int size() {

        return numNode;
    }

    @Override
    public boolean contains(E item) {
        Nodee<E> tmp = top;
        while (tmp != null) {
            if (tmp.getElement() == item) {
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }

    @Override
    public void print() {
        if (isEmpty()) {
            return;
        } else {
            Nodee<E> tmp = top;
            ArrayList<E> myStack = new ArrayList<>();
            while (tmp != null) {
                myStack.add(tmp.getElement());
                tmp = tmp.getNext();
            }
            System.out.print(myStack.get(numNode - 1));
            for (int i = myStack.size() - 2; i >= 0; i--) {
                System.out.print("->" + myStack.get(i));
            }

        }
    }

    @Override
    public boolean isEmpty() {

        return numNode == 0;
    }

    @Override
    public E getPeek() {
        return top.getElement();
    }

}