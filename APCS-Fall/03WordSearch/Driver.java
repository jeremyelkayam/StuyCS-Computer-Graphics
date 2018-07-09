import java.util.*;
public class Driver{
    static Random rand=new Random();
    public static void main(String[]args){
	WordGrid search;
	if(args.length==2){
	    search=new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]),true,rand.nextLong());
	}else if(args.length==3){
	    search=new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]),true,Integer.parseInt(args[2]));
	}else if(args.length==4){
	    if(Integer.parseInt(args[3])==1){
		search=new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]),false,Integer.parseInt(args[2]));
	    }else{
		search=new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]),true,Integer.parseInt(args[2]));
	    }
	}else{
	    search=new WordGrid(12,12,true,rand.nextLong());
	}
	System.out.println(search);
	System.out.println('a'=='a');
	char a='z';
	System.out.println(a=='z');//ok thought this would work and it does :)
    }
}
