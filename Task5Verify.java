public class Task5Verify {
	//Editor:Tomer Levy
	//ID:308427384
	//Last Edit: 30/11/2017
    public static boolean isSolution(int sqrtN, int[][] hints, int[][] board) {
        int n=sqrtN*sqrtN;
        //basic condition to check if board is valid and the integers inside are between the legal values
        if (n!=board.length | !TasksArrays.isMatrixBetween(board,n,1,n))
            throw new NullPointerException("exception");
        boolean isSolution=true;
        int [][]columnMatrix=TasksArrays.columns(board);
        int [][]blocksMatrix=TasksArrays.blocks(board,sqrtN);
        //this code below checks if all hints are in their specific location in the board
        for (int i =0; i<hints.length &isSolution; i=i+1){
                if (board[hints[i][0]][hints[i][1]] != hints[i][2])
                    isSolution = false;
        }
        /*this code below checks all other condition to make the sukodo solution valid:
         * values of normal matrix,column matrix,block matrix are all different from one another, */
            for (int i=0; i<board.length & isSolution;i=i+1) {
            if (!TasksArrays.isAllDiff(board[i])|!TasksArrays.isAllDiff(columnMatrix[i])|!TasksArrays.isAllDiff(blocksMatrix[i]))
                isSolution = false;
            }
        return isSolution;
    }
}
