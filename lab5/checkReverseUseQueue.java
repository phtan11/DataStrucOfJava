import java.util.Queue;
import java.util.LinkedList;
public class checkReverseUseQueue {
    public static void main(String[] args){
        Queue queue = new LinkedList();
        String txt = "abccba";
        for(int i = txt.length() - 1; i >= 0; i--){
            queue.add(txt.charAt(i));
        }
        String reverse ="";
        while(!queue.isEmpty()){
            reverse = reverse + queue.remove();
        }
        if(reverse.equals(txt)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}
