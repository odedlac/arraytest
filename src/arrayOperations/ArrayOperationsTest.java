package arrayOperations;

import static org.junit.Assert.*;

import javax.xml.ws.ServiceMode;

import junit.framework.TestFailure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * software and programming II assignment
 * by student 102410921
 * november 2011
 * Junit tests
 */
public class ArrayOperationsTest {
	
	private int[] oneDArrayInSequence;
	private int[] oneDArrayOutSequence;
	private int[] oneDArrayReverseSequence;
	private int[][] fourByThreeArray;
	private int[] emptyOneDArray;
	private int[] charCodesArray;
	private char[] charArray;
	private String helloString;
	
	@Before
	public void setUpTestThatFillWillPass()
	{		 
		int[] oneDArrayInSequenceForSetup = {1,2,3,4,5,6,7,8,9,10,11,12};
		oneDArrayInSequence = oneDArrayInSequenceForSetup;
	}
	@Test
	public void testThatFillWillPass() {
		assertArrayEquals(oneDArrayInSequence, ArrayOperations.fill(12));
	}
	@After
	public void tearDownThatFillWillPass()
	{
		oneDArrayInSequence = null;
	}
	
	@Before
	public void setUpTestThatFillWillPassWithEmpty()
	{		 
		int[] emptyOneDArrayForSetup = {};
		emptyOneDArray = emptyOneDArrayForSetup;
	}
	@Test(expected=IllegalArgumentException.class)
	public void testThatFillWillPassWithEmpty() {	
		assertArrayEquals(emptyOneDArray, ArrayOperations.fill(-1));		
	}
	@After
	public void tearDownThatFillWillPassWithEmpty()
	{
		//nothing to do
	}
	
	@Before
	public void setUpTestFillFail() {
		int[] setUpOneDArrayOutSequence = {12,1,10,9,8,7,6,5,4,3,2,1};		
		oneDArrayOutSequence = setUpOneDArrayOutSequence;
	}
	@Test(expected=AssertionError.class)
	public void testFillFail() {	
		assertArrayEquals(oneDArrayOutSequence, ArrayOperations.fill(12));					
	}
	@After
	public void tearDownTestFillFail()
	{
		//nothing to do
	}	
	@Before
	public void setUpTestReverse() {
		int[] setUpOneDArrayReverseSequence = {12,11,10,9,8,7,6,5,4,3,2,1};	
		oneDArrayReverseSequence = setUpOneDArrayReverseSequence;
	}
	@Test
	public void testReverse() {	
		assertArrayEquals(oneDArrayReverseSequence, ArrayOperations.reverse(oneDArrayInSequence));

		int[] inputArray1 = {12};
		assertArrayEquals(inputArray1, ArrayOperations.reverse(inputArray1));

		int[] inputArray3 = null;
		int[] outputArray3= null;
		assertArrayEquals(outputArray3, ArrayOperations.reverse(inputArray3));
	}
	@After
	public void tearDownTestReverse() {
		//nothing to do
	}

	
	@Before
	public void setUpTestRotateRight() {
		int[][] setUpfourByThreeArray = { 	{1,2,3,4},
											{5,6,7,8},
											{9,10,11,12}};
		fourByThreeArray = setUpfourByThreeArray;
	}
	@Test
	public void testRotateRight() {

		int[][] outputArray1 =  {{9,5,1},
				{10,6,2},
				{11,7,3},
				{12,8,4}};
		assertArrayEquals(outputArray1, ArrayOperations.rotateRight(fourByThreeArray));

		int[][] inputArray2 = { {1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16},
				{17,18,19,20}};
		int[][] outputArray2 =  {{17,13,9,5,1},
				{18,14,10,6,2},
				{19,15,11,7,3},
				{20,16,12,8,4}};
		assertArrayEquals(outputArray2, ArrayOperations.rotateRight(inputArray2));

		int[][] inputArray3 = {{1}};
		assertArrayEquals(inputArray3, ArrayOperations.rotateRight(inputArray3));

		int[][] inputArray4 = null;	
		assertArrayEquals(inputArray4, ArrayOperations.rotateRight(inputArray4));

	}
	@Test
	public void testRotateLeft() {
		int[][] outputArray1 =  {{4,8,12},
				{3,7,11},
				{2,6,10},
				{1,5,9}};
		assertArrayEquals(outputArray1, ArrayOperations.rotateLeft(fourByThreeArray));

		int[][] inputArray2 = {{1}};
		assertArrayEquals(inputArray2, ArrayOperations.rotateRight(inputArray2));

		int[][] inputArray3 = null;
		assertArrayEquals(inputArray3, ArrayOperations.rotateRight(inputArray3));

	}
	@Test
	public void testTranspose() {
		int[][] outputArray =  {						
				{1,5,9},
				{2,6,10},
				{3,7,11},
				{4,8,12},
		};
		assertArrayEquals(outputArray, ArrayOperations.transpose(fourByThreeArray));

		int[][] inputArray2 = {{1}};
		assertArrayEquals(inputArray2, ArrayOperations.transpose(inputArray2));

		int[][] inputArray3 = null;
		assertArrayEquals(inputArray3, ArrayOperations.transpose(inputArray3));

	}

