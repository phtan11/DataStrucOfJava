public class maxHeap{
    private int[] heap;
    private int size; // heap size
    private int maxSize;
    public maxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize+1];
        heap[0] = Integer.MAX_VALUE ; // Integer.MAX_VALUE
    }
    private int parent(int  i){
        return i/2;
    }
    private int leftChild(int i){
        return 2*i;
    }
    private int rightChild(int i){
        return (2*i) + 1;
    }
    public void swap(int i, int j){
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
    public boolean isLeaf(int i){
        if(i>=(size/2) && i<=size){
            return true;
        }
        return false;
    }
    //insert C1
    // public void insert(int key){
    //     if(size == maxSize){
    //         System.out.println("do not insert");
    //     }
    //     size +=1;
    //     heap[size] = key;
    //     shiftUp(size);
    // }
    // public void shiftUp(int i){
    //     while(i > 1&&heap[parent(i)] < heap[i]){
    //         swap(parent(i),i);
    //         i=parent(i);
    //     }
    // }
    
    //insert C2
    public void insert(int el){
        heap[++size] = el;
        int current = size;
        while(heap[current]>heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    //xuat max
    public int extractMax(){
        if(size == 0){
            System.out.println("nothing to show");
        }
        int max = heap[1];
        heap[1] = heap[size];
        size -= 1;
        shiftDown(1);
        return max;
    }
    public void shiftDown(int i){
        while(i<=size){
            int max = heap[i];
            int maxID = i;
            if(leftChild(i) <= size  && max < heap[leftChild(i)]){
                max = heap[leftChild(i)];
                maxID = leftChild(i);
            }
            if(rightChild(i) <= size && max < heap[rightChild(i)]){
                max = heap[rightChild(i)];
                maxID = rightChild(i);
            }
            if(maxID != i){
                swap(maxID,i);
                i = maxID;
            }
            else{
                break;
            }
        }
    }
    //heap sorted by
    // public static void heapSort(int[] a){

    // }
    //print
    public void print(){
        for(int i=1;i<=size/2 ;i++){
            System.out.print("parent: " + heap[i] + " leftchild: " + heap[2*i] +" rightchild : " + heap[2*i + 1]);
            System.out.println();
        }
    }
    public static void main(String[] args){
        //int[] a = {2,4,8,6,1,78,63,14,45};
        int[] a = {15, 23, 18, 63, 21, 35, 36, 21, 66, 12, 42, 35, 75, 23, 64, 78, 39};
        maxHeap hep = new maxHeap(a.length);
        for(int i=0; i<a.length; i++){
            hep.insert(a[i]);
        }
        
        hep.print();
        System.out.println("the max value is: "+hep.extractMax());
        hep.print();
        
        int[] arrAscending = new int[a.length];
        for(int i=0; i<a.length; i++){
            arrAscending[i] = hep.extractMax();
        }
        System.out.print("ascending:");
        for(int s:arrAscending){
            System.out.print(" " + s);
        }
    }
}