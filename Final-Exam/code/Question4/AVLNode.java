public class AVLNode {
    private Student student;
    private AVLNode left,right;
    private int height;
    public AVLNode(Student student) {
        this.student = student;
        this.left = this.right = null;
        this.height = 0;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public AVLNode getRight() {
        return right;
    }
    public void setRight(AVLNode right) {
        this.right = right;
    }
    public AVLNode getLeft() {
        return left;
    }
    public void setLeft(AVLNode left) {
        this.left = left;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
