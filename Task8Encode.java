public class Task8Encode {
	//Editor:Tomer Levy
	//ID:308427384
	//Last Edit: 30/11/2017
    public static void encode(int sqrtN, int[][] hints, int[][][] map) {
        int n=sqrtN*sqrtN;
        int npower3=n*n*n;
        SATSolver.init(npower3); //initialize the SAT with the given number power by 3
        int [][][]columnMap=mapColumn(map);
        int [][][]blocksMap=mapBlocks(map,sqrtN);
        /*This code below takes all hints and compare
         them to correspond variable in the matrix map
         and then transform it to a cnf matrix*/
        for (int i=0; i<hints.length;i=i+1) {
            int[] var = new int[1];
            var[0]=map[hints[i][0]][hints[i][1]][hints[i][2]-1];
            SATSolver.addClauses(Task6Cnf.atLeastOne(var));
        }
        /*applying all restrictions of the board by
         transforming the map matrix with other functions:
         all numbers in a row,column,block different from one another  */
        for(int i=0;i<map.length;i=i+1){
            int[][] row=TasksArrays.columns(map[i]);
            for(int j=0;j<map.length;j=j+1){
                SATSolver.addClauses(Task6Cnf.exactlyOne(row[j]));
                SATSolver.addClauses(Task6Cnf.exactlyOne(map[i][j]));
                SATSolver.addClauses(Task6Cnf.exactlyOne(columnMap[i][j]));
                SATSolver.addClauses(Task6Cnf.exactlyOne(blocksMap[i][j]));
            }
        }
    }
    /*This below function takes three dimensional
     matrix that represent the sudoko board and transform it to a new matrix
     that applies all the restrictions considering a specific block in the board*/
    public static int[][][] mapBlocks(int [][][] maps,int sqrt) {
        int n = maps.length;
        int[][][] mapBlocks = new int[n][n][n];
        int mJump,cJump;
        int rowCounter=-sqrt;
        int columnCounter=-sqrt;
        for (int i=0;i<n;i=i+1){
            columnCounter=columnCounter+sqrt;
            if(i%sqrt==0) {
                columnCounter=0;
                rowCounter=rowCounter+sqrt;
                cJump=0;
            }
            else
                cJump=columnCounter;
            for (int j=0;j<n;j=j+1){
                    mJump=rowCounter;
                for (int k=0;k<n;k=k+sqrt) {
                    for (int t = 0; t < sqrt &mJump<n &cJump<n; t = t + 1) {
                        mapBlocks[i][j][k + t] = maps[mJump][cJump + t][j];
                    }
                    mJump=mJump+1;
                }
            }
        }
        return mapBlocks;
    }

/*This below function takes three dimensional
     matrix that represent the sudoko board and transform it to a new matrix
     that applies all the restrictions considering a specific column in the board*/
    public static int[][][] mapColumn(int [][][] maps){
        int n = maps.length;
        int[][][] mapColumn = new int[n][n][n];
        int columnJump = -1;
        for (int i = 0; i < n; i = i + 1) {
            columnJump=columnJump+1;
            int block=-1;
            for (int j = 0; j < maps[i].length; j = j + 1) {
                int matrixJump = 0;
                block = block+1;

                for (int k = 0; k < maps[i][j].length; k = k + 1) {
                    mapColumn[i][j][k] = maps[matrixJump][columnJump][block];
                    matrixJump = matrixJump + 1;
                }
            }
        }
        return mapColumn;
    }


}
