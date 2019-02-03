class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0, m = matrix.length, n = matrix[0].length;
        int[] h = new int[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    h[j]++;
                } else h[j] = 0;
                int height = h[j];
                for (int k = j-1; k >= 0; k--) {
                    if (h[k] == 0) break;
                    height = Math.min(height, h[k]);
                    int width = j-k+1;
                    max = Math.max(max, width*height);
                }
                max = Math.max(max, h[j]);
            }
        }
        return max;
    }`
}
