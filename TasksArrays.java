public class TasksArrays {
	//Editor:Tomer Levy
	//ID:308427384
	//Last Edit: 30/11/2017
	public static boolean isAllDiff(int[] array) {
	    //basic condition if array is empty
		if (array==null)
			throw new NullPointerException("array is null");
		boolean result=true;
        int [] stack =new int [array.length];
        int counter=0;
        /*this code below inserts each number into new array(stack)
         and checks if the number already exists*/
        for (int i=0;i<array.length & result;i=i+1){
            stack[i]=array[i];

            for(int j=0;j<counter &result;j=j+1){
                if (stack[i]==stack[j])
                    result=false;
            }
            counter=counter+1;
        }
        return result;	
	}
	
	public static boolean isMatrixBetween(int[][] matrix, int n, int min, int max) {
        boolean result = true;
        //basic condition if matrix is empty
	    if (matrix==null)
	        result=false;
        else {
            /*this code below checks every number in the matrix
            to see if its above or below the min and max values*/
            for (int i=0;i<matrix.length & result;i=i+1){
                if (matrix[i]!=null && matrix[i].length==n) {
                    for (int j = 0; j < matrix[i].length & result;j=j+1) {
                        if (matrix[i][j] < min | matrix[i][j] > max)
                            result = false;
                    }
                }
                else
                    result=false;
            }
        }
        return result;
		
    }
		
	
	
	public static int[][] columns (int[][] matrix) {
	    /*this code below takes every number in the matrix and
	     switch it with the correspond number: row to column and column to row
	     by switching the i,j positions*/
		int[][] columns = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i = i + 1)
            for (int j = 0; j < matrix[i].length; j = j + 1) {
                int temp = columns[i][j];
                columns[i][j] = matrix[j][i];
            }
        return columns;
    }

	public static int[][] blocks(int[][] matrix, int sqrtN) {
	    /*this code below take a matrix and set it up to blocks using
	    3 extra variables that make sure to skip rows,columns
	    and a specific cell in the matrix */
		int[][] blocks = new int[matrix.length][matrix.length];
        int rowJump=0;
        int spot=0;
        int checker=0;
        for (int i = 0; i < matrix.length; i = i + 1) {
            if (i%sqrtN==0 & i!=0) {
                rowJump = i;
                spot = 0;
                checker=checker+1;
            }
            else {
                rowJump=checker*sqrtN;
            }
            for (int j = 0; j < matrix.length; j = j + 1) {
                if (j % sqrtN == 0 & j != 0) {
                    rowJump = rowJump + 1;
                    spot=spot-sqrtN;
                }
                blocks[rowJump][spot] = matrix[i][j];
                spot=spot+1;
            }
        }
        return blocks;
    }

		
	
}
