package com.whw.zhaopin;

import java.util.ArrayList;
import java.util.List;

public class QiAnXin {
    public static List<ArrayList<Integer>> res = new ArrayList<>();

    public static int TeamNums (int[] height) {
        List<Integer> path = new ArrayList<>();
        backTracking(path,height);
        return res.size();
    }

    public static void backTracking(List path, int[] list){

    }
    public static void main(String[] args) {
//        int[] height ={1,5,3,2,4};
//        int count = 0;
//        for (int i = 0; i < height.length-2; i++) {
//            for (int j = i+1; j < height.length-1; j++) {
//                for (int k = j+1; k < height.length; k++) {
//                    int delta1 = height[j] - height[i];
//                    int delta2 = height[k] - height[j];
//                    if((delta1*delta2)>0) count++;
//                }
//            }
//        }
//        System.out.println(count);

        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(grid,i,j));
            }
        }

        System.out.println(res);

        }

    private static int dfs(int[][] grid, int x, int y) {
        if(x<0 || x>= grid.length || y<0|| y>=grid[0].length ||grid[x][y] ==0) return 0;
        int tmp = grid[x][y];
        grid[x][y] = 0;

        int up = dfs(grid, x, y-1);
        int down = dfs(grid, x, y+1);
        int left = dfs(grid, x-1, y);
        int right = dfs(grid, x+1, y);
        int max = Math.max(left,Math.max(right,Math.max(up,down)));

        grid[x][y] = tmp;
        return grid[x][y] + max;
    }

}


