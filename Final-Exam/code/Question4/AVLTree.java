public class AVLTree {
    private AVLNode root;

    public AVLTree() {
        this.setRoot(null);
    }

    public AVLNode getRoot() {
        return root;
    }

    public void setRoot(AVLNode root) {
        this.root = root;
    }
    public int height(AVLNode node){
        if(node == null) return 0;
        return node.getHeight();
    }
    public int checkBalance(AVLNode node){
        return height(node.getLeft()) - height(node.getRight());
    }
    private AVLNode insert(AVLNode node,Student student){
        if(node == null) return new AVLNode(student);
        if(Integer.parseInt(student.getStudentID()) < Integer.parseInt(node.getStudent().getStudentID())){
            node.setLeft(insert(node.getLeft(), student));
        }
        else if(Integer.parseInt(student.getStudentID()) > Integer.parseInt(node.getStudent().getStudentID())){
            node.setRight(insert(node.getRight(), student));
        }
        else{
            return node;
        }
        node.setHeight(1+getMax(height(node.getLeft()),height(node.getRight())));
        int balance = checkBalance(node);
        if(balance > 1 && Integer.parseInt(student.getStudentID()) < Integer.parseInt(node.getLeft().getStudent().getStudentID())){
            return rotateWithRight(node);
        }
        if(balance > 1 && Integer.parseInt(student.getStudentID()) > Integer.parseInt(node.getLeft().getStudent().getStudentID())){
            node.setLeft(rotateWithLeft(node.getLeft()));
            return rotateWithRight(node);
        }
        if(balance < -1 && Integer.parseInt(student.getStudentID()) < Integer.parseInt(node.getLeft().getStudent().getStudentID())){
            node.setRight(rotateWithRight(node.getRight()));
            return rotateWithLeft(node);
        }
        if(balance < -1 && Integer.parseInt(student.getStudentID()) > Integer.parseInt(node.getLeft().getStudent().getStudentID())){
            return rotateWithLeft(node);
        }
        return node;
    }
    public void insert(Student student){
        this.root = insert(this.root,student);
    }
    public int getMax(int x,int y){
        return x>y?x:y;
    }
    public AVLNode rotateWithLeft(AVLNode y){
        AVLNode x= y.getRight();
        y.setRight(x.getLeft());
        x.setLeft(y);
        y.setHeight(1+getMax(height(y.getLeft()),height(y.getRight())));
        x.setHeight(1+getMax(height(x.getLeft()),height(x.getRight())));
        return x;
    }
    public AVLNode rotateWithRight(AVLNode x){
        AVLNode y = x.getLeft();
        x.setLeft(y.getRight());
        y.setRight(x);
        x.setHeight(1+getMax(height(x.getLeft()),height(x.getRight())));
        y.setHeight(1+getMax(height(y.getLeft()),height(y.getRight())));
        return y;
    }
    private AVLNode removeStudent(AVLNode node,Student s){
        if(node == null) return node;
        if(Integer.parseInt(node.getStudent().getStudentID()) > Integer.parseInt(s.getStudentID())){
            node.setLeft(removeStudent(node.getLeft(),s));
        }
        else if(Integer.parseInt(node.getStudent().getStudentID()) < Integer.parseInt(s.getStudentID())){
            node.setRight(removeStudent(node.getRight(),s));
        }
        else{
            if(node.getLeft() == null || node.getRight() == null){
                AVLNode tmp = null;
                if(tmp == node.getRight()){
                    tmp = node.getLeft();
                }
                else{
                    tmp = node.getRight();
                }
                if(tmp == null){
                    tmp = node;
                    node = null;
                }
                else{
                    node = tmp;
                }
            }
            else{
                AVLNode tmp = getMin(node.getRight());
                node.getStudent().setStudentID(tmp.getStudent().getStudentID()); 
                node.setRight(removeStudent(node.getRight(),tmp.getStudent()));
            }
        }
        if(node == null) return node;
        node.setHeight(1+getMax(height(node.getLeft()),height(node.getRight())));
        int balance = checkBalance(node);
        if(balance > 1 && checkBalance(node.getLeft()) >= 0){
            return rotateWithRight(node);
        }
        if(balance > 1 && checkBalance(node.getLeft()) < 0){
            node.setLeft(rotateWithLeft(node.getLeft()));
            return rotateWithRight(node);
        }
        if(balance < -1 &&  checkBalance(node.getRight()) > 0){
            node.setRight(rotateWithRight(node.getRight()));
            return rotateWithLeft(node);
        }
        if(balance < -1 && checkBalance(node.getRight()) <= 0){
            return rotateWithLeft(node);
        }
        return node;
    }
    public AVLNode getMin(AVLNode node){
        AVLNode current = node;
        if(current.getLeft() != null){
            current = current.getLeft();
        }
        return current;
    }
    public AVLNode searchStudent(AVLNode node,String studentID){
        if(node == null){
            return null;
        }
        if(Integer.parseInt(node.getStudent().getStudentID()) == Integer.parseInt(studentID)){
            return node;
        }
        else if(Integer.parseInt(node.getStudent().getStudentID()) > Integer.parseInt(studentID)){
            return searchStudent(node.getLeft(),studentID);
        }
        else{
            return searchStudent(node.getRight(),studentID);
        }
    }
    public void NodeLeftRight(AVLNode node){
        if(node!= null){
            System.out.print(node.getStudent().toString() + " ");
            NodeLeftRight(node.getLeft());
            NodeLeftRight(node.getRight());
        }
    }
    public static void main(String[] args){
        AVLTree b = new AVLTree();
        Student s1 = new Student("21730451","Pham Phuoc Tan",7.8,"20H50204","M");
        Student s2 = new Student("21730447","Duong Quoc Thai",4.5,"DH21YKH03","M");
        Student s3 =new Student("21730433","Tran Van Vu",9.3,"20H40302","M");
        Student  s4 =new Student("21730416","Vo Anh Ngoc",8.1,"20HE0104","F");
        Student  s5 = new Student("21730434","Tran Ngoc Lam",4.7,"21H01204","F");
        Student  s6 =new Student("21730439","Duong Hoang Khang",7.1,"20H50201","M");
        Student s7 =new Student("21730450","Thai Ngoc Long",3.5,"20H10202","M");
        Student s8 = new Student("21730430","Tran Minh Tien",6.5,"18H50102","M");
        Student s9 =new Student("21730444","Nguyen Thi Xuan Nhi",3.5,"20H30204","F");
        Student s10 = new Student("21730422","Nguyen Ngan Ly",8.6,"18030101","F");
        Student s11 = new Student("21730441","Huynh Nhat Hao",9,"20H50203","M");
        Student s12=new Student("21730408","Tran Thi My Huyen",4,"20H70104","F");
        Student s13=new Student("21730406","Nguyen My Huyen",5.7,"21H70401","F");
        Student s14 =new Student("21730418","Bien Ngoc Kim Ngan",6.7,"18H60201","F");
        Student s15 =new Student("21730428","Nguyen Anh Phu",4.3,"20H50101","M");
        b.root = b.insert(b.root, s1);
        b.root = b.insert(b.root, s2);
        b.root = b.insert(b.root, s3);
        b.root = b.insert(b.root, s4);
        b.root = b.insert(b.root, s5);
        b.root = b.insert(b.root, s6);
        b.root = b.insert(b.root, s7);
        b.root = b.insert(b.root, s8);
        b.root = b.insert(b.root, s9);
        b.root = b.insert(b.root, s10);
        b.root = b.insert(b.root, s11);
        b.root = b.insert(b.root, s12);
        b.root = b.insert(b.root, s13);
        b.root = b.insert(b.root, s14);
        b.root = b.insert(b.root, s15);
        System.out.println("---List student:");
        b.NodeLeftRight(b.root);
        
        System.out.println();
        System.out.println();

        System.out.println("---After remove a student:");
        b.root = b.removeStudent(b.root,s1); // delete Pham Phuoc Tan
        b.NodeLeftRight(b.root);
        
        System.out.println();
        System.out.println();

        AVLNode a = b.searchStudent(b.root,"21730451"); // studentID is Tran Thi My Huyen
        if(a != null)
            System.out.println("---Search remove a student:" + a.getStudent());
        else
            System.out.println("---Search remove a student: Node isn't here!!");
    }
}
