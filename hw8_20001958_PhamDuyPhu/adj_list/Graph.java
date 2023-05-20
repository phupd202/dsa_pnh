package hw8_20001958_PhamDuyPhu.adj_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private int V;
    private List<ArrayList<Integer>> adjList;

    // constructor
    public Graph(int v) {
        this.V = v;
        // init
       adjList = new ArrayList<ArrayList<Integer>>(V);
       for (int i = 0; i < V; i++) {
        adjList.add(new ArrayList<Integer>());
       }

    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    // 3. Duyệt đồ thị dfs
    public void dfs(int start) {
        boolean visited[] = new boolean[V];
        dfsUtil(start, visited);
    }

    private void dfsUtil(int i, boolean[] visited) {
        visited[i] = true;
        System.out.println(i + " ");

        List<Integer> neighbors = adjList.get(i);
        for (int neighbor : neighbors) {
            if(!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    // 4. Duyệt đồ thị bfs
    public ArrayList<Integer> bfs(int i, ArrayList<Integer> bfsList) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<Integer>();

        // init
        visited[i] = true;
        queue.add(i); 

        while(!queue.isEmpty()) {
            int curVertex = queue.poll();
            bfsList.add(curVertex); // add to result

            // lấy tất cả các đỉnh kề với curVex
            List<Integer> neighbors = adjList.get(curVertex);
            for (Integer neighbor : neighbors) {
                // Nếu đỉnh kề với curVertex chưa được thăm
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return bfsList;
    }

    // 6. Tìm chu trình trên đồ thị vô hướng
    public boolean isCycle(int V, ArrayList<Integer> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(isCycleUtil(i, visited, -1)) {
                    return true;
                }
            }
            
        }
        return false;
    }

    // Kiểm tra xem đỉnh V có thuộc chu trình hay không
    private boolean isCycleUtil(int i, boolean[] visited, int parent) {
        visited[i] = true;

        List<Integer> neighbors = adjList.get(i);
        for (Integer neighbor: neighbors) {
            if(!visited[neighbor]) {
                if(isCycleUtil(neighbor, visited, parent)) {
                    return true;
                }
            } else if(neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    // 7. Đếm số đảo - số thành phần liên thông
    public int countConnectedComponents() {
        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfsUtil(i, visited);
                count++;
            }
            
        }
        return count;
    }
    
    // 11. Kiểm tra đường đi nối 2 điểm trong java
    private boolean findPathDFS(int v, int target, boolean[] visited) {
        visited[v] = true;

        // v là đích, trả về true
        if(v == target) {
            return true;
        }

        List<Integer> neighbors = new ArrayList<Integer>();
        for (Integer neighbor : neighbors) {
            if(!visited[neighbor]) {
                // Nếu có đường đi i--> target, trả về true
                if(findPathDFS(neighbor, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkPath(int u, int v) {
        boolean[] visited = new boolean[V];

        // duyệt đồ thì tử đỉnh u
        findPathDFS(u, v, visited);

        return visited[v]; // nếu đỉnh đã được thăm, tức có đường đi từ u --> v
    }

    // 13. Tim số mức của đồ thị, lưu đường đi vào pathList
    public int findLevel(int i, int destination, ArrayList<Integer> pathList) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<Integer>();
        int maxLevel = 0;

        // init
        visited[i] = true;
        queue.add(i); 

        while(!queue.isEmpty()) {
            int curVertex = queue.poll();
            pathList.add(curVertex); // add to result

            // lấy tất cả các đỉnh kề với curVex
            List<Integer> neighbors = adjList.get(curVertex);
            for (Integer neighbor : neighbors) {
                // Nếu đỉnh kề với curVertex chưa được thăm
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    maxLevel += 1;
                    queue.add(neighbor);
                }
            }
        }
        return maxLevel;
    }





}
