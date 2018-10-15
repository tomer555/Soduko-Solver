public class Task9Decode {
	//Editor:Tomer Levy
	//ID:308427384
	//Last Edit: 30/11/2017
	/*This functions checks what is the value of a specific cell
	 * in the board that satisfy all conditions that we sent to the SAT
	  * in Task8Encode. if there is no satisfaction the code will show "exception" */
	public static int cellValue(int[][][] map, int i, int j, boolean[] assignment) {
		int n=map.length;
		int cellValue=-1;
		for (int k=0;k<n;k=k+1) {
			if (assignment[Task7Map.varName(i, j, k, n)])
				cellValue = k + 1;
		}
		if(cellValue==-1)
			throw new IllegalArgumentException("exception");


		return cellValue;
	}
	/*This function below calls the cellValue for each cell in the board
	 to find out what value satisfy all the conditions of sudoko board.
	  and finally returns the complete board*/
	public static int[][] mapToBoard(int[][][] map, int n, boolean[] assignment) {
		int [][]mapToBoard=new int[n][n];
		for(int i=0;i<n;i=i+1)
			for(int j=0;j<n;j=j+1){
				mapToBoard[i][j]=cellValue(map,i,j,assignment);
			}
		return mapToBoard;
	}
}
