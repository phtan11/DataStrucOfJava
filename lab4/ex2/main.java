package lab4.ex2;

import java.util.Arrays;

public class main {
    public static void print(Student[] list){
        for(Student s1:list){
            System.out.println(s1);
        }
    }
    public static void main(String[] args) {
        Student[] listStu = new Student[5];
        listStu[0] = new Student("Tan",4.2,6.4,8.1);
        listStu[1] = new Student("hao",9.1,8.1,7.9);
        listStu[2] = new Student("Phu",9.5,4.2,5.6);
        listStu[3] = new Student("Minh",10,9.8,10);
        listStu[4] = new Student("Tamm",4.2,6.4,4.9);
        print(listStu);
        System.out.println();
        Arrays.sort(listStu,new StudentComparator());
        print(listStu);
        
    }
}
