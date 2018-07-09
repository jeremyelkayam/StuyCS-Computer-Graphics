import java.util.Stack;
public class Driver{
    public static void main(String[]vroomvroom){
	MyStack<String> lol=new MyStack<String>();
	System.out.println(lol.empty());
	System.out.println(lol.push("Hi"));
	lol.push("Yo");
	lol.push("Hello");
	System.out.println(lol.peek());
	System.out.println(lol.pop());
	System.out.println(lol.peek());
	System.out.println(lol.empty());
	System.out.println(lol.search("Yo"));
	MyQueue<String>g=new MyQueue<String>();
    }
}
