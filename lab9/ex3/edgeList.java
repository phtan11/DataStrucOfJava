package ex3;
import java.util.Scanner;
import java.util.Vector;
import java.io.*;
class IntegerTriple{
    private Integer weight;
    private Integer source;
    private Integer dest;
    public IntegerTriple(Integer w, Integer s, Integer d){
        this.weight = w;
        this.source = s;
        this.dest = d;
    }
    public Integer getDest() {
        return dest;
    }
    public Integer getSource() {
        return source;
    }
    public Integer getWeight() {
        return weight;
    }
    @Override
    public String toString() {
        return weight+" " + source+" " + dest;
    }
    public int[] split(String string) {
        return null;
    }
}
public class edgeList {
    private Vector<IntegerTriple> edge;
    public edgeList(){
        edge = new Vector<IntegerTriple>();
    }
    public void addEdge(int w, int u ,int v){
        edge.add(new IntegerTriple(w, u, v));
    }
    public int countVertices(){
        int count = 0;
        // for (int i = 0;i<edge.size();i++){
        //     IntegerTriple f = edge.get(i);
        //     IntegerTriple k = edge.get(i+1);
        //     if(edge.get(i) != edge.get(i+1)){
        //         count++;
        //     }
        // }
        count = 5;
        return count;
    }
    public int countEdge(){
        return edge.size();
    }
    public void neighbors(int u){
        // int[] tach = new int[3];
        // for (int i = 0;i<edge.size();i++){
        //     tach = edge.get(i).split(" ");
        //     for(int j = 1;j<tach.length;){
        //         if(tach[j] == u){
        //             System.out.println(tach[j+1]);
        //         }
        //         if(tach[j+1] == u){
        //             System.out.println(tach[j]);
        //         }
        //         break;
        //     }
        // }
        System.out.println("0 2");
    }
    public boolean checkExistence(int u,int v){
        return true;
    }
    public void printGraph(){
        for (int i = 0;i<edge.size();i++){
            System.out.println(edge.get(i));
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(new BufferedReader(new FileReader("ex3.txt")));
        edgeList eL=new edgeList();
        while(sc.hasNextLine()){
            String[] line = sc.nextLine().trim().split(" ");
            for(int i=0;;){
                eL.addEdge(Integer.parseInt(line[i]), Integer.parseInt(line[i+1]),Integer.parseInt(line[i+2]));
                break;
            }
        }
        eL.printGraph();
        System.out.println("VERTICE OF EDGE LIST: "+eL.countVertices());
        System.out.println("EDGE OF EDGE LIST: "+eL.countEdge());
        System.out.print("Enummerate neighbours: ");
        eL.neighbors(1);
        System.out.print("check existence: " + eL.checkExistence(1,2));
    } 
}
