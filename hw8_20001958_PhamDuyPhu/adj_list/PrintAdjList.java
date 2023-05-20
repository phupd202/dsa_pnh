package hw8_20001958_PhamDuyPhu.adj_list;

import java.util.ArrayList;

public class PrintAdjList {
    public static void main(String[] args) {
        int V = 5; 

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        // đỉnh số 0
        int[] list_0 = {1, 4};
        ArrayList<Integer> adj_0 = creAdj(list_0);

        // đỉnh số 1
        int[] list_1 = {0, 2, 3, 4};
        ArrayList<Integer> adj_1 = creAdj(list_1);

        // đỉnh số 2
        int[] list_2 = {1, 3, 4};
        ArrayList<Integer> adj_2 = creAdj(list_2);
        
        // đỉnh số 3
        int[] list_3 = {1, 2, 4};
        ArrayList<Integer> adj_3 = creAdj(list_3);

        // đỉnh số 4
        int[] list_4 = {0, 1, 3};
        ArrayList<Integer> adj_4 = creAdj(list_4);
        
        graph.add(adj_0);
        graph.add(adj_1);
        graph.add(adj_2);
        graph.add(adj_3);
        graph.add(adj_4);

        printGraph(graph);

    }

    public static ArrayList<Integer> creAdj(int[] list_V) {
        ArrayList<Integer> adj = new ArrayList<Integer>();
        
        for (int i = 0; i < list_V.length; i++) {
            adj.add(list_V[i]);
        }
        return adj;
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> graph) {
        int n = graph.size();

        for (int i = 0; i < n; i++) {
            System.out.println("Đỉnh: " + i);
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j) + " ");
            }  
            System.out.println();
        }
    }
}
