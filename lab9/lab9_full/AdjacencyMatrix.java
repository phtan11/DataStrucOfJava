import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class AdjacencyMatrix implements Graph, GraphTraversal{
    private int[][] adj;
    private int size;
    private int edges;

    public void read(String input){
        File f = new File(input);
        try{
            Scanner scanner = new Scanner(f);
            this.size = scanner.nextInt();
            scanner.nextLine();
            adj = new int[size][size];
            int sum = 0;

            for (int i=0;i<size;i++){
                String line = scanner.nextLine();
                String[] num = line.split(" ");


                for (int j=0;j<size;j++){
                    int x = Integer.parseInt(num[j]);
                    //System.out.print(x);
                    sum+= x;
                    adj[i][j] = x;
                }
            }

            this. edges = sum/2;
            scanner.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        
    }

    public int numOfVertices(){
        return this.size;
    }

    public int numOfEdges(){
        return this.edges;
    }

    public void enumerateNeighbors(int u){
        int row = u -1;
        if (u<1 || u>size){
            throw new RuntimeException("u is not exist");
        }
        for (int i=0;i<size;i++){
            if (adj[row][i] == 1){
                System.out.print((i+1)+" ");
            }
        }
        System.out.println();
    }

    public boolean hasEdge(int u, int v){
        if (u<1 || u>size || v<1 || v>size){
            throw new RuntimeException("input invalid");
        }
        u-=1;
        v-=1;
        return adj[u][v]==1;
    }

    public void print(){
        for (int i=0; i<size;i++){
            for (int j=0;j<size;j++){
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void DFSWithoutRecur(int v){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[size];

        // for (int i=0;i<size;i++){
        //     visited[i]=false;
        // }
        v-=1;
        visited[v] = true;
        stack.push(v);
        while (!stack.isEmpty()){
            int x = stack.pop();
            System.out.print(x+ " ");
            for (int i=0;i<size;i++){
                if (visited[i]==false && adj[x][i]==1){
                    stack.push(i);
                    visited[i]=true;
                }
            }
        }
        System.out.println();
    }

    public void BFS(int v){
        boolean visited[] = new boolean[size];
        Queue<Integer> queue = new LinkedList<Integer>();

        visited[v]=true;
        queue.add(v);

        while (!queue.isEmpty()){
            int x = queue.pull();
            System.out.print(x+ " ");

            for (int i=0;i<size;i++){
                if (adj[x][i]!=0 && visited[i]==false){
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
        System.out.println();
    }

    public void DFS(int v){
        boolean[] visited = new boolean[size];
        DFS_recur(s,visited);
    }

    private voud DFS_recur(int v, boolean[] visited){
        visited[v]=true;
        System.out.print(v+ " ");
        for (int i=0;i<size;i++){
            if (adj[v][i]!=0 && visited[i]==false){
                DFS_recur(i,visited);
            }
        }
    }

    public void isReachable(int u, int v){
        return adj[u,v]==1;
    }
}