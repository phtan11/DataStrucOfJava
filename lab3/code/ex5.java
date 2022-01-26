package code;
public class ex5 {
    public static int decToBin(int dec){
        if(dec==1) return 1;
        return (dec%2+10*decToBin(dec/2));
    }
    public static void main(String[] args){
        System.out.println(decToBin(8));
    }
}
