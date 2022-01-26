package ex1;

import java.io.*;
import java.util.Scanner;
public class AdjacencyMatrix {
    private int [][] adj;
    private final int NUMBER_OF_VERTICES;
    public AdjacencyMatrix(int vertices){
        NUMBER_OF_VERTICES = vertices;
        adj = new int[NUMBER_OF_VERTICES][NUMBER_OF_VERTICES];
    }
    public void setEdge(int vertexSource,int vertexDestination, int weight){
        try{
            adj[vertexSource][vertexDestination]= weight;
            adj[vertexDestination][vertexSource]=weight;
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("the vertex is an invalid");
        }
    }
    public int getEdge(int vertexSource,int vertexDestination){
        try{
            return adj[vertexSource][vertexDestination];
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("the vertex is an invalid");
        }
        return -1;
    }
    public void printGraph(){
        for(int i=0;i<NUMBER_OF_VERTICES;i++){
            for (int  j =0;j<NUMBER_OF_VERTICES;j++){
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int countVertices(){
        int count = 0;
        int i = 0;
        while(i<NUMBER_OF_VERTICES){
            count++;
            i++;
        }
        return count;
    }
    public int countEdge(){
        int count = 0;
        for(int i = 0;i<NUMBER_OF_VERTICES;i++){
            for(int j = 0;j<NUMBER_OF_VERTICES;j++){
                if(adj[i][j] == 1){
                    count++;
                }
            }
        }
        return (count/2)-1;
    }
    public void EnumerateNeighbors(int u){
        for (int i = u;;){
            for (int  j = 0;j<NUMBER_OF_VERTICES;j++){
                if(adj[i][j] == 1){
                    System.out.print(j+" ");
                }
            }
            break;
        }
    }
    public boolean checkExistence(int u,int v){
        if(adj[u][v] == 1){
            return true;
        }
        else return false;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(new BufferedReader(new FileReader("2DInput.txt")));
        int n = sc.nextInt();
        AdjacencyMatrix adjMatrix = new AdjacencyMatrix(n);
        sc.nextLine();
        while (sc.hasNextLine()) {
            for(int i =0;i<n;i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for(int j = 0;j<line.length;j++) {
                    adjMatrix.adj[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
        adjMatrix.printGraph();
        //b
        System.out.println("Count the number of vertices: "+ adjMatrix.countVertices());
        System.out.println("Count the number of edge: "+ adjMatrix.countEdge());
        System.out.print("address of 0: ");
        adjMatrix.EnumerateNeighbors(0);
        System.out.println();
        System.out.println("check existence of edge u and v: "+ adjMatrix.checkExistence(1,2));
    }
}

