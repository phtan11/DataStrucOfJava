public class Edge {
    public int weight;
    public int source;
    public int dest;

    public Edge(int weight, int source, int dest) {
        this.weight = weight;
        this.source = source;
        this.dest = dest;
    }

    public String toString() {
        return "(" + source + "->" + dest + ": " + weight + ")";
    }
}
