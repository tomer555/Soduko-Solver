
public class Task7Map {
	//Editor:Tomer Levy
	//ID:308427384
	//Last Edit: 30/11/2017
	/*This function below gets a specific
	 location in the 3 dimensional map matrix and
	returns by the formula below the variable number*/
	public static int varName(int i, int j, int k, int n) {
		int varName=(n*n)*i+(n*j)+k+1;
		return varName ;
	}
	/*This function takes the formula above
	 and applying arithmetic manipulations
	in order to find an index of a certain variable number*/
	public static int[] nameToIndex(int x, int n) {
		int i,j,k,t;
		int[]stack=new int [3];
		t=x-1;
		k=t%n;
		t=t-k;
		t=t/n;
		j=t%n;
		t=t-j;
		i=t/n;
		stack[0]=i;
		stack[1]=j;
		stack[2]=k;
		return stack ;
	}
	/*By given a number n this function builds
	 a new 3 dimensional matrix of a certain map*/
	public static int[][][] varsMap(int n) {
		int [][][]map=new int [n][n][n];
		int counter=1;
		for (int i=0;i<n;i=i+1)
			for (int j=0;j<n;j=j+1)
				for (int k=0;k<n;k=k+1) {
					map[i][j][k] = counter;
					counter = counter + 1;
				}
		return map ;
	}
}
