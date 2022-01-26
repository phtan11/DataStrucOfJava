import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class AM {
    private int [][] adj;
    private final int NUMBER_OF_VERTICES;
    public AM(int vertices){
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
    public void BFS(int s,int v){
        boolean visited[] = new boolean[NUMBER_OF_VERTICES];
        Queue <Integer > queue = new LinkedList <Integer >();
        visited[s] = true;
        queue.add(s);
        while(!(queue.peek() == v)){
            int x = queue.poll();
            System.out.print(x + " ");
            for(int i = 0; i < NUMBER_OF_VERTICES; i++){
                if(adj[x][i] != 0 && visited[i] == false){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    public void BFS(int s){
        boolean visited[] = new boolean[NUMBER_OF_VERTICES];
        Queue <Integer > queue = new LinkedList <Integer >();
        visited[s] = true;
        queue.add(s);
        while(!queue.isEmpty()){
            int x = queue.poll();
            System.out.print(x + " ");
            for(int i = 0; i < NUMBER_OF_VERTICES; i++){
                if(adj[x][i] != 0 && visited[i] == false){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    public void DFS_recur(int v, boolean [] visited){
        visited[v] = true;
        System.out.print(v+" ");
        for (int i = 0; i <NUMBER_OF_VERTICES;i++){
            if(adj[v][i] != 0 && visited[i] == false){
                DFS_recur(i,visited);
            }
        }
    }
    public void DFS(int s){
        boolean [] visited = new boolean[NUMBER_OF_VERTICES];
        DFS_recur(s,visited);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Vertices;
        System.out.println("Enter the number of vertices: ");
        Vertices = sc.nextInt();
        // int startVer;
        // System.out.println("Enter the start vertice: ");
        // startVer = sc.nextInt();
        // int endVer;
        // System.out.println("Enter the end vertice: ");
        // endVer = sc.nextInt();
        AM adjList = new AM(Vertices);
        for(int i =0;i<Vertices;i++){
            for (int j = 0;j<Vertices;j++){
                System.out.println("enter adjList[" + (i+1) + "][" + (j+1)+"]= ");
                adjList.adj[i][j] = sc.nextInt();
            }
        }
        adjList.printGraph();
        System.out.println();
        adjList.BFS(0,6);
        System.out.println();
        adjList.BFS(0);
        System.out.println();
        adjList.DFS(2);
    }
}
