public class studentLinkedList {
    private ListNode head;
    public studentLinkedList(){
        head =null;
    }
    public void addFirst(Student s){
        ListNode ne = new ListNode(s);
        ne.setNext(head);
        head = ne;
    }
    public void addStudent(Student studentKey,Student student){
        if(head == null){
            ListNode neww = new ListNode(student);
        }
        else{
            ListNode curr = head;
            while(curr != null){
                if(curr.getStudent() == studentKey){
                    ListNode neww = new ListNode(student,curr.getNext());
                    curr.setNext(neww);
                }
                curr =curr.getNext();
            }
        }
    }
    public void removeStudent(Student student){
        if(head == null){
            System.out.println("Nothing to removeStudent");
        }
        ListNode pre =null;
        ListNode curr =head;
        while(curr != null){
            if(curr.getStudent() == student){
                pre.setNext(curr.getNext());
                curr.setNext(null);
            }
            pre = curr;
            curr = curr.getNext();
        }
    }
    public boolean searchStudent(Student student){
        if(head == null){
            System.out.println("nothing to search!!");
        }
        else{
            ListNode curr = head;
            while(curr != null){
                if(curr.getStudent().equals(student)){
                    return true;
                }
                curr = curr.getNext();
            }
        }
        return false;
    }   
    public void print(){
        if(head == null){
            System.out.println("nothing to show");
        }
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.getStudent() +" -> ");
            curr = curr.getNext();
        }
        System.out.print("null");
    }
}
