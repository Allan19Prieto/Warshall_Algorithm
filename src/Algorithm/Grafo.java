package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    // Una lista de listas para representar una lista de adyacencia
    private List<List<Integer>> adjList = null;

    // Constructor
    public Grafo(List<Aristas> aristas, int numVertices) { // List<Aristas> es la lista de vertices y "n" es
        // el número de// nodos o vertices.

        // Lista de adyacencia: contiene las relaciones de cada nodo o vertice
        adjList = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Agrega las aristas a una lista adyacencia
        for (int i=0; i<aristas.size();i++) {

            int from = aristas.get(i).getSource();
            int to = aristas.get(i).getDest();
            adjList.get(from).add(to);
        }
        if(adjList.get(0).size()==0){
            adjList.remove(0);
        }
    }

    public void Warshall(Grafo grafo, byte[][] C, int root, int descendant){//,int cont) {
        //System.out.println(descendant);
        for (/*int i=cont;i<grafo.getAdjList().size();i++*/int child: grafo.getAdjList().get(descendant)) {
            //System.out.println(child);
            // if `child` is an adjacent vertex of descendant, we have
            // found a path from root->child
            // if child es un vertice adyacente de descendant, tenemos que encontrar una ruta de root -> a child
            if (C[root][child-1] == 0) {

                C[root][child-1] = 1;
                Warshall(grafo, C, root, child-1);
                //System.out.println(descendant);
            }
        }
        //System.out.println("hola final");
    }

    public List<List<Integer>> getAdjList() {
        return adjList;
    }
}
