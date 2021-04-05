package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KTransaction {
static int dp(int[]n,int k) {
	int dp[][]=new int[k+1][n.length];
	for (int i = 1; i <= k; i++) {
		int maxdiff=-n[0];
		for (int j = 1; j < n.length; j++) {
			dp[i][j]=Integer.max(dp[i][j-1], n[j]+maxdiff);
			maxdiff=Integer.max(maxdiff,dp[i-1][j]-n[j]);
			
		}
	}
	return dp[k][n.length-1];
}
public static void main(String[] args) {
		/*
		 * int a[]= {2,5,7,1,4,3,1,3}; System.out.println(dp(a,3));
		 */
		/*
		 * String[] str= {"apple","app"}; int a[]= {1,0,0,1,0,0,1,0};
		 * 
		 * 
		 * isAlienSorted(str, "abcdefghijklmnopqrstuvwxyz");
		 * System.out.println(prisonAfterNDays(a, 1000000000));
		 */
	int a[]= {2,3,1,1,2,4,2,0,1,1};
	minNoJump(a);
}
static void minNoJump(int[]g){
int []r=new int [g.length];
Arrays.fill(r, Integer.MAX_VALUE);
int []t=new int [g.length];
r[0]=0;
t[0]=-1;
for (int i = 1; i < g.length; i++) {
	for (int j = 0; j < i; j++) {
		if(i<=j+g[j]&&1+r[j]<r[i]) {
			r[i]=r[j]+1;
			t[i]=j;
		}
	}	
}
int idx=g.length-1;
while(idx!=-1) {
	System.out.println(idx);
	idx=t[idx];
}
System.out.println(r[g.length-1]);
}
static public int[] prisonAfterNDays(int[] cells, int n) {
	   Map<Integer,Integer>hm=new HashMap<>();
	        List<Integer>nhm=new ArrayList<>();
	        int num=0;
	    for(int i=0;i<8;i++){
	    	num<<=1;
	      num+=cells[i];  
	    }
	    for(int i=0;i<n;i++){
	        if(hm.get(num)==null){
	        int t=create(num);
	           hm.put(num,t);
	             nhm.add(num);
	            num=t;
	        }
	        else {
	           // num=hm.get(num);
	            int p=nhm.size();
	            int id=nhm.indexOf(num);
	            p=(p-id);
	           p=(n-i)%p;
	            num=nhm.get(id+p);
	            break;
	        }
	        
	    }
	    int[]res= new int[8];
	    	    for (int i = 7; i >= 0; i--) {
	    	        res[i] = num % 2;
	    	        num >>= 1;
	    	    }
	    	    return res;
	    
	}

	static int create(int mask) {
		int res= 0;
			    int last= mask % 2;
			    mask >>= 1;
			    for (int i= 1; i <= 6; i++) {
			        int next = mask / 2 % 2;
			        if( next != last) {
			            
			        } else {
			            res += 1 << i;
			        }
			        last = mask % 2;
			        mask /= 2;
			    }
			    return res;
	}


public static boolean isAlienSorted(String[] words, String order) {
    int []idx=new int[26];
    for(int i=0;i<26;i++){
        idx[order.charAt(i)-'a']=i;
    }
    Comparator<String> c=(a,b)->{
        int i=0,j=0;
        while(i<a.length()&&j<b.length()){
            
            if(a.charAt(i)== b.charAt(j)){
                i++;
                j++;
            }
            else{
            	return   idx[a.charAt(i)-'a']-idx[b.charAt(j)-'a'];
            }
            
        }
       
        return a.length()-b.length();
    };
    String[] w=new String[words.length];
    for(int i=0;i<words.length;i++) {
    	w[i]=words[i];
    }
    Arrays.sort(w,c);
    for(int i=0;i<words.length;i++) {
    	if(w[i]!=words[i])return false;
    }
    return true;
    }

public int minDistance(int[] houses, int k) {
    if(houses.length<2) return 0;
if(k>=houses.length) return 0;
    int [][]dp=new int[101][101];
Arrays.fill(dp,-1);
Arrays.sort(houses);
return helper(0, k, houses,dp);
}
int helper(int i,int k,int[]houses,int [][]dp){
    if(i>=houses.length)return 0;
    if(k==0){
        dp[i][k]=(int) 1e9;
        return dp[i][k];
    }
    int ans=(int) 1e9;
    int mid=0;
    dp[i][k]=0;
    for(int j=i;j<houses.length;j++){
        mid=(i+j)/2;
        int c=0;
        for(int l=i;l<j;l++){
            c+=Math.abs(houses[mid]-houses[l]);
            
        }
        ans=Math.min(ans,c+helper(j+1,k-1,houses,dp));
    }
    if(dp[i][k]==-1){
    dp[i][k]=ans;
    }
    return dp[i][k];
}
}
