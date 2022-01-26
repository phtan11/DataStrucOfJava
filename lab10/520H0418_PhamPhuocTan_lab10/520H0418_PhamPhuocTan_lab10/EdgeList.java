import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;
import java.io.*;

class Edge{
    public int weight;
    public int source;
    public int dest;
    public Edge(int w, int s, int d){
        this.weight = w;
        this.source = s;
        this.dest = d;
    }
    @Override
    public String toString() {
        return weight+" " + source+" " + dest;
    }

}
public class EdgeList{

    private int numOfVertices;
    private Vector<Edge> edges;
    public void addEdge(int w, int u ,int v){
        edges.add(new Edge(w, u, v));
    }
    public EdgeList(){
        edges = new Vector<Edge>();
    }
    public void read(String path) throws FileNotFoundException {

        Scanner sc=new Scanner(new BufferedReader(new FileReader(path)));
        EdgeList eL=new EdgeList();
        while(sc.hasNextLine()){
            String[] line = sc.nextLine().trim().split(" ");
            for(int i=0;;){
                eL.addEdge(Integer.parseInt(line[i]), Integer.parseInt(line[i+1]),Integer.parseInt(line[i+2]));
                break;
            }
        }
    }
    public void kruskal(){
        edges.sort(new Comparator<Edge>(){
            public int compare(Edge o1, Edge o2){
                return o1.weight - o2.weight;
            }
        });

        UnionFind unionFind = new UnionFind(numOfVertices);
        int totalWeight = 0;
        int count = 0;
        for (int i=0;i<edges.size() && count!=numOfVertices-1;i++){
            Edge e = edges.get(i);
            int s = e.source;
            int d = e.dest;
            int w = e.weight;

            if (unionFind.isSameSet(s, d)){
                continue;
            }
            count++;
            totalWeight+=w;
            unionFind.unionSet(s,d);
            System.out.println(e);
        }
        System.out.println("Total weight: " + totalWeight);
    }
}

