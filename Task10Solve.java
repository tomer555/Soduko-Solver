
public class Task10Solve {
	//Editor:Tomer Levy
	//ID:308427384
	//Last Edit: 30/11/2017
	public static int[][] solve(int sqrtN, int[][] hints) {
		int n = sqrtN * sqrtN;
		int powerThree = n * n * n;
		int[][] board = new int[n][n];//creating new board
		int[][][] map = Task7Map.varsMap(n);//creating map matrix
		SATSolver.init(powerThree);//initialize the SAT with the given number power by 3
		Task8Encode.encode(sqrtN, hints, map);//applying all soduko restrictions
		boolean[] satSolution = SATSolver.getSolution();
		/*the code below checks if the given hints has soduko solution, if not,
		* it send the user the reason why there isn't a solution*/
		if(satSolution!=null && satSolution.length!=0) {
			board = Task9Decode.mapToBoard(map, n, satSolution);
			if (!Task5Verify.isSolution(sqrtN, hints, board)) {
				throw new IllegalStateException("Solution is illegal");
			}
		}
		else {
			if (satSolution == null)
				throw new IllegalStateException("Timeout");
			else
				System.out.println("null");
		}
		return board;
	}
}


