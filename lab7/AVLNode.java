public class AVLNode{
    Integer key;
    AVLNode left,right;
    int height;
    public AVLNode(Integer key){
        this.key = key;
        this.left=this.right = null;
        this.height =0;
    }
    public AVLNode(){
        this.key = 0;
        this.left=this.right = null;
        this.height =0;
    }
}