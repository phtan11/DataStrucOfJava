public class minHeap {
    private int[] heap;
    private int size;
    private int maxSize;
    public minHeap(int MaxSize){
        this.maxSize = MaxSize;
        this.size = 0;
        heap = new int[this.maxSize+1];
        heap[0] = Integer.MIN_VALUE;
    }
    public int parent(int i){
        return i/2;
    }
    public int leftChild(int i){
        return 2*i;
    }
    public int rightChild(int i){
        return (2*i)+1;
    }
    public boolean isLeaf(int i){
        if(i>(size/2) && i<=size){
            return true;
        }
        return false;
    }
    public void swap(int i, int j){
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
    //extract min
    public int extractMin(){
        int min = heap[1];
        heap[1] = heap[size];
        size -= 1;
        shiftDown(1);
        return min;
    }
    public void shiftDown(int i){
        if(!isLeaf(i)){
            if(heap[i]>heap[leftChild(i)] || heap[i] > heap[rightChild(i)]){
                if(heap[leftChild(i)] < heap[rightChild(i)]){
                    swap(i,leftChild(i));
                    shiftDown(leftChild(i));
                }
                else{
                    swap(i,rightChild(i));
                    shiftDown(rightChild(i));
                }
            }
        }
    }

    //insert
    public void insert(int el){
        heap[++size] = el;
        int current = size;
        while(heap[current]<heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }
    public void print(){
        for(int i=1;i<=size/2 ;i++){
            System.out.print("parent: " + heap[i] + " leftchild: " + heap[2*i] +" rightchild : " + heap[2*i + 1]);
            System.out.println();
        }
    }
    public static void main(String[] args){
        //int[] a = {5,3,17,10,84,19,6,22,9};
        int[] a = {15, 23, 18, 63, 21, 35, 36, 21, 66, 12, 42, 35, 75, 23, 64, 78, 39};
        minHeap hep = new minHeap(a.length);
        for(int i=0; i<a.length; i++){
            hep.insert(a[i]);
        }
        hep.print(); 
        System.out.println("the min of heap is:" + hep.extractMin());
        hep.print(); 

        //sort min den lon
        int[] min = new int[a.length];
        for (int i = 0; i < a.length; i++){
            min[i] = hep.extractMin();
        }
        System.out.print("Decending:");
        for(int s:min){
            System.out.print(" " + s);
        }
    }
}
