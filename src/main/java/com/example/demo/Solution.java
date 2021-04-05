package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
	public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        Car[] cars = new Car[N];
        for (int i = 0; i < N; ++i)
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        Arrays.sort(cars, (a, b) -> Integer.compare(a.position, b.position));

        int ans = 0, t = N;
        while (--t > 0) {
            if (cars[t].time < cars[t-1].time) ans++; //if cars[t] arrives sooner, it can't be caught
            else cars[t-1] = cars[t]; //else, cars[t-1] arrives at same time as cars[t]
        }

        return ans + (t == 0 ? 1 : 0); //lone car is fleet (if it exists)
    }



	 public boolean canThreePartsEqualSum(int[] arr) {
	        int s=0;
	        HashSet<Integer>h=new HashSet<Integer>();
	for(int i=0;i<arr.length;i++){
	    s+=arr[i];
	    h.add(s);
	}
	        if(s%3!=0)return false;
	        if(h.contains(s/3)&&h.contains(2*s/3))return true;
	        return false;
	    }
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> l=new ArrayList<Integer>();
	       for(int i=0;i<nums.length;i++){
	    	   
	            int temp = Math.abs(nums[i]) - 1;
	                nums[temp] = 0 - nums[temp];
	                if(nums[temp]>0) {
	                	l.add(nums[temp]);
	                }
	            
	        } 
		/*
		 * List<Integer> l=new ArrayList<Integer>(); for(int i=0;i<nums.length;i++){
		 * if(nums[i]>0)l.add(i+1); }
		 */
	        return l;
	    }
    public int firstMissingPositive(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums.length || nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) != nums.length + 1) {
                int temp = Math.abs(nums[i]) - 1;
                nums[temp] = 0 - Math.abs(nums[temp]);
            } 
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    public static void main(String[] args) {
		Solution s=new Solution();
		//int a[]= {6,1,1,13,-1,0,-10,20};
		int a[]= {10,8,0,5,3};
		int b[]= {2,4,12,1,3};
		System.out.println(s.carFleet(12,a,b));
	}
}
class Car {
    int position;
    double time;
    Car(int p, double t) {
        position = p;
        time = t;
    }
}