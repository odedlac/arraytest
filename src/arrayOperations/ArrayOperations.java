package arrayOperations;

public class ArrayOperations {

		
	public static int[] fill(int length) {
		
		int[] arrayOfInts = new int[length];
		for (int i=0;i<length;i++){
			arrayOfInts[i] = i+1;			
		}
		return arrayOfInts;
	}
	public static int[] reverse(int[] array){
		
		if (array == null)
		{
			return null;			
		}
		
		int[] arrayOfInts = new int[array.length];
		int arrayOfIntsIndex = 0;
		
		for (int i=array.length-1;i>-1;i--){
			arrayOfInts[arrayOfIntsIndex] = array[i];
			arrayOfIntsIndex++;
		}
		return arrayOfInts;
	}
	public static int[][] rotateRight(int[][] array){
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
	
	public static int[][] transpose(int[][] array){	
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
	public static int[][] ravel(int[] array, int n){
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
	public static int[] unravel(int[][] array){
		int[] unraveledArray = new int[0];
		return unraveledArray;
	}
	public static int[][] reshape(int[][] array, int n){
		/*int inputArrayRowCount = array.length;
		int inputArrayColCount = array[0].length;
		int arrayIndexCount=inputArrayRowCount*inputArrayColCount;
		int newArrayRowCount= arrayIndexCount/n;
		int[][] reshapedArray = new int [newArrayRowCount][n];
		if (arrayIndexCount%n!=0)
			throw new IllegalArgumentException("Array will not fit into shape requested!");	
		
		int inputArrayPosn = 0;
		for(int row=0;row<newArrayRowCount;row++){
			
			for(int col=0;col<n;col++){
				reshapedArray[]
			}
		}
		*/
		int[][] reshapedArray = new int[0][0];
		return reshapedArray;		
	}
	public static int[][] join(int[][] array1, int[][] array2){
		int[][] joinedArray = new int[0][0];
		return joinedArray;			
	}
	public static char[] toChars(int[] array){
		char[] resultArray = new char[array.length];					
				
		for(int posn=0;posn<array.length;posn++)
			resultArray[posn] = (char) array[posn];						
		
		return resultArray;
	}
	public static String toString(int[] array){
		char[] resultArray = toChars(array);		
		String result = String.valueOf(resultArray);
		return result; 		
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

}
