package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    // Una lista de listas para representar una lista de adyacencia
    private List<List<Integer>> adjList = null;

    // Constructor
    public Grafo(List<Aristas> aristas, int numVertices) { // "List<Aristas>" es la lista de vertices y "numVertices"
        // es el número de nodos o vertices.

        // Lista de adyacencia: contiene las relaciones de cada nodo o vertice
        adjList = new ArrayList<>();

        //se enlistan listas de adyacencia para almacenar las relaciones de cada vertice de acuerdo al indice.
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Agrega las aristas a cada una de las listas de adyacencia
        for (int i=0; i<aristas.size();i++) {

            int from = aristas.get(i).getSource();
            int to = aristas.get(i).getDest();
            adjList.get(from).add(to);
        }
    }

    public void Warshall(Grafo grafo, byte[][] matriz, int fila, int column, int cont) {

        //"index" representa el nodo destino de los vertices
        for (int index: grafo.getAdjList().get(column)) {

            // si "child" es un vertice adyacente de descendant, tenemos que encontrar una ruta de root -> a child
            if (matriz[fila][index+cont] == 0) {

                matriz[fila][index+cont] = 1;
                Warshall(grafo, matriz, fila, index+cont,cont);
            }
        }
    }

    public List<List<Integer>> getAdjList() {
        return adjList;
    }
}
