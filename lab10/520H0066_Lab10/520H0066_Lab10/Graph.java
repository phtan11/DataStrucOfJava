public interface Graph {
    void read(String path);
    int numOfVertices();
    int numOfEdges();
    void print();
    void enumerate(int u);
    boolean hasEdge(int u, int v);
}
