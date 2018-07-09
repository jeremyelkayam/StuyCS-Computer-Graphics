public class NQueens{
    
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    private char[][]board;
    public String name() {
	return "elkayam.jeremy";
    }
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException b) {
	}
    }

    public String toString(){
	String ans = "\n";
	for (int z=0; z<board.length; z++){
	    for (int g=0; g<board[z].length; g++){
		ans+=board[z][g]+" ";
	    }
	    ans+="\n";
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }
    public boolean solve(){
	for (int z=0; z<board.length; z++){
	    if (solve(z,0)){
		return true;
	    }
	}
	return false;
    }
    public boolean solve(int x){
	return solve(x,0);
    }
    public boolean solve(int x, int y){
	if(y == board.length){
	    return true;
	}else if(x<0 || y<0 || x>=board.length){
	    return false;
	} else {
	    board[y][x] = 'Q';
	    if (check(x,y,0,1) &&
		check(x,y,1,0) &&
		check(x,y,1,1) &&
		check(x,y,1,-1) &&
		check(x,y,0,-1) &&
		check(x,y,-1,0) &&
		check(x,y,-1,-1) &&
		check(x,y,-1,1)){
		for (int z=0;z<board[0].length;z++){
		    if (solve(z,y+1)){
			return true;
		    }
		}
		board[y][x]='_';
		return false;
	    }else{
		board[y][x]='_';
		return false;
	    }
	}
    }
    public boolean check(int x, int y, int h, int v){
    int queens=0;
	while (x<board.length-1 && y<board.length-1 && (x>0 || h==0) && (y>0 || v==0)){
	    x-=h;
	    y-=v;
	}
	while (x<board.length && y<board.length && x>=0 && y>=0){
	    if (board[y][x] == 'Q'){
		queens++;
	    }
	    x+=h;
	    y+=v;
	}
	return queens<=1;
    }
    public NQueens(int b){
	board=new char[b][b];
	for (int z=0;z<board.length;z++){
	    for (int g=0;g<board[z].length;g++){
		board[z][g] = '_';
	    }
	}
    }
    public static void main(String[]president){//the president has been kidnapped by ninjas.
	NQueens ninjas = new NQueens(5);//are you a bad enough dude to rescue the president?
	System.out.println(ninjas);	
	ninjas.solve();
	System.out.println(ninjas);
    }//wouldn't it be cool if this assignment were nNinjas?
}