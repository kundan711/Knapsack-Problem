//Knapsack Problem: Kundan Chaudhary

import java.util.*;

public class knapsack {
		//Enter the input in the following format: Total-weight number-of-weight w1 w2 w3 ...
		// For example: 20 5 3 12 8 7 15
		public static Scanner s = new Scanner(System.in);
		public static int total = s.nextInt();
		public static int n = s.nextInt();
		public static int[] numArray =  new int[n];
		
		//Boolean to check if the number was used in the sum.
		//dimensions given in away such that the sum would never exceed it
		public static boolean f[][] = new boolean[(total*total)][n]; 
		
		public static void main(String[] args) {
			//Stores the input weights in an array
			for (int i = 0; i < n; i++) {
				numArray[i] = s.nextInt();
			}
			
			//Calls the method in which the sum is calculated using various inputs
			int S= KS(total, n, numArray);
			System.out.println("The weight retrieved from this data is: " + S);
			System.out.print("The weights used for the sum is: ");
			//Calls the method that prints the weights used to get total weight
			PrintOutput(S, n, numArray);
		}
		
		//Method to print the output of the program
		static void PrintOutput(int S, int n, int[] numArray) {
			//base case
			if (n==0) return;
			
			//Checks if the sum is always positive
			if((S-numArray[n-1]) >= 0 ) {
				//Checks if the weight was used in the sum
				if (f[S][n-1] == true ){
					//Prints the weight if used and subtracts the weight from the sum for recursion
					System.out.print(numArray[n-1] + " ");
					S -= numArray[n-1];
				}
			}
			//Calls the method again
			PrintOutput(S, n-1, numArray);
		}
		
		//Method to calculate the maximum sum from the weights given
		static int KS (int total, int n, int[] numArray) {
			//Base case
			if (total ==  0 || n == 0) {
				return 0;
			} //checks if the weight is greater than the required sum
			else if (numArray[n-1] > total) {
				return KS(total, n-1, numArray);
			} else {
				//Uses a weight to calculate the sum and calls the method
				int sum1 = numArray[n-1]+ KS(total-numArray[n-1],n-1,numArray);
				//Calls the method using the weight
				int sum2 = KS(total, n-1, numArray);
				//Stores "true" boolean for the weight with its index if used to calculate sum1
				f[sum1][n-1]=true;
				//returns the maximum sum retrieved from the weights
				return Math.max(sum1,sum2);
			}

		}

	}