public class Program{
    public static void main(String[] args){
        // AdjacencyMatrix matrix = new AdjacencyMatrix();
        // matrix.read("AM.txt");

        // AdjacencyList matrix = new AdjacencyList();
        // matrix.read("AL.txt");
        EdgeList matrix = new EdgeList();
        matrix.read("EL.txt");

        System.out.println(matrix.numOfVertices());
        matrix.print();
        matrix.enumerateNeighbors(3);
        System.out.println(matrix.hasEdge(1,2));
    }
}