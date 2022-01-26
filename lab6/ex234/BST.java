package ex234;

public class BST {
    BTNode root;
    public BST(){
        root = null;
    }
    public BST(int key){
        root = new BTNode(key);
    }
    public BTNode insert(BTNode x,Integer key){
        if(x== null){
            return new BTNode(key);
        }
        int cmp = key.compareTo(x.key);
        if(cmp<0){
            x.left = insert(x.left,key);
        }
        else if(cmp>0){
            x.right=insert(x.right,key);
        }
        else{
            x.key=key;
        }
        return x;
    }
    public static void createTree(String str){
        String[] tach = str.split(" ");
        Integer[] k = new Integer[tach.length];
        for(int i=0; i<k.length; i++){
            k[i] = Integer.parseInt(tach[i]);
        }
        BST b = new BST(k[0]);
        for(int i=1; i<k.length; i++){
            b.insert(b.root,k[i]);
        }
        b.rightNodeLeft(b.root);
    }
    public void leftNodeRight(BTNode x){
        if(x!=null){
            leftNodeRight(x.left);
            System.out.print(x.key + " ");
            leftNodeRight(x.right);
        }
    }
    public void rightNodeLeft(BTNode x){
        if(x!=null){
            rightNodeLeft(x.right);
            System.out.print(x.key + " ");
            rightNodeLeft(x.left);
        }
    }
    public static void main(String[] args){
        String s = "7 36 3 1 6 4 15 40 23 25";
        System.out.println("String:"+s);
        createTree(s);
    }
}
