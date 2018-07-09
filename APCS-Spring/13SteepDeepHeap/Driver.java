import java.util.*;
public class Driver{
    static MyHeap lol;
    static Random randy=new Random();
    public static void main(String[]noCreativeNameThisTime){
	lol=new MyHeap(true);
	lol.add(150);
	lol.add(300);
	lol.add(450);
	lol.remove();
	lol.remove();
	System.out.println(lol.peek());
    }
}
