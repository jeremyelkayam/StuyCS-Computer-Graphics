public class Driver{
    static KnightsTour b;
    public static void main(String[]args){
	if(args.length<0){
	    b=new KnightsTour(Integer.parseInt(args[0]));
	}else{
	    b=new KnightsTour(5);
	}
	if(b.solve()){
	    System.out.println(b);
	}
    }
}
