import Algorithm.Aristas;
import Algorithm.Grafo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public int cantidadVertices(List<Aristas> aristasList) {

        int numMayor = aristasList.get(0).getSource();
        ArrayList<Integer> vertices = new ArrayList<>();

        for (int i = 0; i < aristasList.size(); i++) {
            if (aristasList.get(i).getDest()>numMayor){
                numMayor=aristasList.get(i).getDest();
            }if (aristasList.get(i).getSource()>numMayor){
                numMayor=aristasList.get(i).getSource();
            }
        }
        return numMayor;
    }

    public static void main(String[] args) {
        Main p= new Main();
        // List of graph edges as per the above diagram
        List<Aristas> edges = Arrays.asList( new Aristas(1, 2), new Aristas(2, 4),
                new Aristas(2, 5),new Aristas(3, 1),new Aristas(3, 2),
                new Aristas(3, 5),new Aristas(4, 5),new Aristas(4, 1),
                new Aristas(5, 4));

        // total number of nodes in the graph (labelled from 0 to 3)
        int numNodos = p.cantidadVertices(edges);

        // build a graph from the given edges
        Grafo graph = new Grafo(edges, numNodos+1);

        // "matriz" es una matriz de conexiones y almacena el cierre transitivo del grafo, el valor en la posición
        //  matriz[i][j] es igual a "1" siempre que la ruta directa del vertice "i" al vertice "j" exista.
        byte matriz[][] = new byte[numNodos][numNodos];

        // consider each vertex and start DFS from it
        int cont=0;
        for (int v = 0; v < numNodos; v++) {
            matriz[v][v] = 1;
            graph.Warshall(graph, matriz, v, v);//,cont);
            //if (graph.getAdjList().get(v).size()==0){
            //    cont++;
            //}
            // print path info for vertex `v`
            System.out.println(Arrays.toString(matriz[v]));
        }
    }
}
