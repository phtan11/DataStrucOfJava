public interface Graph{
    public void read(String input);
    public int numOfVertices();
    public int numOfEdges();
    public void enumerateNeighbors(int u);
    public boolean hasEdge(int u, int v);
    void print();
}