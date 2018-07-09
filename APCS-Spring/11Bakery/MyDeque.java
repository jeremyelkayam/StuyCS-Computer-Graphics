import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Deque;
public class MyDeque<T>{//all hands on deque
    Object[]content=new Object[10];
    int[]priors=new int[10];
    int h=5;//You heard right, I'm building a deque.
    int t=4;//Using galvanized nails!
    //jeremy, are you using galvanized nails to hide the fact that you don't know how to build a deque?
    //I DO KNOW HOW TO BUILD A DEQUE. SEE BELOW
    public void addFirst(T value){
	//System.out.println(h);
	if(h==0){
	    embiggen();
	    //System.out.println("Let's do this!");
	}
	h--;
	content[h]=value;
    }
    public void addLast(T value){
	if(t==content.length-1)
	    embiggen();
	t++;
	content[t]=value;
    }
    public void addLast(T value,int priority){
	if(t==content.length-1)
	    embiggen();
	t++;
	content[t]=value;
	priors[t]=priority;
    }
    public T removeFirst(){
	if(h==t+1)
	    throw new NoSuchElementException("You are a sad, strange little man and you have my pity.");
	T g=(T)content[h];
	content[h]=null;
	h++;
	return g;
    }
    public T removeLast(){
	if(t==h-1)
	    throw new NoSuchElementException("Your mother was a hamster and your father smelt of elderberry! I fart in your general direction!!!");
	T g=(T)content[t];
	content[t]=null;
	t--;
	return g;
    }
    public T removeSmallest(){
	if(t-h<0){
	    throw new NoSuchElementException("Real System Message: Everything is fine. Nothing is ruined.");
	}
	int min=priors[h];
	int mindex=h;
	for(int z=h;z<=t;z++){
	    if(min>priors[z]){
		min=priors[z];
		mindex=z;
	    }
	}
	Object result=content[mindex];
	content[mindex]=content[t];
	priors[mindex]=priors[t];
	content[t]=null;
	priors[t]=0;
	t--;
	return (T)result;
    }
    public T getFirst(){
	if(h==t+1)
	    throw new NoSuchElementException();
	return (T)content[h];
    }
    public T getLast(){
	if(h==t+1)
	    throw new NoSuchElementException();
	return (T)content[t];
    }
    private void embiggen(){
	int newSize=content.length*2;
	Object[]news=new Object[newSize];
	int[]newps=new int[newSize];
	int ci;
	int ni=newSize/4+h;
	for(ci=h;ci<=t;ci++){
	    news[ni]=content[ci];
	    newps[ni]=priors[ci];
	    ni++;
	    //System.out.println("LOL");
	    //System.out.println(ci);
	    //System.out.println(ni);
	}
	//System.out.println(ni);
	t=ni-1;
	h=newSize/4+h;
	content=news;
	priors=newps;//whoops LOL
    }
    public String toString(){
	//System.out.println("h="+h+"\nt="+t);
	//System.out.println(Arrays.toString(content));
	//System.out.println(Arrays.toString(priors));
	String result="";
	for(int z=h;z<=t;z++){
	    result+=content[z]+"\t";
	    //System.out.println("LOL");
	}
	if(priors[h]>0){
	    result+="\n";
	    for(int z=h;z<=t;z++){
		result+=priors[z]+"\t";
		//System.out.println("LOL");
	    }
	}
	return result;
    }
    public String name(){
	return "elkayam.jeremy";
    }
    public void add(T g){
	addLast(g);
    }
    public void add(T g, int b){
	addLast(g,b);
    }
}
