public class Driver{
    public static void main(String[]superArraysAreAwesome){
	SuperArray DeLorean=new SuperArray();
	String a = "Marty";
	String b = "Doc";
	Integer c= new Integer(88);//miles per hour
	Double d = new Double (1.21);//gigawatts
	try{
	    System.out.println(DeLorean);
	    DeLorean.add(a);
	    DeLorean.add(b);
	    System.out.println("OK!");
	    System.out.println(DeLorean);
	    print(DeLorean.get(1000));
	    DeLorean.add(0,c);
	    print(DeLorean);
	    DeLorean.add(1,d);
	    DeLorean.add("Einstein");//what happens to us in the future, do we become assholes or something?
	    DeLorean.add("Jennifer");//no, you and jennifer turn out perfectly fine. it's your children something's got to be done about!
	    print(DeLorean);
	    DeLorean.remove(DeLorean.size()-1);
	    DeLorean.remove(DeLorean.size()-1);//we can leave Einstein & Jennifer in this version of 1985, because once we get the sports almanac from Biff, the future will change around them!
	    print(DeLorean);
	}catch(IndexOutOfBoundsException z){
		System.out.println("Something messed up");
	    }
    }
    public static void print(Object a){//I'm freaking sick and tired of typing SYSTEM DOT OUT DOT PRINT LINE every single time I want to print something!!!!!! After this assignment I will add auto-complete stuff to emacs so this never happens again.
	System.out.println(a);
    }
}
