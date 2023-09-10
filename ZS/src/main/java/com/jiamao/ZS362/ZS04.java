package com.jiamao.ZS362;

import java.util.HashMap;

public class ZS04 {
    public static void main(String[] args) {
        System.out.println(new ZS04().numberOfWays("abcd","cdab",2));
    }
    int MOD=1000000007;
    public int numberOfWays(String s, String t, long k) {
        len=s.length();
        for (int i = 1; i < s.length(); i++) {
            if(s.length()%i==0){
                boolean tag=true;
                for (int j = 1; j < s.length() / i; j++) {
                    if (!s.substring(j*i,j*(i+1)).equals(s.substring(0,j))){
                        tag=false;
                        break;
                    }
                }
                if (tag){
                    eqTime=s.length()/i;
                    break;
                }
            }
        }
        return (int)(pow(k,s.equals(t)));


    }

    HashMap<String, Long> hashMap = new HashMap<>();
    int eqTime=1;
    int len=0;
    long pow(long k,boolean en){ //
        if (hashMap.containsKey(k+","+en))
            return hashMap.get(k+","+en);
        if (en){
            if (k==1)
                return eqTime-1;
            long r=((pow(k/2,true)*(eqTime-1)+pow(k/2,false)*(len-eqTime))*
                    (pow((k+1)/2,true)*(eqTime-1)+pow((k+1)/2,false)*(len-eqTime)))%MOD;
            hashMap.put(k+","+en,r);
            return r;

        }else{
            if (k==1)
                return eqTime;
            long r= ((pow(k/2,true)*(eqTime)+pow(k/2,false)*(len-eqTime-1))*
                    (pow((k+1)/2,true)*(eqTime)+pow((k+1)/2,false)*(len-eqTime-1)))%MOD;
            hashMap.put(k+","+en,r);
            return r;
        }

    }
}
