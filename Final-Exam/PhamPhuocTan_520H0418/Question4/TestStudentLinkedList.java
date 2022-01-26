public class TestStudentLinkedList {
    public static void main(String[] args){
        studentLinkedList studentList = new studentLinkedList();
        Student s1 = new Student("520H0418","Pham Phuoc Tan",7.8,"20H50204","M");
        Student s2 = new Student("212260HE","Duong Quoc Thai",4.5,"DH21YKH03","M");
        Student s3 =new Student("420H0291","Tran Van Vu",9.3,"20H40302","M");
        Student  s4 =new Student("E20H0095","Vo Anh Ngoc",8.1,"20HE0104","F");
        Student  s5 = new Student("02105234","Tran Ngoc Lam",4.7,"21H01204","F");
        Student  s6 =new Student("520H0006","Duong Hoang Khang",7.1,"20H50201","M");
        Student s7 =new Student("120H0113","Thai Ngoc Long",3.5,"20H10202","M");
        Student s8 = new Student("518H0145","Tran Minh Tien",6.5,"18H50102","M");
        Student s9 =new Student("321H0466","Nguyen Thi Xuan Nhi",3.5,"20H30204","F");
        Student s10 = new Student("31800444","Nguyen Ngan Ly",8.6,"18030101","F");
        Student s11 = new Student("520H0531","Huynh Nhat Hao",9,"20H50203","M");
        Student s12=new Student("720H0478","Tran Thi My Huyen",4,"20H70104","F");
        Student s13=new Student("721H0314","Nguyen My Huyen",5.7,"21H70401","F");
        Student s14 =new Student("618H0784","Bien Ngoc Kim Ngan",6.7,"18H60201","F");
        Student s15 =new Student("520H0001","Nguyen Anh Phu",4.3,"20H50101","M");
        studentList.addFirst(s1);
        studentList.addFirst(s2);
        studentList.addFirst(s3);
        studentList.addFirst(s4);
        studentList.addFirst(s5);
        studentList.addFirst(s6);
        studentList.addFirst(s7);
        studentList.addFirst(s8);
        studentList.addFirst(s9);
        studentList.addFirst(s10);
        studentList.addFirst(s11);
        studentList.addFirst(s12);
        studentList.addFirst(s13);
        studentList.addFirst(s14);
        studentList.addFirst(s15);
        System.out.println("----List Student: ");
        studentList.print();

        System.out.println();
        System.out.println();

        System.out.println("---After add a new student:");
        Student newStudent = new Student("418H0978","Tran Tan Tai",7.9,"18H40103","M");
        studentList.addStudent(s11,newStudent);
        studentList.print();

        System.out.println();
        System.out.println();

        System.out.println("----After remove a student:");
        studentList.removeStudent(s14);  // Bien Ngoc Kim Ngan
        studentList.print();

        System.out.println();
        System.out.println();
        
        // Student searchStudent = new Student("520H0537","Tran Thi Hop",8.4,"20H50203","F");
        Student searchStudent = s1; // Pham phuoc Tan
        System.out.print("----Search a student: " + studentList.searchStudent(searchStudent));
    }
}
