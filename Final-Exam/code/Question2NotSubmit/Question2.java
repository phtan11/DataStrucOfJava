import java.util.Arrays;

public class Question2{
    public static void selectionSort(int a[],int n){
        int min=0;
        for(int i=0;i<n-1;i++){
            min = i;
            for(int j = i+1;j<n;j++){
                if(a[min] > a[j]){
                    min = j;
                }
            }
            int tem = a[min];
            a[min] = a[i];
            a[i] = tem;
        }
    }
    public static void bubbleSort(int a[],int n){
        for(int i =0;i<n-1;i++){
            for(int j =0;j<n-1-i;j++){
                if(a[j] > a[j+1]){
                    int tmp  = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args){
        int [] a= {13,17,15,4,2,9,7,6,10,1};
        int [] b= {13,17,15,4,2,9,7,6,10,1};
        selectionSort(a,a.length);
        System.out.println(Arrays.toString(a));
        bubbleSort(b,b.length);
        System.out.println(Arrays.toString(b));
    }
}