	@Test
	public void testRavel() {
		int[] inputArray  = {1,2,3,4,5,6,7,8,9,10,11,12};		
		assertArrayEquals(fourByThreeArray, ArrayOperations.ravel(inputArray,4));

		int[] inputArray2 = {};
		int[][] outputArray2 = {{}};
		assertArrayEquals(outputArray2, ArrayOperations.ravel(inputArray2,0));

		int[] inputArray3 = null;
		int[][] outputArray3 = null;
		assertArrayEquals(outputArray3, ArrayOperations.ravel(inputArray3,0));

	}

	@Test
	public void testUnravelPass() {
		int[] outputArray  = {1,2,3,4,5,6,7,8,9,10,11,12};		
		assertArrayEquals(outputArray, ArrayOperations.unravel(fourByThreeArray));

		int[][] inputArray2 = {{}};
		int[] outputArray2 = {};
		assertArrayEquals(outputArray2, ArrayOperations.unravel(inputArray2)); ///error

		int[][] inputArray3 = null;
		int[] outputArray3 = null;
		assertArrayEquals(outputArray3, ArrayOperations.unravel(inputArray3));	///error

	}
	@Test(expected=AssertionError.class)
	public void testUnravelFail() {
		int[][] inputArray = { {1,2,3,5},
				{5,6,7,8},
				{9,10,11,12}};
		int[] outputArray  = {1,2,3,4,5,6,7,8,9,10,11,12};		

		assertArrayEquals(outputArray, ArrayOperations.unravel(inputArray));
	}
	@Test
	public void testReshape() {
		int[][] outputArray  = {{1,2,3,4,5,6},{7,8,9,10,11,12}};		
		assertArrayEquals(outputArray, ArrayOperations.reshape(fourByThreeArray, 6));
	}

	@Test
	public void testJoinPass() {

		int[][] inputArray2 =  {{1,5,9},
				{2,6,10},
				{3,7,11}};
		int[][] outputArray1 =  { {1,2,3,4,1,5,9},
				{5,6,7,8,2,6,10},
				{9,10,11,12,3,7,11}};		
		assertArrayEquals(outputArray1, ArrayOperations.join(fourByThreeArray, inputArray2));
	}
	@Test	
	public void testJoinPassEmpty() {
		int[][] inputArray1 = { {},
				{},
				{}};
		int[][] inputArray2 =  {{},
				{},
				{}};
		int[][] outputArray1 =  { {},
				{},
				{}};		
		assertArrayEquals(outputArray1, ArrayOperations.join(inputArray1, inputArray2));
	}
	@Test		
	public void testJoinPassNull() {
		int[][] inputArray1 = null;	
		assertArrayEquals(inputArray1, ArrayOperations.join(inputArray1, inputArray1));
	}	

	@Test(expected=IllegalArgumentException.class)
	public void testJoinFail() {
		int[][] inputArray2 =  {{1,5,9},
				{2,6,10}};
		int[][] outputArray1 =  { 	{1, 2, 3, 4,1,5, 9},
				{5, 6, 7, 8,2,6,10},
				{9,10,11,12,3,7,11} };		
		assertArrayEquals(outputArray1, ArrayOperations.join(fourByThreeArray, inputArray2));
	}	
	@Before
	public void setUpTestToChars() {
		int[] input1 = {72,101,108,108,111};
		char[] output1 = {'H','e','l','l','o'};	
		charArray = output1;
		charCodesArray = input1;
	}
	@Test
	public void testToChars() {	
		assertArrayEquals(charArray, ArrayOperations.toChars(charCodesArray));
	}
	@After
	public void tearDownTestToChars() {			
		//do nothing
	}

	@Before
	public void setUpTestToStringPass() {		
		helloString = "Hello";	
	}
	@Test
	public void testToStringPass() {				
		assertEquals(helloString, ArrayOperations.toString(charCodesArray));		
	}
	@After
	public void tearDownTestToStringPass() {		
		//do nothing
	}
	@Test
	public void testToStringFail() {		
		int[] input1  = null;	
		assertEquals(input1, ArrayOperations.toString(input1));		
	}	
	@Test
	public void testToIntsCharArray() {	
		assertArrayEquals(charCodesArray, ArrayOperations.toInts(charArray));		
	}
	@Test
	public void testToIntsString() {	
		assertArrayEquals(charCodesArray, ArrayOperations.toInts(helloString));
	}

}
