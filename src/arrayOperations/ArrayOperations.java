package arrayOperations;
import java.util.*;

/*
 * software and programming II assignment
 * by student 102410921
 * november 2011
 * the code
 */
public class ArrayOperations {

	//based on http://download.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html tutorial
	private static int[] concatRow(int[] first, int[] second) {
		int[] result = concatRow(first,second,0);
		return result;
	}
	
	private static int[] concatRow(int[] first, int[] second, int srcPos) {
		int[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, srcPos, result, first.length, second.length);
		return result;
	}
	
	public static int[] fill(int length)  {
		
		if (length<1) {
			throw new IllegalArgumentException("this is crazy, are you mad array is zero or minus?!?");
		}
		
		
		int[] arrayOfInts = new int[length];
		for (int i=0;i<length;i++){
			arrayOfInts[i] = i+1;			
		}
		return arrayOfInts;
	}

	public static int[][] join(int[][] array1, int[][] array2){

		if (array1==null || array2==null)
			return null;

		int inputArray1RowCount = array1.length;
		int inputArray2RowCount = array2.length;
		int newArrayWidth = array1[0].length+array2[0].length;
		if (inputArray1RowCount!=inputArray2RowCount) {
			throw new IllegalArgumentException("row counts of each array need to be similar!");		
		}
		int[][] joinedArray = new int[inputArray1RowCount][newArrayWidth];		

		for(int row=0;row<inputArray1RowCount;row++){			
			joinedArray[row] = concatRow(array1[row],array2[row]);
		}

		return joinedArray;			
	}

	public static int[][] ravel(int[] array, int n){

		if (array==null)
			return null;

		if (array.length<1)
		{
			int[][] emptyOutputArray = {{}};
			return emptyOutputArray;
		}		

		int inputArrayLength = array.length;
		int newRowCount = inputArrayLength/n;
		int[][] raveledArray = new int [newRowCount][n];
		if (inputArrayLength%n!=0)
			throw new IllegalArgumentException("length of the input array is not evenly divisible by n!");		
		int inputArrayPosn = 0;

		for(int row=0;row<newRowCount;row++){			
			for(int col=0;col<n;col++){				
				raveledArray[row][col]=array[inputArrayPosn];
				inputArrayPosn++;										
			}			
		}				
		return raveledArray;
	}
	
	public static int[][] reshape(int[][] array, int n){
		int inputArrayRowCount = array.length;
		int inputArrayColCount = array[0].length;
		int inputArraySize = inputArrayRowCount*inputArrayColCount;
		if (inputArraySize%n != 0)
			throw new IllegalArgumentException("Rows and columns of supplied array not evenly divisible by "+n);

		int outputArrayRowCount = inputArraySize/n;
		int outputArrayColCount = n;
		int[][] outputArray = new int[outputArrayRowCount][outputArrayColCount];
		int outputArrayPos = 0;
		int outputArrayRowPos = 0;

		for(int row=0;row<inputArrayRowCount;row++){			
			for(int col=0;col<inputArrayColCount;col++){				
				if(outputArrayPos<outputArrayColCount){
					outputArray[outputArrayRowPos][outputArrayPos]=array[row][col];
					outputArrayPos++;
				}else{
					outputArrayRowPos++;
					outputArrayPos=0;
					outputArray[outputArrayRowPos][outputArrayPos]=array[row][col];
					outputArrayPos++;
				}
			}			
		}

		return outputArray;							
	}

	public static int[] reverse(int[] array){

		if (array==null)
			return null;

		int[] arrayOfInts = new int[array.length];
		int arrayOfIntsIndex = 0;

		for (int i=array.length-1;i>-1;i--){
			arrayOfInts[arrayOfIntsIndex] = array[i];
			arrayOfIntsIndex++;
		}
		return arrayOfInts;
	}

	public static int[][] rotateLeft(int[][] array){
		int[][] rotatedArray = array;		
		int iteration = 1;

		//equivalent to rotating right three times
		while (iteration<4)
		{
			rotatedArray = rotateRight(rotatedArray);	
			iteration++;
		}				
		return rotatedArray;
	}
	
	public static int[][] rotateRight(int[][] array){

		if (array==null)
			return null;

		int rowCount = array.length;
		int colCount = array[0].length;
		int newArrayColCount =rowCount-1;

		int[][] rotatedArray = new int[colCount][rowCount]; 	
		int arrayCol = 0;

		while (arrayCol<colCount)
		{			
			int rotatedArrayColPosn = newArrayColCount;			
			for (int i=0;i<rowCount;i++){			
				rotatedArray [arrayCol][rotatedArrayColPosn]= array[i][arrayCol];				
				rotatedArrayColPosn --;
			}			
			arrayCol++;			
		}		
		return rotatedArray;
	}
	
	public static char[] toChars(int[] array){
		char[] resultArray = new char[array.length];					

		for(int posn=0;posn<array.length;posn++)
			resultArray[posn] = (char) array[posn];						

		return resultArray;
	}
	
	public static int[] toInts(char[] array){
		int toIntsArrayLength = array.length;
		int[] toIntsArray = new int[toIntsArrayLength];		

		for(int posn=0;posn<toIntsArrayLength;posn++){
			toIntsArray[posn] = (int) array[posn];
		}
		return toIntsArray;
	}
	
	public static int[] toInts(String string){		
		char[] charArray = string.toCharArray();
		int[] toIntsArray = toInts(charArray);

		return toIntsArray;
	}
	
	public static String toString(int[] array){
		if (array==null)
			return null;
		char[] resultArray = toChars(array);		
		String result = String.valueOf(resultArray);
		return result; 		
	}

	public static int[][] transpose(int[][] array){	

		if (array==null)
			return null;

		int inputArrayRowCount = array.length;
		int inputArrayColCount = array[0].length;
		int[][] transposedArray = new int[inputArrayColCount][inputArrayRowCount];

		for(int row=0; row<inputArrayRowCount;row++) {
			for(int col=0; col<inputArrayColCount;col++) {
				transposedArray[col][row] = array[row][col]; //new array swap row and column for column and row
			}			
		}		
		return transposedArray;

	}

	public static int[] unravel(int[][] array){

		if (array==null)
			return null;

		try {
			int inputArrayRowCount = array.length;
			int inputArrayColCount = array[0].length;
			int inputArraySize = inputArrayRowCount*inputArrayColCount;
			int[] outputArray = reshape(array,inputArraySize)[0];
			return outputArray;
		}
		catch(ArithmeticException aex)
		{
			int[] emptyOutputArray = {};
			return emptyOutputArray;
		}

	}

}
