package LinkedList;

public class Test1 {
    public static void main(String[] args) {
        intLinkedList list = new intLinkedList();
        list.addFirst(4);
        list.addFirst(8);
        list.addFirst(3);
        list.addFirst(6);
        list.addFirst(2);
        list.addLast(5);
        list.removeAt(8);
        list.addFirst(1);
        System.out.println(list.sumOdd());
        list.printList();
        System.out.println("count odd: " + list.countOdd());
        int ch = list.searchKey(9);
        if(ch==1){
            System.out.println("it has in list");
        }
        else{
            System.out.println("it doesn't has in list");
        }
        boolean chekc = list.checkSorted();
        if(chekc){
            System.out.println("sorted");
        }
        else{
            System.out.println("not sorted");
        }
    }
}
