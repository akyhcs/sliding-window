https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1

// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    int K = Integer.parseInt(br.readLine());
		    
		    Complete obj = new Complete();
		    int ans = obj.minSwap(arr, sizeOfArray, K);
		    System.out.println(ans);
		}
	}
}
// } Driver Code Ends


//User function Template for Java



class Complete{
    
   
    // Function for finding maximum and value pair
    public static int minSwap (int a[], int n, int k) {
        int window = 0;
        int countTotalNumGreaterThanKWindow = 0;
        for(int  i = 0 ;i<n;i++)
        {
            if(a[i]<=k) window = window + 1;
        }
        
        for(int  i =0 ;i<window;i++)
        {
            if(a[i]>k) countTotalNumGreaterThanKWindow = countTotalNumGreaterThanKWindow+1;
        }
        int minSwapCount = countTotalNumGreaterThanKWindow ;
        for(int i=0,j=window;j<n;i++,j++)
        {
            if(a[i]>k) 
                countTotalNumGreaterThanKWindow = countTotalNumGreaterThanKWindow-1;
            
            if(a[j]>k)
                countTotalNumGreaterThanKWindow = countTotalNumGreaterThanKWindow+1;
            minSwapCount = minSwapCount < countTotalNumGreaterThanKWindow ? minSwapCount : countTotalNumGreaterThanKWindow;
        }
        return minSwapCount;
    }
    
    
}
