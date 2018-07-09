import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    
    //instance variable
    private int[][]board;
    
    
    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    public String name(){
	return "elkayam.jeremy";
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans="";
	for(int[]row : board){
	    ans+="\n";
	    for(int z : row){
		if(z<100){
		    ans+=" ";
		}
		if(z<10){
		    ans+=" ";
		}
		ans+=z;
	    }
	}
	return hide+ clear + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int g){
	board=new int[g][g];
    }

    
    public boolean solve(){
	return solve(0,0,1);			
    }

    public boolean solve(int startx, int starty){
	return solve(startx,starty,1);
    }


		
    public boolean solve(int x,int y,int move){
	//System.out.println(this);
	//System.out.println(move);
	//wait(20);
	if(move==board.length*board[0].length+1){
	    return true;
	}
	if(x<0 || x>=board.length || y<0 || y>=board[0].length || board[y][x]>0){
	    return false;
	}
	board[y][x]=move;
	if(   solve(x + 2, y + 1, move + 1)
	   || solve(x + 1, y + 2, move + 1)
	   || solve(x + 2, y - 1, move + 1)
	   || solve(x + 1, y - 2, move + 1)
	   || solve(x - 2, y + 1, move + 1)
	   || solve(x - 1, y + 2, move + 1)
	   || solve(x - 2, y - 1, move + 1)
	   || solve(x - 1, y - 2, move + 1)){
	    return true;
	}
	board[y][x]=0;
	return false;
    }
}