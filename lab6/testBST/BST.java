package testBST;

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
    public static int getHigh(BTNode x){
        if(x==null) return 0;
        int a = 1+getHigh(x.left);
        int b = 1+getHigh(x.right);
        int max = a>b?a:b;
        return max;
    }

    //duyet tree
    public void NodeLeftRight(BTNode x){
        if(x!=null){
            System.out.print(x.key + " ");
            NodeLeftRight(x.left);
            NodeLeftRight(x.right);
        }
    }
    public void leftNodeRight(BTNode x){
        while(x!=null){
            leftNodeRight(x.left);
            System.out.print(x.key + " ");
            leftNodeRight(x.right);
        }
    }
    public void leftRightNode(BTNode x){
        while(x!=null){
            leftNodeRight(x.left);
            leftNodeRight(x.right);
            System.out.print(x.key + " ");
        }
    }
    public void NOdeRightLeft(BTNode x){
        while(x!=null){
            System.out.print(x.key + " ");
            leftNodeRight(x.right);
            leftNodeRight(x.left);
        }   
    }
    public void rightNodeLeft(BTNode x){
        while(x != null){
            leftNodeRight(x.right);
            System.out.print(x.key + " ");
            leftNodeRight(x.left);
        }   
    }
    public void rightLeftNode(BTNode x){
        while(x!=null){
            leftNodeRight(x.right);
            leftNodeRight(x.left);
            System.out.print(x.key + " ");
        }   
    }

    // dem tree 
        //c1
    public static int iCountNode(BTNode x){
        if(x==null){
            return 0;
        }
        else{
            return iCountNode(x.left)+iCountNode(x.right)+1;
        }
    }
        //c2
    public Integer countNode(BTNode x){
        if(x==null){
            return 0;
        }
        else{
            return countNode(x.left)+countNode(x.right)+1;
        }
    }
    public Integer countNode(){
        return countNode(root);
    }

    //search tree(search a key)
    private BTNode search(BTNode x,Integer key){
        if(x==null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp< 0){
            return search(x.left,key);
        }
        else if(cmp>0){
            return search(x.right,key);
        }
        else return x;
    }

    //find min max of tree
    private BTNode minn(BTNode x){ // tim ben trai
        if(x.left==null)
            return x;
        else
            return minn(x.left);
    }
    private BTNode maxx(BTNode x){ // tim ben trai
        if(x.right==null)
            return x;
        else
            return maxx(x.right);
    }
    // delete min max of tree
    private BTNode delMin(BTNode x){
        if(x.left==null){
            return x.right;
        }
        x.left = delMin(x.left);
        return x;
    }
    private BTNode delMax(BTNode x){
        if(x.right==null){
            return x.left;
        }
        x.right = delMax(x.right);
        return x;
    }

    //del BT Node tree
    private BTNode deleteBTNode(BTNode x,Integer key){
        if(x==null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp<0){
            x.left = deleteBTNode(x.left,key);
        }
        else if(cmp > 0){
            x.right = deleteBTNode(x.right,key);
        }
        else{ // xóa nút cha là nút 7 ( nghĩa là cmp == 0)
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
    public static void main(String[] arg){
        String s="7 36 3 1 6 4 15 40 23 25";
        //String s="60 40 25 70 65 80";
        String[] key = s.split(" ");
        Integer[] k = new Integer[key.length];
        for(int i = 0;i<k.length;++i)
            k[i] = Integer.parseInt(key[i]);

        BST b = new BST(k[0]);
        for(int i = 1;i<k.length;++i)
            b.insert(b.root,k[i]);

        b.NodeLeftRight(b.root);
        System.out.println();

        // b.leftNodeRight(b.root);
        // System.out.println();

        // b.leftRightNode(b.root);
        // System.out.println();

        // b.NOdeRightLeft(b.root);
        // System.out.println();

        // b.rightNodeLeft(b.root);
        // System.out.println();

        // b.rightLeftNode(b.root);
        // System.out.println();

        // //dem tree
        // System.out.println("C1.no of nodes: "+iCountNode(b.root)); //c1
        //     //c2
        // int countNode=b.countNode(b.root);
        // System.out.println("C2.no of node: "+ countNode);

        // // tim kiem tree
        // System.out.println("Node in search:" + b.search(b.root,15));
        // // tim kiem min max tree
        // System.out.println("Node of min:" + b.minn(b.root));
        // System.out.println("Node of max:" + b.maxx(b.root));

        //delete min tree
        // b.delMin(b.root);
        // System.out.println("C1.no of nodes after delete min: "+iCountNode(b.root));
        // //delete max tree
        // b.delMax(b.root);
        // System.out.println("C1.no of nodes after delete max : "+iCountNode(b.root));
        // //them 1 NODe vao tree
        // b.insert(b.root,1666);//them vao 1 tree
        // System.out.println("C1.no of nodes after add 1 Node: "+iCountNode(b.root));
        
        // // delete BT Node
        // b.deleteBTNode(b.root,1666);
        // System.out.println("C1.no of nodes after delele the Node that new add: "+iCountNode(b.root));
        
        b.deleteBTNode(b.root,3);
        System.out.println("C1.no of nodes after delele the Node that new add: "+iCountNode(b.root));
        //chieu cao cua tree tree
        System.out.println("the high of tree:" + getHigh(b.root));
        b.NodeLeftRight(b.root);
    }
}
