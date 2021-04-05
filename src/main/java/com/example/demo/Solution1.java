package com.example.demo;

public class Solution1 {
	public static void main(String[] args) {
		Solution1 s=new Solution1();
		char[][]c = {{'.','#'},
                {'#','#'},
                {'#','.'},
                {'#','#'},
                {'.','#'}};
		//s.maxStudents(c);
		int[]A= {2,4,6,8,10};
		s.numberOfArithmeticSlices(A);
				
	}
    public int maxStudents(char[][] s) {
        int m=s.length;
        int n=s[0].length;
       int dp[]=new int[m*n];
        return dp(0,0,0,m,n,s,dp);
    }
    int dp(int pos,int pre,int cur,int m,int n,char[][] s, int dp[]){
    	System.out.println(pos+":"+pre+":"+cur);
    	//if(dp[pos]!=-1)return dp[pos]
        if(pos==m*n)return 0;
        int i=pos/n;
        int j=pos%n;
        if(j==0){
            pre=cur;
            cur=0;
        }
        int ans=0;
        ans=dp(pos+1,pre,cur,m,n,s,dp);
        if(s[i][j]=='.'){
            boolean tl=true,l=true,tr=true,r=true;
            if(j!=0){
                int t=1<<(j-1);
                l=(cur & t)==0;
                if(i>0)
                    tl=(pre & t)==0;
            }
            if(j!=n-1){
                int t=1<<(j+1);
                tr=(pre & t)==0;
            }
            if(tl && l&&tr&&r){
                int t=1<<j;
                t=cur|t;
                ans=Integer.max(ans,dp(pos+1,pre,t,m,n,s,dp)+1);
                
            }
        }
        
        return ans;
    }
    
    public int numberOfArithmeticSlices(int[] A) {
        int k=0;
        for(int i=0;i<A.length-1;i++){
            int cnt=0;
            //int l=1;
            int diff=A[i]-A[i+1];
           for(int j=i+1;j<A.length;j++){
            if(A[j-1]-A[j]==diff){
                cnt++;
                if(cnt>=2)k++;
            }
        } 
          
        }
        return k;
    }
   
}