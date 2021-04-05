package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	 static public int findJudge(int N, int[][] trust) {
	        int []a=new int[N+1];
	        for(int i=0;i<trust.length;i++){
	            a[trust[i][1]]++;
	            a[trust[i][0]]--;
	        }
	         for(int i=1;i<a.length;i++){
	             if(a[i]==N-1)return i;
	         }
	        return -1;
	    }
	 
	static public List<Integer> largestDivisibleSubset(int[] nums) {
	       if(nums.length==1){
	           List<Integer>lst=new ArrayList<>();
	              lst.add(nums[0]);
	              return lst;
	          }
	   		Arrays.sort(nums);
	   		int[]d=new int[nums.length];
	   		int[]p=new int[nums.length];
	          Arrays.fill(p,-1);
	   		int mi=0;
	   		int mx=-1;
	   		for(int i=1;i<nums.length;i++){
	   			for(int j=0;j<i;j++){
	   				if(nums[i]%nums[j]==0&&d[i]<1+d[j]){
	   					d[i]=1+d[j];
	   					p[i]=j;
	   					if(d[i]>mx){
	   						mx=d[i];
	   						mi=i;
	   					}
	   				} 

	   			}   
	   		}
	   		List<Integer>lst=new ArrayList<>();
	          if(mi==-1)return lst;
	   		//lst.add(nums[mi]);
	   		while(mi!=-1){
	   			lst.add(nums[mi]);
	   			mi=p[mi];
	   			
	   			

	   		}
	   		return lst;
	   	}
	public static void main(String[] args) {
		int[]f= {3,4,16,8};
		largestDivisibleSubset(f);
		int[][]a= {{1,3},{2,3}};
		System.out.println(findJudge(3, a));
	}
}
