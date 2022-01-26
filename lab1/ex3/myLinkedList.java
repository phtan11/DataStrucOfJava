package labDataStrucAndAl.lab1.ex3;
public class myLinkedList implements ListInterface {
    private Node  head;
    private int numNode;
    public myLinkedList(){
        head = null;
        numNode = 0;
    }
    @Override
    public void addFirst(int item){
        head=new Node(item,head);
        numNode++;
    }
    @Override
    public void printt(){
        Node  last = head;
        while(last != null){
            System.out.print(last.getData() +"->");
            last = last.getNext();
        }
        System.out.print("null");
    }
    public boolean checkEven(int data){
        return (data %2==0);
    }
    @Override
    public int countEven(){
        int count = 0;
        Node  last = head;
        while(last != null){
            if(checkEven(last.getData())){
                count++;
            }
            last = last.getNext();
        }
        return count;
    }
    public boolean checkPrime(int data){
        if(data<2) return false;
        else{
            for(int i =2;i<=Math.sqrt(data);i++){
                if(data % i ==0){
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public int countPrime(){
        int count = 0;
        Node  last = head;
        while(last != null){
            if(checkPrime(last.getData())){
                count++;
            }
            last = last.getNext();
        }
        return count;
    }
    public Node firstEven(){
        Node  last = head;
        while(last != null){
            if(last.getData() %2 == 0){
                break;
            }
            last = last.getNext();
        }
        return last;
    }
    @Override
    public void addBeforeFirstEven(int item){
        Node z =new Node(item);
        Node firstEv = firstEven();
        Node last = head;
        Node pre = null;
        while(last != null){
            if(last.getData() == firstEv.getData()){
                z.setNext(last.getNext());
                pre.setNext(z);
                numNode++;
            }
            pre = last;
            last = last.getNext();
        }   
    }
    @Override
    public int MaxList(){
        int max=head.getData();
        Node last =head;
        while(last != null){
            if(max < last.getData()){
                max = last.getData();
            }
            last = last.getNext();
        }
        return max;
    }
    public void reverseList(){
        Node next =null;
        Node last =head;
        Node pre = null;
        while(last !=null){
            next = last.getNext();
            last.setNext(pre);
            pre = last;
            last = next;
        }
        head =pre;
    }
    @Override
    public void sortList(){
        Node tmp = head;
        Node next = null;
        int s;
        while (tmp != null) {
            next = tmp.getNext();
            while (next != null) {
                if (tmp.getData() > next.getData()) {
                    s = tmp.getData();
                    tmp.setData(next.getData());
                    next.setData(s);
                }
                next = next.getNext();
            }
            tmp = tmp.getNext();
        }
    }
    
}
