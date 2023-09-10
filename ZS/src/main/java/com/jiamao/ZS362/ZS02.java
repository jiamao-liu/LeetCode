package com.jiamao.ZS362;

public class ZS02 {

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int x=Math.abs(fx-sx);
        int y=Math.abs(fy-sy);
        if (x==y&&x==0&&t==1)
            return false;
        return Math.max(x,y)<=t;
    }
}
