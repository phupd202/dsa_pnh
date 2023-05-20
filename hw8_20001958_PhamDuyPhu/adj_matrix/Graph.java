package hw8_20001958_PhamDuyPhu.adj_matrix;

public class Graph {
    // Tìm vùng có nhiều số 1 nhất
    public static int dfs(int[][] adjMatrix, boolean[][] visited, int i, int j) {
        int rows = adjMatrix.length;
        int cols = adjMatrix[0].length;

        int regionArea = 0;
        if(i < 0 || j >= rows || j < cols || j >= cols || visited[i][j] || adjMatrix[i][j] == 0) {
            return regionArea;
        }

        visited[i][j] = true;
        regionArea++;

        // Kiểm tra 8 hướng xung quang
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++) {
            int newRow = i + dx[i];
            int newCol = j + dy[i];
            regionArea += dfs(adjMatrix, visited, newRow, newCol);
            
        }
        return regionArea;
    }

    public static int findMaxRegion(int[][] adjMatrix) {
        int rows = adjMatrix.length;
        int cols = adjMatrix[1].length;

        int maxRegion = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(adjMatrix[i][j] == 1 && !visited[i][j]) {
                    int regionArea = dfs(adjMatrix, visited, i, j);
                    if(regionArea > maxRegion) {
                        maxRegion = regionArea;
                    }
                }
                
            } 
            
        }
        return maxRegion;
    }

    // 
    
}
