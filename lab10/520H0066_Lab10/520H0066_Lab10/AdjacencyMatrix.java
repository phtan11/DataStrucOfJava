import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix implements Graph{
    private int[][] adj;
    private int size;
    private int numOfEdges;

    @Override
    public void read(String path) {
        try {

            Scanner scanner = new Scanner(new File(path));

            size = scanner.nextInt();
            scanner.nextLine();

            adj = new int[size][size];
            int count = 0;

            for (int i = 0; i < size; i++)
            {
                String[] items = scanner.nextLine().split(" ");
                for (int j = 0; j < items.length; j++)
                {
                    adj[i][j] = Integer.parseInt(items[j]);
                    if (adj[i][j]>0) count++;
                }
            }

            numOfEdges = count / 2;
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int numOfVertices() {
        return size;
    }

    @Override
    public int numOfEdges() {
        return numOfEdges;
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void enumerate(int u) {
        if (u < 1 || u > size) {
            throw new RuntimeException("Invalid Parameter");
        }
        u -= 1;
        for (int i = 0; i < size; i++) {
            if (adj[u][i] == 1) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    @Override
    public boolean hasEdge(int u, int v) {
        if (u < 1 || u > size || v < 1 || v > size) {
            throw new RuntimeException("Invalid Parameter");
        }
        return adj[u - 1][v - 1] == 1;
    }

    public void prim(int u){
        List<Integer> visited = new ArrayList<>();
        int totalWeight=0;

        visited.add(u);
        while (visited.size() < size){
            int minWeight = Integer.MAX_VALUE;
            int sourceVertex = -1;
            int desVertex = -1;
            for (Integer s: visited){
                for (int d=0;d<size;d++){
                    if (visited.contains(d)) continue;
                    if (adj[s][d]>0 && adj[s][d]<minWeight){
                        minWeight=adj[s][d];
                        sourceVertex=s;
                        desVertex=d;
                    }
                }
            }
            System.out.println(sourceVertex+"->"+desVertex+": "+minWeight);
            totalWeight+=minWeight;

            visited.add(desVertex);
        }
        System.out.print("Total weight: "+totalWeight);
    }
}
