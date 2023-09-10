package com.jiamao.ZS362;

import java.util.ArrayList;

public class ZS03 {


    public int minimumMoves(int[][] grid) {

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (grid[i][j]==0){
                    input.add(new int[]{i,j});
                }else{
                    for (int k = 0; k < grid[i][j] - 1; k++)
                        output.add(new int[]{i,j});
                }
            }
        int[] tag=new int[output.size()];
        int idx=0;
        dfs(idx,tag,0);
        return res;
    }
    ArrayList<int[]> input = new ArrayList<>();
    ArrayList<int[]> output = new ArrayList<>();
    int res=Integer.MAX_VALUE;
    void dfs(int idx,int[] tag,int n){
        if (idx==tag.length){
            res=Math.min(n,res);
            return;
        }
        for (int i = 0; i < tag.length; i++) {
            if (tag[i]==0){
                tag[i]=1;
                dfs(idx+1,tag,n+count(output.get(idx),input.get(i)));
                tag[i]=0;
            }
        }
    }

    int count(int[] a,int[] b){
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }
}
