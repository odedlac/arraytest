package arrayOperations;

import static org.junit.Assert.*;
import junit.framework.TestFailure;

import org.junit.Test;

public class ArrayOperationsTest {

	@Test
	public void testFill() {
		
		//make fail
		//int[] inputArray = {12,11,10,9,8,7,6,5,4,3,2,1};		
		//assertArrayEquals(inputArray, ArrayOperations.fill(12));	
		
		
		//should work
		int[] inputArray2 = {1,2,3,4,5,6,7,8,9,10,11,12};		
		assertArrayEquals(inputArray2, ArrayOperations.fill(12));	
		
		
	}

	@Test
	public void testReverse() {
		int[] inputArray = {1,2,3,4,5,6,7,8,9,10,11,12};
		int[] outputArray = {12,11,10,9,8,7,6,5,4,3,2,1};		
		assertArrayEquals(outputArray, ArrayOperations.reverse(inputArray));
		
		int[] inputArray1 = {12};
		int[] outputArray1 = {12};
		assertArrayEquals(outputArray1, ArrayOperations.reverse(inputArray1));
		
		/*
		int[] inputArray2;
		int[] outputArray2;
		assertArrayEquals(outputArray2, ArrayOperations.reverse(inputArray2));
		*/
		
		int[] inputArray3 = null;
		int[] outputArray3= null;
		assertArrayEquals(outputArray3, ArrayOperations.reverse(inputArray3));
		
		//make it fail
		//int[] inputArray4 = {1,2,3,4,5,6};
		//int[] outputArray4 = {12,11,10,9,8,7,6,5,4,3,2,1};		
		//assertArrayEquals(outputArray4, ArrayOperations.reverse(inputArray4));
		
	}

	@Test
	public void testRotateRight() {
		int[][] inputArray = { {1,2,3,4},
								{5,6,7,8},
								{9,10,11,12}};
		int[][] outputArray =  {{9,5,1},
								{10,6,2},
								{11,7,3},
								{12,8,4}};
		assertArrayEquals(outputArray, ArrayOperations.rotateRight(inputArray));
		
		int[][] inputArray1 = { {1,2,3,4},
								{5,6,7,8},
								{9,10,11,12},
								{13,14,15,16},
								{17,18,19,20}};

		int[][] outputArray1 =  {{17,13,9,5,1},
								{18,14,10,6,2},
								{19,15,11,7,3},
								{20,16,12,8,4}};
		assertArrayEquals(outputArray1, ArrayOperations.rotateRight(inputArray1));
		
		int[][] input1 = {{1}};
		int[][] output1 = {{1}};
		assertArrayEquals(output1, ArrayOperations.rotateRight(input1));
	}

	@Test
	public void testRotateLeft() {
		int[][] inputArray = { {1,2,3,4},
						{5,6,7,8},
						{9,10,11,12}};
		int[][] outputArray =  {{4,8,12},
						{3,7,11},
						{2,6,10},
						{1,5,9}};
		assertArrayEquals(outputArray, ArrayOperations.rotateLeft(inputArray));
	}

	@Test
	public void testTranspose() {
		int[][] inputArray = { {1,2,3,4},
						{5,6,7,8},
						{9,10,11,12}};
		int[][] outputArray =  {						
						{1,5,9},
						{2,6,10},
						{3,7,11},
						{4,8,12},
						};
		assertArrayEquals(outputArray, ArrayOperations.transpose(inputArray));

	}

	@Test
	public void testRavel() {
		int[] inputArray  = {1,2,3,4,5,6,7,8,9,10,11,12};		
		int[][] outputArray = { {1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}};
		assertArrayEquals(outputArray, ArrayOperations.ravel(inputArray,4));
	}

	@Test
	public void testUnravel() {
		fail("Not yet implemented");
	}

	@Test
	public void testReshape() {
		fail("Not yet implemented");
	}

	@Test
	public void testJoin() {
		fail("Not yet implemented");
	}

	@Test
	public void testToChars() {
		int[] input1 = {72,101,108,108,111};
		char[] output1 = {'H','e','l','l','o'};		
		assertArrayEquals(output1, ArrayOperations.toChars(input1));
	}

	@Test
	public void testToString() {		
		int[] input1  = {72,101,108,108,111};
		String output1 = "Hello";		
		assertEquals(output1, ArrayOperations.toString(input1));
		//input1  = null;
		//output1 = "";		
		assertEquals(output1, ArrayOperations.toString(input1));
		
	}
	@Test
	public void testToIntsCharArray() {
		char[] input1 = {'H','e','l','l','o'};		
		int[] output1 = {72,101,108,108,111};
		
		assertArrayEquals(output1, ArrayOperations.toInts(input1));
		
	}
	@Test
	public void testToIntsString() {
		String input1 = "Hello";		
		int[] output1 = {72,101,108,108,111};
		
		assertArrayEquals(output1, ArrayOperations.toInts(input1));
	}

}
