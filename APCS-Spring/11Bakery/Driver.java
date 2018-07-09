import java.util.Scanner;
public class Driver{
    static Maze beef;
    String filename;
    public static void main(String[]args){
	if(args.length==0){
	    String[]yo= {"1","D","0"};
	    args=yo;
	}else if(args.length==1){
	    String[]yo= {args[0],"D","0"};
	    args=yo;
	}else if(args.length==2){
	    String[]yo= {args[0],args[1],"0"};
	args=yo;
	}
	try{
	    beef=new Maze("data"+args[0]+".dat");
	    //System.out.println("LOL");
	}catch(Exception e){//wouldn't let me catch the FileNotFoundException
	    beef=new Maze("data1.dat");
	}
	//System.out.println("LOL");
	boolean anim8=args[2].equals("1");
	if(args[1].equals("D")){
	    beef.solveDFS(anim8);
	}else if(args[1].equals("B")){
	    beef.solveBFS(anim8);
	}else if(args[1].equals("E")){//bEst
	    beef.solveBest(anim8);
	}else if(args[1].equals("A")){
	    beef.solveAStar(anim8);
	}/*
	MyDeque<String> priorityQ=new MyDeque<String>();
	//System.out.println(priorityQ);
	priorityQ.add("ten",10);
	priorityQ.add("two",2);
	priorityQ.add("three",3);
	priorityQ.add("four",4);
	priorityQ.add("five",5);
	priorityQ.add("eleven",11);
	//System.out.println(priorityQ);
	priorityQ.removeSmallest();
	//System.out.println(priorityQ);
	*/
    }
}
