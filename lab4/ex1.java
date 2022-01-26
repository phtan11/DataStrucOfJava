package lab4;

import java.util.Arrays;

public class ex1{
    public static void selectionn1(int a[],int n){
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
    public static void selectionn2(int a[],int n){
        int max=0;
        for(int i=0;i<n-1;i++){
            max = i;
            for(int j = i+1;j<n;j++){
                if(a[max] < a[j]){
                    max = j;
                }
            }
            int tem = a[max];
            a[max] = a[i];
            a[i] = tem;
        }
    }
    public static void bubbleSort1(int a[],int n){
        for(int i =0;i<n-1;i++){
            for(int j = a.length-1;j>0;j--){
                if(a[j] < a[j-1]){
                    int tmp  = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                }
            }
        }
    }
    public static void bubbleSort2(int a[],int n){
        for(int i =0;i<n-1;i++){
            for(int j = a.length-1;j>0;j--){
                if(a[j] > a[j-1]){
                    int tmp  = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                }
            }
        }
    }
    public static void insertionSort1(int a[],int n){
        for(int i = 1;i<n;i++){
            int key = a[i];
            int j;
            for(j=i-1;j>=0 && a[j] > key;j--){
                a[j+1] = a[j];
            }
            a[j+1] = key;
        }
    }
    public static void insertionSort2(int a[],int n){
        for(int i = 1;i<n;i++){
            int key = a[i];
            int j;
            for(j=i-1;j>=0 && a[j] < key;j--){
                a[j+1] = a[j];
            }
            a[j+1] = key;
        }
    }
    //quick sort
    public static int prition(int a[],int low,int high) {
        int p = a[high];
        int i = low -1;
        for(int j = low;j<high;j++){
            if(a[j] >= p){
                i++;
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }
        int tmp = a[i+1];
        a[i+1] = a[high];
        a[high] = tmp;
        return i+1;
    }
    public static void quickSort(int[] a,int low,int high){
        if(low<high){
            int pi=prition(a,low,high);
            quickSort(a,low,pi-1);
            quickSort(a,pi+1,high);
        }

    } 
    //merge sort
    public static void merge(int a[],int low,int mid,int high){
        int n1 = mid-low+1;
        int n2 = high-mid;
        int L[] = new int [n1];
        int R[] = new int [n2];
        for(int i=0;i<n1;i++){
            L[i] = a[low+i];
        }
        for(int j=0;j<n2;j++){
            R[j] = a[mid+j+1];
        }
        int i=0,j=0,k=low;
        while(i<n1 && j<n2){
            if(L[i] >= R[j]){
                a[k] = L[i];
                i++;
            }
            else{
                a[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            a[k++] = L[i++];
        }
        while(j<n2){
            a[k++] = R[j++];
        }
    }
    public static void mergeSort(int []a,int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }
    public static void main(String[] args){
        int [] a= {2,9,7,6,10};
        // selectionn1(a,a.length);
        // System.out.println(Arrays.toString(a));
        // selectionn2(a,a.length);
        // bubbleSort1(a,a.length);
        // System.out.println(Arrays.toString(a));
        // bubbleSort2(a,a.length);
        // insertionSort1(a,a.length);
        // System.out.println(Arrays.toString(a));
        // insertionSort2(a,a.length);
        //quickSort(a,0,a.length-1);
        // mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}