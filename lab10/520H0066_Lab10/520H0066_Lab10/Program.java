public class Program {
    public static void main(String[] args) {
        // EdgeList matrix = new EdgeList();
        // matrix.read("EL.txt");

        // matrix.kruskal();
        AdjacencyMatrix matrix = new AdjacencyMatrix();
        matrix.read("AM.txt");

        matrix.prim(0);
    }
}
