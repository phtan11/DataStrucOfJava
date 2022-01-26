package labDataStrucAndAl.lab1.ex4;

public class DoubleNode {
    private double data;
    private DoubleNode next;
    public DoubleNode(double data) {
        this.setData(data);
        setNext(null);
    }
    public DoubleNode(double data,DoubleNode next){
        this.setData(data);
        this.setNext(next);
    }
    public double getData() {
        return data;
    }
    public void setData(double data) {
        this.data = data;
    }
    public DoubleNode getNext() {
        return next;
    }
    public void setNext(DoubleNode next) {
        this.next = next;
    }
    public String toString() {
        return "(" + this.data + ")";
    }
}
