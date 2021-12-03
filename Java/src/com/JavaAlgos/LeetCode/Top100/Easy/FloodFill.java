package com.JavaAlgos.LeetCode.Top100.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FloodFill {
    /**
     * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
     * <p>
     * You are also given three integers sr, sc, and newColor. You should perform a flood fill on the
     * image starting from the pixel image[sr][sc].
     * <p>
     * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting
     * pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels
     * (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
     * <p>
     * Return the modified image after performing the flood fill.
     * <p>
     * Example 1:
     * <p>
     * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
     * Output: [[2,2,2],[2,2,0],[2,0,1]]
     * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels
     * connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with
     * the new color.
     * <p>
     * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
     * Example 2:
     * <p>
     * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
     * Output: [[2,2,2],[2,2,2]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * m == image.length
     * n == image[i].length
     * 1 <= m, n <= 50
     * 0 <= image[i][j], newColor < 216
     * 0 <= sr < m
     * 0 <= sc < n
     **/

    public class node {
        public int x;
        public int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        node newNode = new node(sr, sc);
        image[sr][sc] = newColor;
        HashMap<node, Boolean> visitedNode = new HashMap<>();
        visitedNode.put(newNode, true);
        List<node> queue = new ArrayList<>();
        floodFillHelper(image, visitedNode, queue, newColor);
        return image;
    }

    public List<node> getNeigbours(int x, int y, int maxX, int maxY) {
        List<node> temp = new ArrayList<>();
        if (x + 1 <= maxX - 1 && y + 1 <= maxY - 1) {
            temp.add(new node(x + 1, y + 1));
        }
        if (x - 1 >= 0 && y + 1 <= maxY - 1) {
            temp.add(new node(x - 1, y + 1));
        }
        if (y + 1 <= maxY) {
            temp.add(new node(x, y + 1));
        }
        if (x + 1 <= maxX) {
            temp.add(new node(x + 1, y));
        }
        return temp;
    }

    public void floodFillHelper(int[][] image, HashMap<node, Boolean> visited, List<node> queue, int newColor) {
        node curNode = queue.remove(0);
        image[curNode.x][curNode.y] = newColor;
        queue.addAll(getNeigbours(curNode.x, curNode.y, image[0].length, image.length));
        visited.put(curNode, true);

        for (int i = 0; i < queue.size(); i++) {
            node underReview = queue.get(i);
            if (!visited.containsKey(underReview)) {
                floodFillHelper(image, visited, queue, newColor);
            } else {
                queue.remove(i);
            }

        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r - 1, c, color, newColor);
            if (c >= 1) dfs(image, r, c - 1, color, newColor);
            if (r + 1 < image.length) dfs(image, r + 1, c, color, newColor);
            if (c + 1 < image[0].length) dfs(image, r, c + 1, color, newColor);
        }
    }


}
