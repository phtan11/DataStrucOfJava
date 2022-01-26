import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
    // duyet ma tran ke
    //BFS
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
    //DFS
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
    public void prim(int u){
        List<Integer> visited = new ArrayList<>();
        int totalWeight=0;

        visited.add(u);
        while(visited.size() < NUMBER_OF_VERTICES){
            int minWeight = Integer.MAX_VALUE;
            int sourceVertex = -1;
            int desVertex = -1;
            int i =-1;
            for (Integer s: visited){
                for (int d=0;d<NUMBER_OF_VERTICES;d++){
                    if (visited.contains(d)) continue;
                    if (adj[s][d]>0 && adj[s][d]<minWeight){
                        minWeight=adj[s][d];
                        sourceVertex=s;
                        desVertex=d;
                    }
                }
                i++;
            }
            System.out.println("Edge "+i+":" +"(" +sourceVertex+","+desVertex+")"+": "+"cost: "+minWeight);
            totalWeight+=minWeight;
            visited.add(desVertex);
        }
        System.out.print("Minium cost: "+totalWeight);
    }
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(new BufferedReader(new FileReader("AM.txt")));
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
        EdgeList eL=new EdgeList();
        eL.read("EL.txt");

        
        System.out.println(n);
        adjMatrix.printGraph();
        System.out.println("BFS:");
        adjMatrix.BFS(0);
        System.out.println();
        System.out.println("DFS:");
        adjMatrix.DFS(0);
        System.out.println();
        System.out.println("MST by Prim's algorithm:");
        adjMatrix.prim(0);
        System.out.println();
        System.out.println("MST by Kruskal's algorithm:");
        eL.kruskal();
    }
}

