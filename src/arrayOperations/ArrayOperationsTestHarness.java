package arrayOperations;

import static org.junit.Assert.assertEquals;

public class ArrayOperationsTestHarness {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.print("starting....");

		/*
		int[] inputArray = {1,2,3,4,5,6,7,8,9,10,11,12};
		int[] outputArray = {12,11,10,9,8,7,6,5,4,3,2,1};		
		int[] inputArray = null;
			
		System.out.print(ArrayOperations.reverse(inputArray));
		System.out.print(ArrayOperations.reverse(inputArray));
		*/
		
		//test rotateright
		/*
		int[][] inputArray = { 	{1,2,3,4},
								{5,6,7,8},
								{9,10,11,12}	};
		int[][] outputArray = {	{9,5,1},
								{10,6,2},
								{11,7,3},
								{12,8,4}	};
		int[][] resultArray = ArrayOperations.rotateRight(inputArray);
		
		int[][] inputArray1 = {{1}};
		int[][] resultArray1 = ArrayOperations.rotateRight(inputArray1);
		*/
		
		/*
		int[][] inputArray = { {1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}};

		int [][] outputArray = ArrayOperations.rotateLeft(inputArray);*/
		
		int[] input1  = {72,101,108,108,111};
		//String output1 = "Hello";		
		System.out.print(ArrayOperations.toString(input1));
		
		
		System.out.print("done...");
				

		

	}

}
