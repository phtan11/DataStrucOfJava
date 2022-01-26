public class ListNode{
    private Student student;
    private ListNode next;
    public ListNode(Student student, ListNode next) {
        this.setStudent(student);
        this.setNext(next);
    }
    public ListNode(Student student){
        this.setStudent(student);
        this.setNext(null);
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public ListNode getNext() {
        return next;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }  
}
