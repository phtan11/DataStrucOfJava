import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class EdgeList implements Graph{

    private int numOfVertices;
    private Vector<Edge> edges;

    @Override
    public void read(String path) {

        edges = new Vector<>(10);
        numOfVertices = 0;
        try {

            Scanner scanner = new Scanner(new File(path));
            Set<Integer> vertices = new HashSet<>();
            while (scanner.hasNextLine()) {
                String[] items = scanner.nextLine().split(" ");
                int w = Integer.parseInt(items[0]);
                int s = Integer.parseInt(items[1]);
                int d = Integer.parseInt(items[2]);

                Edge edge = new Edge(w, s, d);
                edges.add(edge);
                numOfVertices++;

                vertices.add(s);
                vertices.add(d);
            }
            this.numOfVertices = vertices.size();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int numOfVertices() {
        return numOfVertices;
    }

    @Override
    public int numOfEdges() {
        return edges.size();
    }

    @Override
    public void print() {
        for (int i = 0; i < edges.size(); i++)
        {
            System.out.println(edges.get(i));
        }
    }

    @Override
    public void enumerate(int u) {
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            if (edge.source == u) {
                System.out.print(edge.dest + " ");
            }
            else if (edge.dest == u) {
                System.out.print(edge.source + " ");
            }
        }
        System.out.println();
    }

    @Override
    public boolean hasEdge(int u, int v) {
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            if ((edge.source == u && edge.dest == v) ||
                    (edge.source == v && edge.dest == u)) {
                return true;
            }
        }
        return false;
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
