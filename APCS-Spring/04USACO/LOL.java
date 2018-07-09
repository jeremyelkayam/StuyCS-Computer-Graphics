public class LOL{
    int rows;
    int cols;
    char[][]grid;
    public static void main(String[]rofl){
	grid={{},
	      {},
	      {}}
    }
    public static int numWays(int r1,int c1,int r2,int c2,int t,int maxr, int maxc){
	int result=0;
	if(r1>=maxr ||c1>=maxc)
	    return 0;
	if(t==0){
	    if(r1==r2 && c1==c2)
		return 1;
	    return 0;
	}//remember to make sure it doesn't go off the edge
	result+=(numWays(r1+1,c1,r2,c2,t-1,maxr,maxc)+
		 numWays(r1-1,c1,r2,c2,t-1,maxr,maxc)+
		 numWays(r1,c1+1,r2,c2,t-1,maxr,maxc)+
		 numWays(r1,c1-1,r2,c2,t-1,maxr,maxc));
	return result;
    }
    public static int makeLake(int row, int col, int depth){
	int z, g, q, highest;
	for (z = 0; z < deep; z++) {
	    highest = lake[row][col];
	    for (i = 0; i < 3; i++)
		for (j = 0; j < 3; j++)
		    if (lake[row+i][col+j] > highest) 
			highest=lake[row+i][col+j];
	    /* -1 for each of highest */
	    for (i = 0; i < 3; i++)
		for (j = 0; j < 3; j++)
		    if (lake[row+i][col+j] == highest) 
			lake[row+i][col+j]--;
	}
    }
}
