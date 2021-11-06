import Algorithm.Aristas;
import Algorithm.Grafo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    // se calcula la cantidad de nodos o vertices que tendrá el grafo.
    public int cantidadVertices(List<Aristas> aristasList) {

        int numMayor = aristasList.get(0).getSource();
        ArrayList<Integer> vertices = new ArrayList<>();

        //se obtiene el vertice mayor, para su futuro uso.
        for (int i = 0; i < aristasList.size(); i++) {
            if (aristasList.get(i).getDest()>numMayor){
                numMayor=aristasList.get(i).getDest();
            }if (aristasList.get(i).getSource()>numMayor){
                numMayor=aristasList.get(i).getSource();
            }
        }
        return numMayor;
    }

    private void recorrido(List<Aristas> edges){

        // se obtiene el vertice mayor para conocer el total de vertices del grafo.
        int numNodos = cantidadVertices(edges);

        // se construye un grafo de acuerdo a las aristas dadas.
        Grafo graph = new Grafo(edges, numNodos+1);

        // Variable que se utiliza para saber si el primer  vertice del grafo comienza con cero o uno.
        int cont=0;
        if(graph.getAdjList().get(0).size()==0){
            graph.getAdjList().remove(0);
            cont=-1;
        }
        //se actualiza el número de vertices, ya que dependerá si el primer vertice comienza con cero o uno.
        numNodos= graph.getAdjList().size();

        // "matriz" es una matriz de conexiones y almacena el cierre transitivo del grafo, el valor en la posición
        //   matriz[i][j] es igual a "1" siempre que la ruta directa del vertice "i" al vertice "j" exista.
        byte matriz[][] = new byte[graph.getAdjList().size()][graph.getAdjList().size()];

        for (int v = 0; v < numNodos; v++) {
            matriz[v][v] = 1;
            graph.Warshall(graph, matriz, v, v,cont);

            // imprime la información de la ruta de un vertice; es decir, cada fila.
            System.out.println(Arrays.toString(matriz[v]));
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        // se crea una lista de aristas de un grafo
        List<Aristas> edges = Arrays.asList(new Aristas(1, 2), new Aristas(2, 4),
                new Aristas(2, 5),new Aristas(3, 1),new Aristas(3, 2),
                new Aristas(3, 5),new Aristas(4, 5),new Aristas(4, 1),
                new Aristas(5, 4));
                /*new Aristas(0, 2), new Aristas(1, 0), new Aristas(3, 1)) */
        main.recorrido(edges);

    }
}
