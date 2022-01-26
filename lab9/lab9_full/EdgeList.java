import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;

public class EdgeList{
    private int size;
    private int[][] adj;
    private int edges;

    public void read(String input){
        try{
            Scanner scanner = new Scanner(new File(input));
            int countEdges = 0;
            LinkedList<Integer> list = new LinkedList<>(); 
            adj = new int[9999][9999];
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] num = line.split(" ");
                adj[Integer.parseInt(num[1])][Integer.parseInt(num[2])]=Integer.parseInt(num[0]);
                adj[Integer.parseInt(num[2])][Integer.parseInt(num[1])]=Integer.parseInt(num[0]);
                countEdges++;
                if (!list.contains(Integer.parseInt(num[1]))){
                    list.add(Integer.parseInt(num[1]));
                }
                if (!list.contains(Integer.parseInt(num[2]))){
                    list.add(Integer.parseInt(num[2]));
                }
            }
            this.size = list.size();
            this.edges = countEdges;
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
            throw new RuntimeException("u is not exist");
        }
        for (int i=0;i<size;i++){
            if (adj[u][i]!=0) System.out.print(i+ " ");
        }
        System.out.println();
    }

    public boolean hasEdge(int u, int v){
        if (u<1 || u>size || v<1 || v>size){
            throw new RuntimeException("input invalid");
        }
        return adj[u][v]!=0;
    }

    public void print(){
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                System.out.print(adj[i][j]+ " ");
            }
            System.out.println();
        }
    }
}