public class Task6Cnf {
	//Editor:Tomer Levy
	//ID:308427384
	//Last Edit: 30/11/2017
    //This function below take all variables and just put them in a clause
    public static int[][] atLeastOne(int[] vars) {
        int n = 1;
        int[][] cnfOne = new int[1][vars.length];
        for (int i = 0; i < vars.length; i = i + 1)
            cnfOne[0][i] = vars[i];
        return cnfOne;
    }
    /*This function below put together in a cnf matrix
     all the possible pairs of variables in contrast*/
    public static int[][] atMostOne(int[] vars) {
        int n = vars.length;
        int skipper = 0;
        int[][] cnfMost = new int[((n * (n - 1)) / 2)][2];
        for (int i = 0; i < cnfMost.length; i = i + 1) {
            for (int j = i + 1; j < n; j = j + 1) {
                cnfMost[skipper][0] = -1 * vars[i];
                cnfMost[skipper][1] = -1 * vars[j];
                skipper = skipper + 1;
            }
        }
        return cnfMost;
    }
    /*This function below put together in a cnf matrix
         all the possible pairs of variables in contrast including
         extra clause from AtleastOne function*/
    public static int[][] exactlyOne(int[] vars) {
        int[][] numofpairs=atMostOne(vars);
        int numOfbaracks= numofpairs.length+1;
        int [][]cnfexactlyOne=new int[numOfbaracks][];
        cnfexactlyOne[0]=atLeastOne(vars)[0];
        for (int i=1;i<cnfexactlyOne.length;i=i+1)
            cnfexactlyOne[i] = numofpairs[i-1];
        return cnfexactlyOne;
    }
}