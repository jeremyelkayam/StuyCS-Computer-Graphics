public class Recursion{
	public String name(){
		return "Elkayam,Jeremy";
	}
	public int fact(int n){
		if(n<0)
			throw new IllegalArgumentException();
		if(n==1 || n==0)
			return n;
		return n*fact(n-1);
	}
	public int fib(int n){
		if(n<0)
			throw new IllegalArgumentException();
		if(n==1 || n==2)
			return 1;
		if(n==0)
			return n;
		return fib(n-1)+fib(n-2);
	}
	public double sqrt(double n){
		if(n<0)
			throw new IllegalArgumentException();
		return betterGuess(n,1,1*Math.pow(10,-10));//default precision is 10 decimal places
	}
	//Return a sqrt to the precision of the user's choice (a.k.a. the Mr. Holmes sqrt, Java edition)
	private double betterGuess(double n, double guess, double precision){
		if(Math.abs(guess*guess - n)< precision)
			return guess;
		return betterGuess(n, (n/guess+guess)/2, precision);
	}
}
