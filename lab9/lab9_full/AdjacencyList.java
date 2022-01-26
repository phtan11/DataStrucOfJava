import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;


public class AdjacencyList implements Graph{
    private int size;
    private LinkedList<Integer> adj[];
    private int edges;

    public void read(String input){
        try{
            Scanner scanner = new Scanner(new File(input));
            this.size = scanner.nextInt();
            this.adj = new LinkedList[size];
            scanner.nextLine();
            int count = 0;
            for (int i=1;i<=size;i++){
                String line = scanner.nextLine();
                String[] num = line.split(" ");
                int index = Integer.parseInt(num[0]);
                adj[index] = new LinkedList<>();

                for (int j=1;j<num.length;j++){
                    int x = Integer.parseInt(num[j]);
                    adj[index].addLast(x);
                    count++;
                }
            }
            this.edges = count/2;
            scanner.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        
    }

    public int numOfVertices(){
        return size;
    }

    public int numOfEdges(){
        return edges;
    }

    public void enumerateNeighbors(int u){
        if (u<1 || u>size){
            throw new RuntimeException("input invalid");
        }
        u-=1;
        LinkedList<Integer> list = adj[u];
        for (int i=0;i<list.size();i++){
            System.out.print((list.get(i)+1) + " ");
        }
        System.out.println();

    }

    public boolean hasEdge(int u, int v){
        if (u<1 || u>size || v<1 || v>size){
            throw new RuntimeException("input invalid");
        }
        u-=1;
        v-=1;
        LinkedList<Integer> list = adj[u];
        return list.contains(v);
    }

    public void print(){
        for (int i=0;i<size;i++){
            LinkedList<Integer> list = adj[i];
            System.out.print(i+ " ");
            for (int j=0;j<list.size();j++){
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
    }
}