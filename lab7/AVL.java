public class AVL {
    AVLNode root;
    public AVL(int key){
        root = new AVLNode(key);
    }
    public AVL(){
        root = new AVLNode();
    }
    public int height(AVLNode node) {
        if(node == null){
            return -1;
        }
        return node.height;
    }
    private int max(int a, int b){
        return a>b?a:b;
    }


    // xoay trai (rotate left)
    public AVLNode rotateLeft(AVLNode node){
        AVLNode y = node.right;
        node.right = y.left;
        y.left = node;
        node.height = 1 + max(height(node.left),height(node.right));
        y.height = 1+max(height(y.left),height(y.right));
        return y;
    }
    //xoay phai (rotate right)
    public AVLNode rotateRight(AVLNode node){
        AVLNode y  = node.left;
        node.left = y.right;
        y.right = node;
        node.height = 1 +max(height(node.left),height(node.right));
        y.height = 1 +max(height(y.left),height(y.right));
        return y;
    }

    // can bang treee
    public int checkBalance(AVLNode node){
        if(node == null){ return 0; }
        return height(node.left)-height(node.right);
    }
    public AVLNode makeBalance(AVLNode node){
        if(checkBalance(node) < -1){
            if(checkBalance(node.right) > 0){
                node.right = rotateRight(node.right);
            }
            node = rotateLeft(node.left);
        }
        else if(checkBalance(node) > 1){
            if(checkBalance(node.left) < 0){
                node.left = rotateLeft(node.left);
            }
            node.right = rotateRight(node.right);
        }
        return node;
    }

    //them tree
    public AVLNode insertBST(AVLNode node,Integer key){
        if(node == null){
            return new AVLNode(key);
        }
        int cmp = key.compareTo(node.key);
        if(cmp <0)
            node.left = insertBST(node.left,key);
        else if(cmp > 0)
            node.right = insertBST(node.right,key);
        else
            node.key = key;
        return node;
    }
    // create tree as insert after
    public AVLNode insertAVL(AVLNode node,Integer key){
        if(node==null){ return new AVLNode(key); }
        int cmp = key.compareTo(node.key);
        if(cmp <0)
            node.left = insertBST(node.left,key);
        else if(cmp > 0)
            node.right = insertBST(node.right,key);
        else
            node.key = key;
        node.height = 1+max(height(node.left),height(node.right));
        int balance  = checkBalance(node);
        
        if(balance > 1 && key< node.left.key){
            return rotateRight(node);
        }
        if(balance < -1 && key> node.right.key){
            return rotateLeft(node);
        }
        if(balance > 1 && key > node.left.key){
            node.left = rotateLeft(node);
            return rotateRight(node);
        }
        if(balance < -1 && key< node.right.key){
            node.right = rotateRight(node);
            return rotateLeft(node);
        }
        return node;

    }
    //min trree
    public AVLNode minVal(AVLNode node){
        AVLNode a;
        for(a=node;a.left!=null; a = a.left); // gan cho a gia tri cui cung
            return a;
    }
    //deletion
    public AVLNode del(AVLNode node,Integer key){
        if(node==null) return node;
        if(key < node.key){
            node.left = del(node.left,key);
        }
        else if(key > node.key){
            node.right = del(node.right,key);
        }
        else{
            if(node.left ==null || node.right == null){
                AVLNode temp=null;
                if(temp ==node.left)
                    temp = node.right;
                else
                    temp = node.left;
                
                if(temp == null){
                    temp = node;
                    node = null;
                }
                else
                    node = temp;
            }
            else{
                AVLNode temp = minVal(node.right);
                node.key = temp.key;
                node.right = del(node.right,temp.key);
            }
        }
        if(node == null)
            return node;
        node.height = 1+ max(height(node.left),height(node.right));
        int bal = checkBalance(node);
        
        if(bal > 1 && checkBalance(node.left) >=0)
            return rotateRight(node);
        if(bal > 1 && checkBalance(node.left) < 0){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if(bal < -1 && checkBalance(node.right) <= 0)
            return rotateLeft(node);
        if(bal< -1 && checkBalance(node.right) > 0){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;

    }



    //duyet tree
    public void NLR(AVLNode node){
        if(node != null){
            System.out.print(node.key +" ");
            NLR(node.left);
            NLR(node.right);
        }
    }
    public static void main(String[] args){
        
        //c1
        int[] k ={10,20,30,40,50,25};
        AVL b = new AVL(k[0]);
        for(int i=1; i<k.length; i++){
            b.insertBST(b.root,k[i]);
        }
        b.NLR(b.root);
        System.out.println();
        //delete BST
        b.del(b.root,25);
        b.NLR(b.root);

        
        
        
        /*
        //    c2
        AVL b = new AVL();
        b.root = b.insertBST(b.root,10);
        b.root = b.insertBST(b.root,20);
        b.root = b.insertBST(b.root,30);
        b.root = b.insertBST(b.root,40);
        b.root = b.insertBST(b.root,50);
        b.root = b.insertBST(b.root,25);
        b.NLR(b.root);
        System.out.println();
        b.root  = b.insertAVL(b.root,100);
        b.NLR(b.root);
        System.out.println();

        b.root = b.del(b.root,10);
        b.root = b.del(b.root,100);
        b.NLR(b.root);
        */
    }
}
