public class Driver{
	static Recursion rec = new Recursion();
	public static void main(String[]kirbySuperStuy){
		System.out.println(rec.fib(1));
		System.out.println(rec.fib(2));
		System.out.println(rec.fib(3));
		System.out.println(rec.fib(4));
		System.out.println(rec.fib(5));
		//my old email address had "11235" in it because I liked the fibonacci numbers
		//but I got a new one b/c everyone kept mistaking it as a zip code and asking if I lived in sheepshead bay
		System.out.println(rec.sqrt(100));
		System.out.println(rec.sqrt(2));
		double[]sqrtValues = {169.0,1.0,0.00000001,0.0,-100.0};
		int[] fibValues = {0,2,5,10,-1};
		int[] factValues = {0,1,5,-1};
		try{
			for(double z:sqrtValues){
				System.out.println(rec.sqrt(z));
			}		
			System.out.println("sqrt!");
			for(int z:fibValues){
				System.out.println(rec.fib(z));
			}
			System.out.println("fib!");
			for(int z:factValues){
				System.out.println(rec.fact(z));
			}
			System.out.println("fact!");
		}catch(IllegalArgumentException g){
			System.out.println("LOL");
		}
	}
}