package ex5678910;

public class BST {
    BTNode root;
    public BST(){
        root = null;
    }
    public BST(int key){
        root = new BTNode(key);
    }
    //them tree
    public BTNode insert(BTNode x, Integer key){
        if(x == null){
            return new BTNode(key);
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = insert(x.left,key);
        }
        else if(cmp > 0){
            x.right = insert(x.right,key);
        }
        else{
            x.key = key;
        }
        return x;
    }
    //duyet tree
    public void NodeLeftRight(BTNode x){
        if(x!=null){
            System.out.print(x.key + " ");
            NodeLeftRight(x.left);
            NodeLeftRight(x.right);
        }
    }
    public boolean contains(BTNode x,Integer key) {
        if(x==null){
            return false;
        }
        int cmp = key.compareTo(x.key);
        if(cmp<0){
            return contains(x.left,key);
        }
        else if(cmp > 0){
            return contains(x.right,key);
        }
        else{
            return true;
        }
    }
    public BTNode deleteMax(BTNode x) {
        if(x.right == null){
            return x.left;
        }
        x.right = deleteMax(x.right);
        return x;
    }
    private BTNode delMin(BTNode x){
        if(x.left==null){
            return x.right;
        }
        x.left = delMin(x.left);
        return x;
    }
    private BTNode minn(BTNode x){
        if(x==null){
            return x;
        }
        else{
             return minn(x.left);
        }
    }
    public BTNode delete_pre(BTNode x,Integer key) {
        if(x==null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp<0){
            x.left = delete_pre(x.left,key);
        }
        else if(cmp > 0){
            x.right = delete_pre(x.right,key);
        }
        else{
            if(x.left==null)
                return x.right;
            if(x.right ==null) return x.left;
            BTNode t = x;
            x=minn(t.right); //C1:tìm phần tử bé nhất bên nhánh trái để đem lên làm nút cha cho đảm bảo tính cân bằng
            //C2:hoặc tìm phần tử lớn nhất của nhánh phải rùi đem lên làm cha xog xoa nó đi
            // phai code method tim min
            x.right = delMin(t.right); // sau khi đem lên làm nút cha thì xóa nút đó ở nhánh trái
            // code method xoa min
            x.left = t.left;
        }
        return x;
    }
    private static int height(BTNode x) {
        if(x==null){
            return 0;
        }
        int a =1+ height(x.left);
        int b = 1+height(x.right);
        int max=a>b?a:b;
        return max;
    }
    // public static  Integer sum(BTNode x) {
    //     if(x==null) return 0;
    //     return (x.key + sum(x.left) + sum(x.right));
    // }
    public Integer sum(BTNode x) {
        if(x==null) return 0;
        return (x.key + sum(x.left) + sum(x.right));
    }
    public Integer sum() {
        return sum(root);
    }
    public static void main(String[] arg){
        Integer[] k = {7,2,9,10,45,36,47,14};
        BST b = new BST(k[0]);
        for(int i = 1;i<k.length;++i)
            b.insert(b.root,k[i]);
        b.NodeLeftRight(b.root);
        System.out.println();
        System.out.println("height:" + height(b.root));
        int sumNode = b.sum(b.root);
        System.out.println("sum:" + sumNode);
    }
}