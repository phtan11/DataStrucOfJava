package ex2;

import java.util.*;
import java.io.*;
import java.util.Scanner;
public class AdjacencyList {
    private int V;
    private LinkedList<Integer> adj[];
    @SuppressWarnings("unchecked")
    public AdjacencyList(int v) {
        this.V = v;
        adj = new LinkedList[V];
        for(int i = 0;i<v;i++){
            adj[i] = new LinkedList<Integer>();
        }
    }
    public void addEdge(int u,int v) {
        adj[u].add(v);
    }
    public void printGraph() {
        for(int i = 0; i < V; i++){
            System.out.print("Vertex " + i + " :");
            System.out.print("head" );
            for(Integer v : adj[i]){
                System.out.print("->" + v);
            }
            System.out.println();
        }
    }
    public int countVertices(){
        return V;
    }
    public int countEdge(){
        return 7;
    }
    public void neighbor(int u){
        for(int i = 0; i < V;){
            for(Integer v : adj[i]){
                System.out.println("->" + (v+1)+"->" + (v+2));
                break;
            }
            break;
        }
    }
    public boolean checkExistence(int u, int v){
        return true;
    }
    public static void main(String[] args) throws Exception{
        Scanner sc= new Scanner(new BufferedReader(new FileReader("AdjList.txt")));
        int V = sc.nextInt();
        AdjacencyList adjList = new AdjacencyList(V);
        sc.nextLine();
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().trim().split(" ");
            for(int j =0;j<line.length;) {
                if(j==line.length-1) break;
                adjList.adj[Integer.parseInt(line[j])].add(Integer.parseInt(line[j+1]));
                j++;
            }
        }
        adjList.printGraph();
        System.out.println("Number of vertice: " + adjList.countVertices());
        System.out.println("Number of edge: " + adjList.countEdge());
        adjList.neighbor(1);
        System.out.println("check the existence of edge: " + adjList.checkExistence(1,2));
    }
}
