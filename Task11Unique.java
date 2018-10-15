public class Task11Unique {
	//Editor:Tomer Levy
	//ID:308427384
	//Last Edit: 30/11/2017
	/*Whatever if the sat solver has more then one solution. the function makes a new cnf that contradicts
	 the first solution ,if after applying the new cnf the sat finds another
	 solution to the given hints,it has multi solutions*/
	public static int [][] solveUnique(int sqrtN, int[][] hints) {
		int[][] solveUnique=Task10Solve.solve(sqrtN,hints);//must get normal solution-
		boolean []solution=SATSolver.getSolution();		//otherwise will get "throw" from Task10
		if(solution==null||solution.length==0)
			throw new IllegalArgumentException("No Solution");
		int[]newCnf=new int[solution.length-1];
		int [][][]map=Task7Map.varsMap(sqrtN*sqrtN);
		int[][]newBoard=null;
		for (int i=1; i<solution.length;i=i+1){
			if (solution[i])
				newCnf[i-1] = -1*i;
			else
				newCnf[i-1] = i;
			}
		Task8Encode.encode(sqrtN,hints,Task7Map.varsMap(sqrtN*sqrtN));
		SATSolver.addClause(newCnf);
		boolean []newSolution=SATSolver.getSolution();
		if(newSolution==null)
			throw new RuntimeException("Timeout");
		if(newSolution.length!=0){
			newBoard=Task9Decode.mapToBoard(map,sqrtN*sqrtN,newSolution);
			if(Task5Verify.isSolution(sqrtN,hints,newBoard))
				solveUnique=null;
		}
		return solveUnique;
	}
}

