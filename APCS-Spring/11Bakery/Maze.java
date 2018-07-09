import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    private final int DFS=1;
    private final int BFS=0;
    private final int BST=2;
    private final int AST=3;
    private MyDeque<Orpa>frontier=new MyDeque<Orpa>();
    private Orpa exit;
    public Maze(String filename){
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    
	    //keep reading next line
	    while(in.hasNext()){
		String line= in.nextLine();
		if(maxy==0){
		    //calculate width of the maze
		    maxx=line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans+=line;
	    }
	}
	catch(Exception e){//This is a bad idea and you told us that it was a bad idea -_-
	    System.out.println("File: "+filename+" could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	
	maze = new char[maxx][maxy];
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    if(c=='S'){
		startx = i%maxx;
		starty = i/maxx;
	    }else if(c=='E'){
		exit=new Orpa(i%maxx,i/maxx,null);
	    }
	}
	//System.out.println(exit);
	//System.out.println(maze[exit.getX()][exit.getY()]);
    }
    
    private String go(int x,int y){
	return ("["+x+";"+y+"H");
    }
    
    private String clear(){
	return  "[2J";
    }
    
    private String hide(){
	return  "[?25l";
    }
    
    private String show(){
	return  "[?25h";
    }
    private String invert(){
	return  "[37";
    }
    private String color(int foreground,int background){
	return("\033[1;"+foreground+";"+background+"m");
    }

    public void clearTerminal(){
	System.out.println(clear());
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    
    public String toString(){
	String ans = ""+maxx+","+maxy+"\n";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += maze[i%maxx][i/maxx];
	}
	return clear()+invert()+go(0,0)+ans+"\n\n"+show();
    }
    public boolean solveDFS(boolean anim8){
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}else{
	    maze[startx][starty]=' ';
	    return solveDFS(startx,starty,anim8);
	}
    }
    public boolean solveDFS(){
	return solveDFS(false);
    }
    public boolean solveDFS(int x,int y,boolean anim8){
	return solveMaster(x,y,DFS,anim8);
    }
    public boolean solveBFS(boolean anim8){
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}else{
	    maze[startx][starty]=' ';
	    return solveBFS(startx,starty,anim8);
	}
    }
    public boolean solveBFS(){
	return solveBFS(false);
    }
    public boolean solveBFS(int x,int y,boolean anim8){
	return solveMaster(x,y,BFS,anim8);
    }
    public boolean solveBest(int x,int y,boolean anim8){
	return solveMaster(x,y,BST,anim8);
    }
    public boolean solveBest(){
	return solveBest(false);
    }
    public boolean solveBest(boolean anim8){
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}else{
	    maze[startx][starty]=' ';
	    return solveBest(startx,starty,anim8);
	}
    }
    public boolean solveAStar(int x,int y,boolean anim8){
	return solveMaster(x,y,AST,anim8);
    }
    public boolean solveAStar(){
	return solveAStar(false);
    }
    public boolean solveAStar(boolean anim8){
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}else{
	    maze[startx][starty]=' ';
	    return solveAStar(startx,starty,anim8);
	}
    }
    
    private boolean solveMaster(int x, int y, int mode,boolean anim8){
	frontier.add(new Orpa(x,y,null));
	Orpa here=frontier.getFirst();
	while(maze[here.getX()][here.getY()]!='E'){
	    if(anim8){
		System.out.println(this);
		System.out.println("\nFrontier: "+frontier);
		wait(50);
	    }
	    if(mode==BFS){//yeah I tried to do a switch statement here but some fucked up shit started happening that I couldn't explain
		//System.out.println("Remove First");//like, that gunk was ill.
		here=frontier.removeFirst();
	    }else if(mode==DFS){
		//System.out.println("Remove Last");
		here=frontier.removeLast();
	    }else if(mode==BST || mode==AST){
		here=frontier.removeSmallest();
	    }
	    //System.out.println(here);
	    if(maze[here.getX()][here.getY()]!='E'){
		goFromHere(here,mode);
	    }
	    //System.out.println("Hi");
	}
	//System.out.println("Done");
	if(maze[here.getX()][here.getY()]=='E'){
	    markPath(here);
	    System.out.println(this);
	    System.out.println(here.toStringDeep());
	    System.out.println("Moves: "+here.moves());
	    System.out.println(Arrays.toString(solutionCoordinates(here)));
	    return true;
	}
	return false;
    }
    private void goFromHere(Orpa here,int mode){
	int x=here.getX();
	int y=here.getY();
	maze[x][y]='C';//for CHECK'D
	maze[startx][starty]='S';
	//System.out.println(here);
	Orpa passMe;
	if(maze[x+1][y]==' '||maze[x+1][y]=='E'){
	    passMe = new Orpa(x+1,y,here);
	    if(mode==BST){
		frontier.add(passMe,passMe.manDist(exit));
	    }else if(mode==AST){
		frontier.add(passMe,passMe.manDist(exit)+passMe.moves());
	    }else if(mode==BFS ||mode==DFS){
		frontier.add(passMe);
	    }
	}
	if(maze[x-1][y]==' '||maze[x-1][y]=='E'){
	    passMe = new Orpa(x-1,y,here);
	    if(mode==BST){
		frontier.add(passMe,passMe.manDist(exit));
	    }else if(mode==AST){
		frontier.add(passMe,passMe.manDist(exit)+passMe.moves());
	    }else if(mode==BFS ||mode==DFS){
		frontier.add(passMe);
	    }
	}
	if(maze[x][y+1]==' '||maze[x][y+1]=='E'){
	    passMe = new Orpa(x,y+1,here);
	    switch(mode){
	    case BST:
		frontier.add(passMe,passMe.manDist(exit));
	    case AST:
		frontier.add(passMe,passMe.manDist(exit)+passMe.moves());
	    default: 
		frontier.add(passMe);
	    }
	}
	if(maze[x][y-1]==' '||maze[x][y-1]=='E'){
	    passMe = new Orpa(x,y-1,here);
	    if(mode==BST){
		frontier.add(passMe,passMe.manDist(exit));
	    }else if(mode==AST){
		frontier.add(passMe,passMe.manDist(exit)+passMe.moves());
	    }else if(mode==BFS ||mode==DFS){
		frontier.add(passMe);
	    }
	}
    }
    public int[]solutionCoordinates(Orpa last){
	//System.out.println(last.toStringDeep());
	int[]result;
	int moves=0;
	Orpa current=last;
	while(current!=null){
	    moves++;
	    current=current.getPrevious();
	    //System.out.println(current);
	}
	current=last;
	result=new int[moves*2];
	int dex=result.length-1;
	while(current!=null){
	    //System.out.println("Does this start?");
	    result[dex]=current.y;
	    dex--;
	    result[dex]=current.x;
	    dex--;
	    current=current.getPrevious();
	}
	//System.out.println("Done2");
	return result;
    }
    private void markPath(Orpa last){
	Orpa current=last;
	int lol=0;
	while(current!=null){
	    if(maze[current.getX()][current.getY()]=='C'){
		maze[current.getX()][current.getY()]='P';//for PATH
	    }
	    current=current.getPrevious();
	    //System.out.println("still goin "+lol);
	    lol++;
	}
	for(int z=0;z<maze.length;z++){
	    for(int g=0;g<maze[0].length;g++){
		if(maze[z][g]=='C' || maze[z][g]=='F'){
		    maze[z][g]=' ';
		}
	    }
	}
    }
    public String name(){
	return "jeremy.elkayam";
    }
    private class Orpa{//short for ordered pair
	int x;
	int y;
	Orpa previous;
	int moves;
	public Orpa(int h,int k, Orpa prev){
	    x=h;
	    y=k;
	    previous=prev;
	    try{
		moves=getPrevious().moves()+1;
	    }catch (NullPointerException e){
		moves=0;
	    }
	    if(maze[getX()][getY()]!='E')
		maze[getX()][getY()]='F';//for FRONTIER
	}
	public int getX(){
	    return x;
	}
	public int getY(){
	    return y;
	}
	public Orpa getPrevious(){
	    return previous;
	}
	public String toString(){
	    return "("+getX()+","+getY()+")";
	}
	public String toStringDeep(){
	    if(getPrevious()==null)
		return toString();
	    return toString()+getPrevious().toStringDeep();
	}
	public int moves(){
	    return moves;
	}
	public int manDist(Orpa block){//manhattan distance
	    return Math.abs(block.getX()-getX())+Math.abs(block.getY()-getY());
	}
    }
}
