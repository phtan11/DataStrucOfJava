import java.io.*;
import java.util.Scanner;
public class test{
    public static void main(String[] args) throws Exception{
        //C1
        FileReader f = new FileReader("2DInput1.txt");
        BufferedReader br = new BufferedReader(f);
        Scanner sc = new Scanner(br);
            //C2
            //Scanner sc = new Scanner(new BufferedReader(new FileReader("2Dinput1.txt")));
        int  n = sc.nextInt();
        int [][] a= new int[n][n];
        sc.nextLine();
        while(sc.hasNextLine()){
            for(int i = 0; i < a.length; i++){
                String[] row = sc.nextLine().trim().split(" ");
                for ( int j = 0; j < row.length; j++){
                    a[i][j] = Integer.parseInt(row[j]);
                }
            }
        }
        //in ra man hinh
        System.out.println(n);
        for(int i = 0; i <n;i++){
            for(int j = 0; j <n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}