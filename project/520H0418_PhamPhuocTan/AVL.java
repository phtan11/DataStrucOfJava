import java.util.ArrayList;

public class AVL {
    private Node root;

    public AVL(){
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int height(Node node){		
		if (node == null) 
            return -1;   
        return node.getHeight();
	}

    private int checkBalance(Node x){
		return height(x.getLeft()) - height(x.getRight());
	}

    private Node balance(Node x) {
        if(checkBalance(x) < -1){
            if(checkBalance(x.getRight()) > 0){
                x.setRight(rotateWithRight(x.getRight()));
            }
            x = rotateWithLeft(x.getLeft());
        }
        else if(checkBalance(x) > 1){
            if(checkBalance(x.getLeft()) < 0){
                x.setLeft(rotateWithLeft(x.getLeft()));
            }
            x =rotateWithRight(x.getRight());
        }
		return x;
	} 
    private Node insert(Node node, Receipt receipt){
        if(node == null){ return new Node(receipt);}
        if(receipt.getReceiptId() < node.getReceipt().getReceiptId()){
            node.setLeft(insert(node.getLeft(), receipt));
        }
        else if(receipt.getReceiptId() == node.getReceipt().getReceiptId()){
            return node;
        }
        else{
            node.setRight(insert(node.getRight(), receipt));
        }
        node.setHeight(1+getMax(height(node.getLeft()) ,height(node.getRight())));
		int balance= checkBalance(node);
        if(balance > 1 && receipt.getReceiptId() < node.getLeft().getReceipt().getReceiptId()){
            return rotateWithRight(node);
        }
        if(balance < -1 && receipt.getReceiptId() > node.getRight().getReceipt().getReceiptId()){
            return rotateWithLeft(node);
        }
        if(balance > 1 && receipt.getReceiptId() > node.getLeft().getReceipt().getReceiptId()){
            node.setLeft(rotateWithLeft(node.getLeft()));
            return rotateWithRight(node);
        }
        if(balance < -1 && receipt.getReceiptId() < node.getRight().getReceipt().getReceiptId()){
            node.setRight(rotateWithRight(node.getRight()));
            return rotateWithLeft(node);
        }
        return node;
	}

    public void insertReceipt(Receipt receipt){
		this.root = insert(this.root, receipt);
	}
    // student code
    private int getMax(int x,int y){
        return x>y?x:y;
    }
    public Node rotateWithLeft(Node x){
        Node y = x.getRight();
        x.setRight(y.getLeft());
        y.setLeft(x);
        x.setHeight(1+getMax(height(x.getLeft()),height(x.getRight())));
        y.setHeight(1+getMax(height(y.getLeft()),height(y.getRight())));
        return y;
    }
    public Node rotateWithRight(Node x){
        Node y = x.getLeft();
        x.setLeft(y.getRight());
        y.setRight(x);
        x.setHeight(1+getMax(height(x.getLeft()),height(x.getRight())));
        y.setHeight(1+getMax(height(y.getLeft()),height(y.getRight())));
        return y;
    }
    // student end code
    private void NLR(Node node, ArrayList<String> result){
		if (node != null) 
        { 
			result.add(node.getReceipt().toString()) ; 
            NLR(node.getLeft(), result);             
            NLR(node.getRight(), result); 
        } 
	}
	
	public void NLR(ArrayList<String> result){
		NLR(this.root, result);
	}

    private Node search(Node x, int receiptId) {
        if(x == null) return null;
        else if(receiptId< x.getReceipt().getReceiptId()){
            return search(x.getLeft(),receiptId);
        }
        else if (receiptId == x.getReceipt().getReceiptId()){
            return x;
        }
        else{
            return search(x.getRight(),receiptId);
        }
	}
	
	public String search(int receiptId){
		return search(root, receiptId).getReceipt().toString();
	}
}
